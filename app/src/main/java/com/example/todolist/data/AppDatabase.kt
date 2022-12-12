package com.example.todolist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todolist.Task

@Database(entities = [Task::class], version = 1)
public abstract class AppDatabase : RoomDatabase() {
     abstract fun taskDao(): TaskDao

     companion object{
          fun getDb(context: Context): AppDatabase{
               return Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "todolist.db"
               ).build()
          }
     }
}