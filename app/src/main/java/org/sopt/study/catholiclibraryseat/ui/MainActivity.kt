package org.sopt.study.catholiclibraryseat.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.study.catholiclibraryseat.R
import org.sopt.study.catholiclibraryseat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}