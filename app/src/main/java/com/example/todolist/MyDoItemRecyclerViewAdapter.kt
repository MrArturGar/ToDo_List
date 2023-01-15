package com.example.todolist

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

import com.example.todolist.databinding.FragmentDoListItemBinding
import java.text.SimpleDateFormat
import java.util.*



class MyDoItemRecyclerViewAdapter(
    private val values: List<Task>, val listener: ITaskItemListener
) : RecyclerView.Adapter<MyDoItemRecyclerViewAdapter.TaskHolder>() {

    class TaskHolder(item:View): RecyclerView.ViewHolder(item)
    {
        val binding = FragmentDoListItemBinding.bind(item)
        fun bind(task: Task, listener: ITaskItemListener) = with(binding){
            textViewTitle.text = task.Title
            checkBox.isChecked = task.Completed

            if (task.Priority == TaskPriority.HIGH)
                checkBox.setBackgroundColor((listener as Context).getColor(R.color.priority_high))
            else if (task.Priority == TaskPriority.MIDDLE)
                checkBox.setBackgroundColor((listener as Context).getColor(R.color.priority_middle))
            else if (task.Priority == TaskPriority.LOW)
                checkBox.setBackgroundColor((listener as Context).getColor(R.color.priority_low))

            val dateFormatter = SimpleDateFormat("dd.MM.yyyy hh:mm")
            textDate.text = dateFormatter.format(Date(task.Date))
            imageInfo.setOnClickListener {
                listener.OnClick(task)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_do_list_item,parent,false)
        return TaskHolder(view)
    }

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        holder.bind(values[position], listener)
    }

    override fun getItemCount(): Int {
        return values.size
    }

    interface ITaskItemListener{
        fun OnClick(task:  Task)
    }

}