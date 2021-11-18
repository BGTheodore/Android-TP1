package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var nbreClic_txtView: TextView
    private var nbClick = 0
    private lateinit var clickButton: Button
    private lateinit var computeButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickButton = findViewById(R.id.btn_click_me)
        nbreClic_txtView = findViewById(R.id.nbreClic_txtView)
        nbreClic_txtView.visibility = INVISIBLE

        clickButton.setOnClickListener {
            if (nbreClic_txtView.visibility == INVISIBLE)
                nbreClic_txtView.visibility = VISIBLE
            // Toast.makeText(baseContext, "Tu m'as cliqué", Toast.LENGTH_LONG).show()
            nbClick++
            val newText = "$nbClick"
            //clickButton.text = newText
            nbreClic_txtView.text = newText
            if (nbClick == 5)
                clickButton.isEnabled = false


            computeButton = findViewById(R.id.btn_compute)

            computeButton.setOnClickListener {
                val intent = Intent(baseContext, ComputeActivity::class.java)
                startActivity(intent)
            }
        }
    }
}



