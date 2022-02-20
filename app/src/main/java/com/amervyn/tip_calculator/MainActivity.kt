package com.amervyn.tip_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amervyn.tip_calculator.databinding.ActivityMainBinding
import java.text.NumberFormat
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calcTipBtn.setOnClickListener {
            if (binding.billAmount.text.isNotEmpty()) {
                val enteredTip = binding.billAmount.text.toString().toFloat()
                val tenPercent = enteredTip * 1.10
                val fifteenPercent = enteredTip * 1.15
                val twentyPercent = enteredTip * 1.20
                val formatTen = NumberFormat.getCurrencyInstance().format(tenPercent)
                val formatFifteen = NumberFormat.getCurrencyInstance().format(fifteenPercent)
                val formatTwenty = NumberFormat.getCurrencyInstance().format(twentyPercent)
                binding.output.text =
                    "Tip amounts are as follows:\n\n10% = $formatTen\n15% = $formatFifteen\n20% = $formatTwenty"
            } else {
                binding.output.text = "Please enter a bill amount"
            }
        }
    }
}
