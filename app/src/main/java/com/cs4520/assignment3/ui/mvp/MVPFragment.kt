package com.cs4520.assignment3.ui.mvp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.cs4520.assignment3.R
import com.cs4520.assignment3.databinding.FragmentMVPBinding
import com.cs4520.assignment3.databinding.FragmentMainBinding
import java.util.InvalidPropertiesFormatException

interface MVPView {
    fun getNumberInputs(): Pair<Int, Int>
    fun displayResult(result: Int)
    fun displayError(message: String)
}
class MVPFragment : Fragment(), MVPView {
    private val presenter = MVPPresenter(this, MVPModel())
    private lateinit var binding: FragmentMVPBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMVPBinding.inflate(inflater, container, false)

        binding.addButton.setOnClickListener {
            presenter.operate(Operation.Add)
        }

        binding.subtractButton.setOnClickListener {
            presenter.operate(Operation.Subtract)
        }

        binding.multiplyButton.setOnClickListener {
            presenter.operate(Operation.Multiply)
        }

        binding.divideButton.setOnClickListener {
            presenter.operate(Operation.Divide)
        }

        return binding.root
    }

    override fun getNumberInputs(): Pair<Int, Int> {
        val number1Text = binding.number1.text.toString()
        val number2Text = binding.number2.text.toString()

        if (number1Text == "") {
            binding.number1.error = "Number 1 field is empty"
            throw InvalidPropertiesFormatException("Number 1 field is empty")
        }

        if (number2Text == "") {
            binding.number2.error = "Number 1 field is empty"
            throw InvalidPropertiesFormatException("Number 2 field is empty")
        }

        val number1: Int = number1Text.toInt()
        val number2: Int = number2Text.toInt()

        return Pair(number1, number2)
    }

    override fun displayResult(result: Int) {
        binding.result.text = "Result ${result}"
        binding.result.visibility = View.VISIBLE;
    }

    override fun displayError(message: String) {
        val appContext = context?.applicationContext ?: return
        Toast.makeText(appContext, message, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}