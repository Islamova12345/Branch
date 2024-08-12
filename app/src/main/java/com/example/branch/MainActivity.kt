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
        }
    }
