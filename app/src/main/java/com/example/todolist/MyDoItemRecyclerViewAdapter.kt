package com.example.todolist

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView

import com.example.todolist.placeholder.PlaceholderContent.PlaceholderItem
import com.example.todolist.databinding.FragmentDoListItemBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyDoItemRecyclerViewAdapter(
    private val values: List<PlaceholderItem>
) : RecyclerView.Adapter<MyDoItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentDoListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        //holder.itemCheckBox.text = item.id
        //holder.itemTextView.text = item.content
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentDoListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val itemCheckBox: CheckBox = binding.checkBox
        val itemTextView: TextView = binding.textView

        override fun toString(): String {
            return super.toString() + " '" + itemCheckBox.text + "'"
        }
    }

}