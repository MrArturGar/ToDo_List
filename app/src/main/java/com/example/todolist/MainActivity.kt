package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.data.AppDatabase
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var taskList: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fabButton = findViewById<FloatingActionButton>(R.id.fab)
        fabButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AddTask::class.java)
            startActivity(intent)
        })

        val db = AppDatabase.getDb(this).taskDao()
        db.getAll().asLiveData().observe(this){
            Task.TaskList = it
            if (savedInstanceState == null) {
                val fragment = DoList.newInstance(0)
                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container_view,fragment, "fragment_tag")
                    .commit()
            }
        }

    }

    private fun loadTaskItems(){
    }

}