package com.example.fragments.FRAGMENTS

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.fragments.R

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var userEditText: EditText
    private lateinit var sendButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userEditText = view.findViewById(R.id.editTextUser)
        sendButton = view.findViewById(R.id.buttonSend)

        val controller = Navigation.findNavController(view)

        sendButton.setOnClickListener{

            val userName = userEditText.text.toString()

            if (userName.isEmpty()){
                return@setOnClickListener
            }



            val action = HomeFragmentDirections.actionHomeFragmentToDashboardFragment(userName)

            controller.navigate(action)
        }
    }
}