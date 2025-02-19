package com.example.quetek

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.imageview.ShapeableImageView

class ProfileActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_profile)
        val backButton = findViewById<Button>(R.id.backButton)
        val editProfileButton = findViewById<Button>(R.id.editProfile)
        val settingsButton = findViewById<Button>(R.id.settingsButton)
        val logoutButton = findViewById<Button>(R.id.logoutButton)
        val profile = findViewById<ShapeableImageView>(R.id.profilePicture)

        var usernameDisplay = findViewById<TextView>(R.id.usernameDisplay)
        var emailDisplay = findViewById<TextView>(R.id.emailDisplay)
        var username = intent.getStringExtra("username") ?: "John Doe"
        var email = intent.getStringExtra("email") ?: "johndoe@gmail.com"

        usernameDisplay.text = username
        emailDisplay.text = email

        backButton.setOnClickListener {
            Log.e("ProfileActivity", "will go back to my partner's page")
            Toast.makeText(this, "will go back to my partner's page", Toast.LENGTH_LONG).show()
            return@setOnClickListener
        }

        editProfileButton.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            intent.putExtra("username", username)
            intent.putExtra("email", email)
            startActivity(intent)
        }

        settingsButton.setOnClickListener {
            Toast.makeText(this, "Settings clicked,  this will be handled by my partner", Toast.LENGTH_SHORT).show()
        }

        logoutButton.setOnClickListener {
            var logout = AlertDialog.Builder(this).setTitle("Logout Accout").setMessage("Are you sure you want to log out? Please confirm your action.")
                .setPositiveButton("Confirm") { dialog, which ->
                    Toast.makeText(this, "Confirm clicked,  this will go back to login", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel") { dialog, which ->
                    dialog.dismiss()
                }
                .create()
            logout.show()
        }
    }
}
