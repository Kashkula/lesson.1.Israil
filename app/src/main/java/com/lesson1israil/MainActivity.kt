package com.lesson1israil


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.lesson1israil.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        vm = ViewModelProvider(this)[MainViewModel::class.java]

        onClick()
        binding.tvResult.text = vm.method()

    }

    private fun onClick() {
        binding.btnPlus.setOnClickListener {
            calculator("+")
        }
        binding.btnMinus.setOnClickListener {
            calculator("-")
        }

        binding.btnDelenie.setOnClickListener {
            calculator("/")
        }
        binding.btnUmnojite.setOnClickListener {
            calculator("*")
        }
    }

    private fun calculator(s: String) {
        val firstStr = binding.etFirst.text
        val secondStr = binding.etSecond.text
        if (firstStr.isNotEmpty() && secondStr.isNotEmpty()) {
            val first = binding.etFirst.text.toString().toInt()
            val second = binding.etSecond.text.toString().toInt()

            vm.method(first, second, s)

            binding.tvResult.text = vm.method(first, second, s)
            binding.etFirst.text.clear()
            binding.etSecond.text.clear()
        } else {
            Toast.makeText(this, "Please, add field!", Toast.LENGTH_SHORT).show()
        }
    }
}