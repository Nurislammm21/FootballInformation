package com.example.progressapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.progressapp.databinding.ActivityInformationDetailsBinding

class InformationDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInformationDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}