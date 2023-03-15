package com.astra.notes

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_change_color.*

class ChangeColorActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_color)

        var view = findViewById<View>(R.id.LayoutChangeColor)
        var textView = findViewById<View>(R.id.textView6)
        var viewImageDark = findViewById<View>(R.id.imageView10)
        var viewImageLight = findViewById<View>(R.id.imageView11)

        if (MainActivity.globalDark) {
            view.setBackgroundColor(Color.parseColor("#FF000000"))
            textView.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
            viewImageLight.setVisibility(View.GONE)
            viewImageDark.setVisibility(View.VISIBLE)
        } else {
            view.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
            textView.setBackgroundColor(Color.parseColor("#FF000000"))
            viewImageLight.setVisibility(View.VISIBLE)
            viewImageDark.setVisibility(View.GONE)
        }

        imageView10.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        imageView11.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        var red: Button = findViewById(R.id.red_btn)
        var blue: Button = findViewById(R.id.blue_btn)
        var yellow: Button = findViewById(R.id.yellow_btn)
        var green: Button = findViewById(R.id.green_btn)
        val extras = intent.extras
        val noteId = extras?.getString("id")
        val noteName = extras?.getString("name")
        val userID = extras?.get("iduser") as ArrayList<String>
        val noteSubtitle = extras?.getString("subtitle")
        val products = extras?.get("products") as ArrayList<String>
        val amounts = extras.get("amounts") as ArrayList<Int>

        red.setOnClickListener {
            db.collection("Notes").document("$noteId").update("Color", "#CB0900")
                .addOnSuccessListener {
                    val intent = Intent(this, NotesViewActivity::class.java)
                    intent.putExtra("color", "#CB0900")
                    val intent2 = codigorepetido(intent,noteName,noteSubtitle,products,amounts,userID)

                    startActivity(intent2)
                }
                .addOnFailureListener {
                    Utils.showError(this, it.message.toString())
                }
        }

        blue.setOnClickListener {
            db.collection("Notes").document("$noteId").update("Color", "#074AA3")
                .addOnSuccessListener {
                    val intent = Intent(this, NotesViewActivity::class.java)

                    intent.putExtra("color", "#074AA3")
                    val intent2 = codigorepetido(intent,noteName,noteSubtitle,products,amounts,userID)

                    startActivity(intent2)
                }
                .addOnFailureListener {
                    Utils.showError(this, it.message.toString())
                }
        }

        yellow.setOnClickListener {
            db.collection("Notes").document("$noteId").update("Color", "#F0D804")
                .addOnSuccessListener {
                    val intent = Intent(this, NotesViewActivity::class.java)

                    intent.putExtra("color", "#F0D804")
                    val intent2 = codigorepetido(intent,noteName,noteSubtitle,products,amounts,userID)

                    startActivity(intent2)
                }
                    .addOnFailureListener {
                            Utils.showError(this, it.message.toString())
                        }
                }

            green.setOnClickListener {
                db.collection("Notes").document("$noteId").update("Color", "#328A10")
                    .addOnSuccessListener {
                        val intent = Intent(this, NotesViewActivity::class.java)

                        intent.putExtra("color", "#CB0900")
                        val intent2 = codigorepetido(intent,noteName,noteSubtitle,products,amounts,userID)

                        startActivity(intent2)

                    }
                    .addOnFailureListener {
                        Utils.showError(this, it.message.toString())
                    }
            }

        }

    private fun codigorepetido(intent: Intent,noteName : String?,noteSubtitle: String?, products: ArrayList<String>,amounts :ArrayList<Int>,userID: ArrayList<String>): Intent{
        intent.putExtra("name", noteName)
        intent.putExtra("subtitle", noteSubtitle)
        intent.putExtra("products", products)
        intent.putExtra("amounts", amounts)
        intent.putExtra("iduser", userID)
        return intent
    }
}