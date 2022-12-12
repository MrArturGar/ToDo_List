package com.example.todolist

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView

import com.example.todolist.placeholder.PlaceholderContent.PlaceholderItem
import com.example.todolist.databinding.FragmentDoListItemBinding
import com.example.todolist.model.DateTime
import java.text.SimpleDateFormat
import java.util.*



class MyDoItemRecyclerViewAdapter(
    private val values: List<Task>
) : RecyclerView.Adapter<MyDoItemRecyclerViewAdapter.TaskHolder>() {

    class TaskHolder(item:View): RecyclerView.ViewHolder(item)
    {
        val binding = FragmentDoListItemBinding.bind(item)
        fun bind(task: Task) = with(binding){
            checkBoxTitle.text = task.Title
            checkBoxTitle.isChecked = task.Completed

            val dateFormatter = SimpleDateFormat("MM.dd.yyyy hh:mm")
            textDate.text = dateFormatter.format(Date(task.Date))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_do_list_item,parent,false)
        return TaskHolder(view)
    }

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        holder.bind(values[position])
    }

    override fun getItemCount(): Int {
        return values.size
    }


}