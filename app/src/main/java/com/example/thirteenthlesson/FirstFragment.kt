package com.example.thirteenthlesson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_one.*

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        requireActivity().findViewById<Button>(R.id.button)
        requireActivity().findViewById<EditText>(R.id.editText1)
        requireActivity().findViewById<EditText>(R.id.editText2)
        var fragmentTwo = SecondFragment()
        var editTextInfo1 = ""
        var editTextInfo2 = ""
        var chislo = 5
        button.setOnClickListener {
            editTextInfo1 = editText1.text.toString()
            editTextInfo2 = editText2.text.toString()
            if (editText1.text.isEmpty() || editText2.text.isEmpty()) {
            Toast.makeText(requireContext(),
                "Пожалуйста заполните поля", Toast.LENGTH_LONG).show()
            return@setOnClickListener
        }
            fragmentTwo.arguments = Bundle().also {
                it.putString("key","$editTextInfo1")
                it.putString("key2","$editTextInfo2")
            }
            chislo.also {
                it.plus(2)
                it.minus(2)
            } // chislo = chislo + 2
            // chislo = chislo - 2



            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer, fragmentTwo)
                ?.addToBackStack(null)
                ?.commit()

        }
    }
}