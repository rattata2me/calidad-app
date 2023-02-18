package com.astra.notes

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onStart() {
        super.onStart()

        val currentUser = auth.currentUser
        if(currentUser != null) {
            // Go to the screen after sign in
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var view = findViewById<View>(R.id.LinearLayout)
        var textView1 = findViewById<TextView>(R.id.register_title)
        var textView2 = findViewById<TextView>(R.id.register_email_title)
        var textView3 = findViewById<TextView>(R.id.register_passwod_title)
        var textRegisterMail = findViewById<TextView>(R.id.register_email)
        var textRegisterPass = findViewById<TextView>(R.id.register_password)

        if(MainActivity.globalDark){
            view.setBackgroundColor(Color.parseColor("#FF000000"))
            textView1.setTextColor(Color.parseColor("#FFFFFFFF"))
            textView2.setTextColor(Color.parseColor("#FFFFFFFF"))
            textView3.setTextColor(Color.parseColor("#FFFFFFFF"))
            textRegisterMail.setTextColor(Color.parseColor("#FFFFFFFF"))
            textRegisterPass .setTextColor(Color.parseColor("#FFFFFFFF"))
        }else{
            view.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
            textView1.setTextColor(Color.parseColor("#FF000000"))
            textView2.setTextColor(Color.parseColor("#FF000000"))
            textView3.setTextColor(Color.parseColor("#FF000000"))
            textRegisterMail.setTextColor(Color.parseColor("#FF000000"))
            textRegisterPass .setTextColor(Color.parseColor("#FF000000"))
        }

        auth = Firebase.auth

        val errorMessage = findViewById<TextView>(R.id.register_error_message)
        errorMessage.visibility = View.GONE

        val emailInput = findViewById<EditText>(R.id.register_email)
        val passwordInput = findViewById<EditText>(R.id.register_password)
        val registerButton = findViewById<Button>(R.id.register_button)

        registerButton.setOnClickListener {
            createAccount(emailInput.text.toString(), passwordInput.text.toString(), errorMessage)
        }

        login_button.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }

    private fun createAccount(email: String, password: String, errorMessage: TextView) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    errorMessage.visibility = View.GONE
                    val user = auth.currentUser
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    errorMessage.visibility = View.VISIBLE
                    // Show error
                }
            }
    }
}