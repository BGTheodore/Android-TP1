package com.example.mainactivity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ComputeActivity : AppCompatActivity() {
    private lateinit var field1 : EditText
    private lateinit var field2 : EditText
    private lateinit var resultat : TextView
    private lateinit var btncalculer : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compute_activity)

        field1 = findViewById(R.id.field_1)
        field2 = findViewById(R.id.field_2)
        resultat = findViewById(R.id.resultat)
        btncalculer = findViewById(R.id.btn_calculer)

        btncalculer.isEnabled = false

        field1.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                if (field1.getText().toString().trim().length > 0
                    && field2.getText().toString().trim().length > 0
                ) {
                    btncalculer.isEnabled = true
                } else {
                    btncalculer.isEnabled = false
                }
            }
        })

        btncalculer.setOnClickListener {
            val newText = field1.getText().toString().toDouble() + field2.getText().toString().toDouble()
            resultat.text = newText.toString()
        }
    }
}