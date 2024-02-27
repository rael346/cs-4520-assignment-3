package com.cs4520.assignment3.ui.mvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.cs4520.assignment3.R
import com.cs4520.assignment3.databinding.FragmentMVPBinding
import com.cs4520.assignment3.databinding.FragmentMVVMBinding
import com.cs4520.assignment3.ui.Operation
import java.util.InvalidPropertiesFormatException

class MVVMFragment : Fragment() {
    private val viewModel: MVVMViewModel by viewModels()
    private lateinit var binding: FragmentMVVMBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMVVMBinding.inflate(inflater, container, false)

        binding.addButton.setOnClickListener {
            operate(Operation.Add)
        }

        binding.subtractButton.setOnClickListener {
            operate(Operation.Subtract)
        }

        binding.multiplyButton.setOnClickListener {
            operate(Operation.Multiply)
        }

        binding.divideButton.setOnClickListener {
            operate(Operation.Divide)
        }

        viewModel.result.observe(viewLifecycleOwner) { result ->
            if (result == null) {
                binding.result.text = ""
                binding.result.visibility = View.INVISIBLE
            } else {
                binding.result.text = "Result ${result}"
                binding.result.visibility = View.VISIBLE
            }
        }

        viewModel.error.observe(viewLifecycleOwner) { error ->
            if (error != null) {
                displayError(error)
            }
        }

        return binding.root
    }

    private fun operate(operation: Operation) {
        val number1Text = binding.number1.text.toString()
        val number2Text = binding.number2.text.toString()

        if (number1Text == "") {
            binding.number1.error = "Number 1 field is empty"
            displayError("Number 1 field is empty")
            return
        }

        if (number2Text == "") {
            binding.number2.error = "Number 2 field is empty"
            displayError("Number 2 field is empty")
            return
        }

        val number1: Int = number1Text.toInt()
        val number2: Int = number2Text.toInt()

        viewModel.operate(number1, number2, operation)
        clearInputs()
    }
    private fun displayError(message: String) {
        val appContext = context?.applicationContext ?: return
        Toast.makeText(appContext, message, Toast.LENGTH_LONG).show()
    }

    private fun clearInputs() {
        binding.number1.text.clear()
        binding.number2.text.clear()
    }
}