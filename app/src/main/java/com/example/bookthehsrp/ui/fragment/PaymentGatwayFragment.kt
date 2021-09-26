package com.example.bookthehsrp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.bookthehsrp.R

class PaymentGatwayFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_payment_gatway, container, false)

        val button = view.findViewById<Button>(R.id.button_continue)
        button.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_paymentGatwayFragment_to_homeFragment22)
        }

        return view
    }
}