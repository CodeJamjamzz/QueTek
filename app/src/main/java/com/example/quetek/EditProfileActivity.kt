package com.example.quetek

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text
class EditProfileActivity : Activity() {

    @SuppressLint("MissingInflatedId")
    fun String.isEmailValid(): Boolean {
        val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
        return emailRegex.toRegex().matches(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val backProfileButton = findViewById<Button>(R.id.backProfileButton)
        val username = findViewById<EditText>(R.id.usernameInput)
        val email = findViewById<EditText>(R.id.emailInput)
        val usernameDisplay = findViewById<TextView>(R.id.usernameDisplay)
        val emailDisplay = findViewById<TextView>(R.id.emailDisplay)

        val updateButton = findViewById<Button>(R.id.updateButton)
        backProfileButton.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        var usernamePassed = intent.getStringExtra("username") ?: "John Doe"
        var emailPassed = intent.getStringExtra("email") ?: "johndoe@gmail.com"
        usernameDisplay.text = usernamePassed
        emailDisplay.text = emailPassed
        username.setText(usernamePassed)
        email.setText(emailPassed)


        updateButton.setOnClickListener {
            when {
                username.text.isNullOrBlank() && email.text.isNullOrBlank()-> {
                    Toast.makeText(this, "cannot update if empty", Toast.LENGTH_LONG).show()
                    finish()
                }
            }

            val intent = Intent(this, ProfileActivity::class.java)
            when {
                !username.text.isNullOrBlank() -> {
                    intent.putExtra("username", username.text.toString());
                }
            }

            when {
                !email.text.isNullOrBlank() && email.text.toString().isEmailValid() -> {
                    intent.putExtra("email", email.text.toString());
                }
                else -> {Toast.makeText(this, "Invalid input please try again", Toast.LENGTH_LONG).show()}
            }

            username.setText("")
            email.setText("")
            startActivity(intent)
        }

    }
}