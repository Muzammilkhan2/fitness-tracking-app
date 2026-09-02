package com.example.fitnesstracker

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditProfileActivity : AppCompatActivity() {

    private lateinit var nameInput: EditText
    private lateinit var emailInput: EditText
    private lateinit var saveButton: Button
    private lateinit var dbHelper: UserDatabaseHelper
    private lateinit var session: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        dbHelper = UserDatabaseHelper(this)
        session = SessionManager(this)

        nameInput = findViewById(R.id.editNameInput)
        emailInput = findViewById(R.id.editEmailInput)
        saveButton = findViewById(R.id.saveProfileButton)

        val currentName = session.getUserName()
        val currentEmail = session.getUserEmail()

        nameInput.setText(currentName)
        emailInput.setText(currentEmail)

        saveButton.setOnClickListener {
            val newName = nameInput.text.toString().trim()
            val newEmail = emailInput.text.toString().trim()

            if (newName.isEmpty() || newEmail.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val success = dbHelper.updateUserProfile(currentEmail, newName, newEmail)
            if (success) {
                session.saveSession(newName, newEmail)
                Toast.makeText(this, "Profile updated successfully!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Update failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
