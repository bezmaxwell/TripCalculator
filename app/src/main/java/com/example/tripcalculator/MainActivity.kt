package com.example.tripcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class FirstActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(view: View?) {
        val id = view?.id
        if (id == R.id.buttonCalculate) {
            handleCalculate()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this)

    }

    private fun handleCalculate() {
        if (isValid()) {

            try {

                val distance = distanceText.text.toString().toFloat()
                val price = priceText.text.toString().toFloat()
                val autonomy = autonomyText.text.toString().toFloat()

                val result = (distance * price / autonomy)
                priceScreen.setText("Total = R$ ${result}")

            } catch (nfe: NumberFormatException) {

                Toast.makeText(this, getString(R.string.valores_validos), Toast.LENGTH_LONG).show()
            }

        } else {
            Toast.makeText(this, getString(R.string.valores_validos), Toast.LENGTH_LONG).show()
        }

    }

    private fun isValid(): Boolean {
        return autonomyText.text.toString() != ""
                && priceText.text.toString() != ""
                && distanceText.text.toString() != "0"
    }

}

