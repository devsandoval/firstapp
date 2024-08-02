package com.cesarsandoval.firstapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //pacman
        val pc: ImageView = findViewById(R.id.pc)
        val po: ImageView = findViewById(R.id.po)
        po.setOnClickListener {
            pc.visibility = if (pc.visibility == View.VISIBLE) View.INVISIBLE else View.VISIBLE
        }
        pc.setOnClickListener {
            po.visibility = if (po.visibility == View.VISIBLE) View.INVISIBLE else View.VISIBLE
        }

        //gate
        var gate: ImageButton = findViewById(R.id.gate)
        gate.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })

    }
}