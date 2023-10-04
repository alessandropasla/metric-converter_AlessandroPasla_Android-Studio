package com.example.myapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var meterEditText: EditText
    private lateinit var convertButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        meterEditText = findViewById(R.id.editTextMeter)
        convertButton = findViewById(R.id.buttonConvert)
        resultTextView = findViewById(R.id.textViewResult)

        convertButton.setOnClickListener {
            convertMeterToKilometer()
        }

        meterEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Enable or disable the convert button based on input
                val input = s.toString().trim()
                convertButton.isEnabled = input.isNotEmpty()
            }

            override fun afterTextChanged(s: Editable?) {
                // Do nothing
            }
        })
    }

    private fun convertMeterToKilometer() {
        val meterText = meterEditText.text.toString()
        if (meterText.isEmpty()) {
            resultTextView.text = "Please enter a value in meters."
            return
        }

        val meterValue = meterText.toDouble()
        val kilometerValue = meterValue / 1000.0
        resultTextView.text = "Result: $meterValue meters = $kilometerValue kilometers"
    }
}