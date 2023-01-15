package com.example.todolist.data

import androidx.room.*
import com.example.todolist.Task
import kotlinx.coroutines.flow.Flow

@Dao
public interface TaskDao {

    @Query("SELECT * FROM task")
    fun getAll(): Flow<List<Task>>

    @Insert
    fun insertTask(task : Task)

    @Update
    fun updateTask(task: Task)

    @Delete
    fun delete(task: Task)
}