package com.example.todolist.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todolist.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
public abstract class AppDatabase : RoomDatabase() {
     abstract fun taskDao(): TaskDao
}