package com.example.gastodeviagem

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gastodeviagem.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.buttonCalculate) {
            calculate()
        }
    }

    private fun calculate() {
        val distanceStr = binding.editDistance.text.toString()
        val priceStr = binding.editPrice.text.toString()
        val autonomyStr = binding.editAutonomy.text.toString()

        if (validate(distanceStr, priceStr, autonomyStr)) {
            val distance = distanceStr.toFloat()
            val price = priceStr.toFloat()
            val autonomy = autonomyStr.toFloat()
            val totalValue = (distance * price) / autonomy

            binding.textTotalValue.text = "$ ${"%.2f".format(totalValue)}"
        } else if (autonomyStr == "0") {
            Toast.makeText(
                this,
                getString(R.string.please_enter_valid_values),
                Toast.LENGTH_LONG
            ).show()
        } else {
            Toast.makeText(this, getString(R.string.fill_in_all_fields), Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun validate(dist: String, price: String, auto: String): Boolean {
        return dist.isNotEmpty() && price.isNotEmpty() && auto.isNotEmpty() && auto != "0"
    }
}
