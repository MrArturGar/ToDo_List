package com.example.todolist

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.todolist.model.DateTime
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class AddTask : AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private var dateTime : DateTime = DateTime()
    private var dateTimeSaved: DateTime = DateTime()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        val closeButton = findViewById<ImageButton>(R.id.imageButtonClose)
        closeButton.setOnClickListener(View.OnClickListener {
            closeThisActivity()
        })

        val saveButton = findViewById<Button>(R.id.buttonSave)
        saveButton.setOnClickListener(View.OnClickListener {
            saveTask()
        })

        pickDate()
    }

    private fun closeThisActivity()
    {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun saveTask()
    {
        val title = (findViewById<EditText>(R.id.editTextTitle) as EditText).text.toString()
        val desc = (findViewById<EditText>(R.id.editTextDesc) as EditText).text.toString()
        val date =  getTimestamp((findViewById<TextView>(R.id.textViewDate) as TextView).text.toString())
        val priority = (findViewById<Spinner>(R.id.spinnerPriority) as Spinner).selectedItem as TaskPriority
        val completed = (findViewById<CheckBox>(R.id.checkBoxCompleted) as CheckBox).isChecked
        val task : Task = Task(Title = title, Description = desc, Date = date, Priority = priority, Completed = completed)
        closeThisActivity()
    }

    private fun getDateTimeCalendar()
    {
        val cal = Calendar.getInstance()
        dateTime.day = cal.get(Calendar.DAY_OF_MONTH)
        dateTime.month = cal.get(Calendar.MONTH)
        dateTime.year = cal.get(Calendar.YEAR)
        dateTime.hour = cal.get(Calendar.HOUR)
        dateTime.minute = cal.get(Calendar.MINUTE)
    }

    private fun pickDate()
    {
        val textDate = findViewById<TextView>(R.id.textViewDate) as TextView
        textDate.setOnClickListener({
            getDateTimeCalendar()

            DatePickerDialog(this, this, dateTime.year, dateTime.month, dateTime.day).show()
        })
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        dateTimeSaved.day = dayOfMonth
        dateTimeSaved.month = month
        dateTimeSaved.year = year
        getDateTimeCalendar()
        TimePickerDialog(this, this, dateTime.hour, dateTime.minute, true).show()
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        dateTimeSaved.hour = hourOfDay
        dateTimeSaved.minute = minute

        val textDate = findViewById<TextView>(R.id.textViewDate) as TextView
        textDate.setText("${dateTimeSaved.day}-${dateTimeSaved.month}-${dateTimeSaved.year} ${dateTimeSaved.hour}:${dateTimeSaved.minute}")
    }

    private fun getTimestamp(s: String): Long {
        val formatter: DateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm")
        return formatter.parse(s).time
    }
}