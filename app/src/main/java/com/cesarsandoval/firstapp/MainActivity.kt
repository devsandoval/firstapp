package com.cesarsandoval.firstapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var boton_enviar: Button = findViewById(R.id.button_enviar)
        boton_enviar.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Bienvenido", Toast.LENGTH_LONG).show()
        })

        var next_img: ImageView = findViewById(R.id.next_img)
        next_img.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        })
    }

}