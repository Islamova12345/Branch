package com.example.branch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.branch.databinding.ActivityMainBinding // Adjust this according to your package name

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.addButton.setOnClickListener {
            val num1 = binding.editText1.text.toString().toDoubleOrNull()
            val num2 = binding.editText2.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null) {
                val result = num1 + num2
                binding.ResultTextView.text = result.toString()
            }
        }
        binding.minusButton.setOnClickListener {
            val num1 = binding.editText1.text.toString().toDoubleOrNull()
            val num2 = binding.editText2.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null) {
                val result = num1 - num2
                binding.ResultTextView.text = result.toString()
            }
        }
        binding.minusButton.setOnClickListener {
            val num1 = binding.editText1.text.toString().toDoubleOrNull()
            val num2 = binding.editText2.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null) {
                val result = num1 - num2
                binding.ResultTextView.text = result.toString()
            }
        }
        binding.BolmeButton.setOnClickListener {
            val num1 = binding.editText1.text.toString().toDoubleOrNull()
            val num2 = binding.editText2.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null) {
                if (num2 != 0.0) {
                    val result = num1 / num2
                    binding.ResultTextView.text = result.toString()
                } else {
                    binding.ResultTextView.text = "Cannot divide by zero"
                }
            }
        }
    }

}

