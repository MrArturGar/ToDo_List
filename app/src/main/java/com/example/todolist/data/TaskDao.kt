package com.example.todolist.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.todolist.Task
import kotlinx.coroutines.flow.Flow

@Dao
public interface TaskDao {

    @Query("SELECT * FROM task")
    fun getAll(): Flow<List<Task>>

    @Insert
    fun insertTask(vararg task : Task)

    @Delete
    fun delete(task: Task)
}