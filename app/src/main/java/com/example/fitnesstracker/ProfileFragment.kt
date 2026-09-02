package com.example.fitnesstracker

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val profileName: TextView = view.findViewById(R.id.profileName)
        val profileEmail: TextView = view.findViewById(R.id.profileEmail)
        val detailName: TextView = view.findViewById(R.id.detailName)
        val detailEmail: TextView = view.findViewById(R.id.detailEmail)
        val avatarInitial: TextView = view.findViewById(R.id.avatarInitial)
        val editProfileButton: Button = view.findViewById(R.id.editProfileButton)
        val logoutButton: Button = view.findViewById(R.id.logoutButton)

        val session = SessionManager(requireContext())
        updateUI(view, session)

        editProfileButton.setOnClickListener {
            val intent = Intent(requireContext(), EditProfileActivity::class.java)
            startActivity(intent)
        }

        logoutButton.setOnClickListener {
            // Confirmation Dialog
            androidx.appcompat.app.AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Are you sure you want to logout?")
                .setPositiveButton("Logout") { _, _ ->
                    session.logout()
                    val intent = Intent(requireActivity(), LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
                .setNegativeButton("Cancel", null)
                .show()
        }
    }

    override fun onResume() {
        super.onResume()
        view?.let { updateUI(it, SessionManager(requireContext())) }
    }

    private fun updateUI(view: View, session: SessionManager) {
        val profileName: TextView = view.findViewById(R.id.profileName)
        val profileEmail: TextView = view.findViewById(R.id.profileEmail)
        val detailName: TextView = view.findViewById(R.id.detailName)
        val detailEmail: TextView = view.findViewById(R.id.detailEmail)
        val avatarInitial: TextView = view.findViewById(R.id.avatarInitial)

        val name = session.getUserName()
        val email = session.getUserEmail()

        profileName.text = name
        profileEmail.text = email
        detailName.text = name
        detailEmail.text = email
        avatarInitial.text = name.firstOrNull()?.toString()?.uppercase() ?: "A"
    }
}
