package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fabButtton = findViewById<FloatingActionButton>(R.id.fab)
        fabButtton . setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AddTask::class.java)
            startActivity(intent)
        })
    }
}