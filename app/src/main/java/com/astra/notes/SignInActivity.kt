package com.astra.notes

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignInActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    private lateinit var loginbtn: Button
    private lateinit var signupredirect: TextView
    lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        var view = findViewById<View>(R.id.LayoutSingIn)
        var textView = findViewById<TextView>(R.id.textView)
        var textRegister = findViewById<TextView>(R.id.noaccount)
        var textMail = findViewById<TextView>(R.id.Email)
        var textPass = findViewById<TextView>(R.id.password)
        var viewImageDark = findViewById<View>(R.id.imageView2)
        var viewImageLight = findViewById<View>(R.id.imageView16)

        ColorController.setThemeDarkLight(MainActivity.globalDark, view, textView, viewImageLight, viewImageDark)
        ColorController.setThemeView(MainActivity.globalDark, textRegister)
        ColorController.setThemeView(MainActivity.globalDark, textMail)
        ColorController.setThemeView(MainActivity.globalDark, textPass)

        email = findViewById(R.id.Email)
        password = findViewById(R.id.password)
        loginbtn = findViewById(R.id.loginbtn)
        signupredirect = findViewById(R.id.noaccount)
        auth = Firebase.auth

        loginbtn.setOnClickListener {
            if (email.text.toString().isEmpty() || password.text.toString().isEmpty()) {
                Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            login().addOnCompleteListener {
                if (it.isSuccessful) {
                    val user = auth.currentUser
                    load(user)
                }
                else {
                    Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                }
            };
        }

        signupredirect.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    fun login(): Task<AuthResult> {
        return auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString());
    }

    //Ver si alguien ya tiene la sesión iniciada
    public override fun onStart() {
        super.onStart()
        val user = auth.currentUser
        if (user != null) {
            load(user);
        }
    }

    private fun load(user: FirebaseUser?) {
        Toast.makeText(this, "Authentication successful", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}