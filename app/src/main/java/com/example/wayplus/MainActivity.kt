package com.example.wayplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val greetingTextView = findViewById<TextView>(R.id.textViewWelcome)
        val input11 = findViewById<EditText>(R.id.editTextName)
        val Button11 = findViewById<Button>(R.id.button)
        val Button22 = findViewById<Button>(R.id.button2)
        var enterName = ""
        Button11.setOnClickListener {
            val enterName = input11.text.toString()
            if (enterName ==""){
                Button22.visibility = INVISIBLE
                greetingTextView.text = ""
                Toast.makeText(
                    this@MainActivity,
                    "Pls, напишите свое имя",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else {
                val mes = "День добрый, $enterName"
                greetingTextView.text = mes
                input11.text.clear()
                Button22.visibility = VISIBLE
            }
        }

        Button22.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("User",enterName)
            startActivity(intent)
        }
    }


}