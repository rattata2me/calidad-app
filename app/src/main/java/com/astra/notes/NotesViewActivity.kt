package com.astra.notes

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.card.MaterialCardView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_notes_view.*
import kotlinx.android.synthetic.main.activity_notes_view.subtitle_tv
import kotlinx.android.synthetic.main.activity_notes_view.title_tv
import kotlinx.android.synthetic.main.product_layout.*
import kotlinx.android.synthetic.main.product_layout.view.*
import java.io.Serializable

class NotesViewActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()


    lateinit var noteName: String
    lateinit var noteSubtitle: String
    lateinit var id: String
    lateinit var color: String
    lateinit var userID: ArrayList<String>
    lateinit var products: ArrayList<String>
    lateinit var amounts: ArrayList<Int>
    lateinit var checks: ArrayList<Boolean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_view)

        var view = findViewById<View>(R.id.LayoutNoteView)
        var viewImageDark = findViewById<View>(R.id.imageView4)
        var viewImageLight = findViewById<View>(R.id.imageView5)

        ColorController.setThemeDarkLight(MainActivity.globalDark, view, null, viewImageLight, viewImageDark)

        val extras = intent.extras
        noteName = extras!!.getString("name").toString()
        noteSubtitle = extras?.getString("subtitle").toString()
        id = extras?.getString("id").toString()
        color = extras?.getString("color").toString()
        userID = extras?.get("iduser") as ArrayList<String>
        products = extras?.get("products") as ArrayList<String>
        amounts = extras?.get("amounts") as ArrayList<Int>
        checks = extras?.get("checks") as ArrayList<Boolean>
        val card_vw: MaterialCardView = findViewById(R.id.CardView)

        card_vw.setBackgroundColor(Color.parseColor(color)) // Establece el color de la nota que esta guardado en la base de datos

        title_tv.setText(noteName)
        subtitle_tv.setText(noteSubtitle)
        prod_rv.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@NotesViewActivity)
            adapter = ProductAdapter(this@NotesViewActivity, products, amounts as ArrayList<Int>, checks) // Llama al recyclerview de los productos
        }

        imageView4.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        imageView5.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        add_btn.setOnClickListener {
            products.add("")
            amounts.add(1)
            checks.add(false)
            noteName = title_tv.text.toString()
            noteSubtitle = subtitle_tv.text.toString()
            // Guardar los cambios en los productos y cantidades
            for (i in 0 until prod_rv.childCount) {
                products[i] = prod_rv.getChildAt(i).product_name.text.toString()
                amounts[i] = prod_rv.getChildAt(i).amount_num.text.toString().toInt()
                checks[i] = prod_rv.getChildAt(i).product_check.isChecked
            }
            val note = hashMapOf(
                "Name" to noteName,
                "Subtitle" to noteSubtitle,
                "Products" to products,
                "Amount" to amounts,
                "Checks" to checks,
                "Color" to color,
                "UserID" to userID
            )
            db.collection("Notes").document(id!!).set(note)
                .addOnSuccessListener {
                }
                .addOnFailureListener {
                    Utils.showError(this, it.message.toString())
                }
            val intent = Intent(this, NotesViewActivity::class.java)
            val intent2 =  codigorepetido(intent, id,color,noteName,noteSubtitle,products,amounts,userID,checks)

            startActivity(intent2)
        }

        save_btn.setOnClickListener {
            noteName = title_tv.text.toString()
            noteSubtitle = subtitle_tv.text.toString()
            // Guardar los cambios en los productos y cantidades
            for (i in 0 until prod_rv.childCount) {
                products[i] = prod_rv.getChildAt(i).product_name.text.toString()
                amounts[i] = prod_rv.getChildAt(i).amount_num.text.toString().toInt()
                checks[i] = prod_rv.getChildAt(i).product_check.isChecked
            }
            val note = hashMapOf(
                "Name" to noteName,
                "Subtitle" to noteSubtitle,
                "Products" to products,
                "Amount" to amounts,
                "Checks" to checks,
                "Color" to color,
                "UserID" to userID
            )
            db.collection("Notes").document(id!!).set(note)
                .addOnSuccessListener {
                    Toast.makeText(this, "Changes saved", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Utils.showError(this, it.message.toString())
                }
        }

        save_copy_btn.setOnClickListener {
            noteName = title_tv.text.toString()
            noteSubtitle = subtitle_tv.text.toString()
            // Guardar los cambios en los productos y cantidades
            for (i in 0 until prod_rv.childCount) {
                products[i] = prod_rv.getChildAt(i).product_name.text.toString()
                amounts[i] = prod_rv.getChildAt(i).amount_num.text.toString().toInt()
                checks[i] = prod_rv.getChildAt(i).product_check.isChecked
            }
            val note = copyNote(noteName, noteSubtitle, products, amounts, checks, color, userID);
            db.collection("Notes").add(note)
                .addOnSuccessListener {
                    Toast.makeText(this, "Copied note", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Utils.showError(this, it.message.toString())
                }
        }


    }

    companion object {
        fun noteHashMap(noteName: String, noteSubtitle: String, products: ArrayList<String>,
                        amounts: ArrayList<Int>, checks: ArrayList<Boolean>, color: String,
                        userID: ArrayList<String>): HashMap<String, Serializable> = hashMapOf(
            "Name" to noteName,
            "Subtitle" to noteSubtitle,
            "Products" to products,
            "Amount" to amounts,
            "Checks" to checks,
            "Color" to color,
            "UserID" to userID
        );
        public fun copyNote(noteName: String, noteSubtitle: String, products: ArrayList<String>,
                            amounts: ArrayList<Int>, checks: ArrayList<Boolean>, color: String,
                            userID: ArrayList<String>): HashMap<String, Serializable> {

            return noteHashMap(noteName+"- Copy", noteSubtitle, products, amounts, checks, color, userID);
        }

    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.note_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.share ->{
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, id)
                    type = "text/plain"
                }
                startActivity(sendIntent)
            }
            R.id.delete ->{
                db.collection("Notes").document(id).delete().
                addOnSuccessListener {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                    .addOnFailureListener{
                        Utils.showError(this, it.message.toString())
                    }
            }
            R.id.change_color ->{
                val intent = Intent(this, ChangeColorActivity::class.java)
                val intent2 =  codigorepetido(intent, id,color,noteName,noteSubtitle,products,amounts,userID,checks)

                startActivity(intent2)
            }
        }
        return super.onOptionsItemSelected(item)
    }
    private fun codigorepetido(intent: Intent,id: String?,color:String?,noteName : String?,noteSubtitle: String?, products: ArrayList<String>,amounts :ArrayList<Int>,userID: ArrayList<String>, checks: ArrayList<Boolean>): Intent
    {
        intent.putExtra("id", id)
        intent.putExtra("name", noteName)
        intent.putExtra("color", color)
        intent.putExtra("subtitle", noteSubtitle)
        intent.putExtra("products", products)
        intent.putExtra("amounts", amounts)
        intent.putExtra("checks", checks)
        intent.putExtra("iduser", userID)
        return intent


    }
}
