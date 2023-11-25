package com.android.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    private lateinit var calculatorViewModel: CalculatorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var kind = 0


        binding.resultButton.setOnClickListener {
            val num1 = binding.editText2.text.toString().toInt()
            val num2 = binding.editText.text.toString().toInt()
            when(kind){
                0 -> calculatorViewModel.add(num1, num2)
                1 -> calculatorViewModel.sub(num1, num2)
                2 -> calculatorViewModel.mul(num1, num2)
                3 -> calculatorViewModel.div(num1, num2)
            }
        }

        binding.addButton.setOnClickListener {
            kind = 0
            binding.calSymbol.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.add,
                    null
                )
            )
        }
        binding.subButton.setOnClickListener {
            kind = 1
            binding.calSymbol.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.sub,
                    null
                )
            )
        }
        binding.mulButton.setOnClickListener {
            kind = 2
            binding.calSymbol.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.mul,
                    null
                )
            )
        }
        binding.divButton.setOnClickListener {
            kind = 3
            binding.calSymbol.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.div,
                    null
                )
            )
        }

        viewModel()
    }

    private fun viewModel(){
        calculatorViewModel = ViewModelProvider(this)[CalculatorViewModel::class.java]

        calculatorViewModel.result.observe(this, Observer { num ->
            binding.resultText.text = num.toString()
        })
    }
}