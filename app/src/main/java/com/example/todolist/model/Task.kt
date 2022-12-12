package com.example.todolist

import androidx.room.Entity
import androidx.room.PrimaryKey

//data class TaskModel(var Id : Int, var Title: String, var Description: String, var Date: Long, var Priority: TaskPriority, var Completed:Boolean)
@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    var Id: Int = 0,
    var Title: String,
    var Description: String,
    var Date: Long,
    var Priority: TaskPriority,
    var Completed:Boolean
    )

enum class TaskPriority
{
    HIGH,
    MIDDLE,
    LOW;

    private var priority: String = ""

    open fun Priorities(aState: String) {
        priority = aState
    }

//    override fun toString(): String {
//        return priority
//    }
}