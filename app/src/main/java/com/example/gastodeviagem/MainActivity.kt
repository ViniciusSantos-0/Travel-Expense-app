package com.example.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.buttonCalculate) {
            calculate()
        }
    }

    private fun calculate() {
        if (validate()) {
                val distance = editDistance.text.toString().toFloat()
                val price = editPrice.text.toString().toFloat()
                val autonomy = editAutonomy.text.toString().toFloat()

                val totalValue = (distance * price) / autonomy

                textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"

        } else if(editAutonomy.text.toString() == "0") {
                Toast.makeText(
                    this,
                    getString(R.string.por_favor_insira_valores_validos),
                    Toast.LENGTH_LONG
                ).show()
            }else{
                Toast.makeText(
                    this,
                    getString(R.string.preencha_todos_os_campos),
                    Toast.LENGTH_LONG
                )
                    .show()

        }
    }

    private fun validate(): Boolean = (editDistance.text.toString() != ""
            && editAutonomy.text.toString() != "" && editPrice.text.toString() != "" && editAutonomy.text.toString() != "0")
}