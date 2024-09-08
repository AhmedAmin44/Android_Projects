package com.example.fiveapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.TextView

class TaskAdapter(context: Context, tasks: List<Task>) :
    ArrayAdapter<Task>(context, R.layout.task_item, tasks) {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: inflater.inflate(R.layout.task_item, parent, false)
        val task = getItem(position) ?: return view

        val titleTextView: TextView = view.findViewById(R.id.taskTitle)
        val completedCheckBox: CheckBox = view.findViewById(R.id.taskCompleted)

        titleTextView.text = task.title
        completedCheckBox.isChecked = task.isCompleted

        completedCheckBox.setOnCheckedChangeListener { _, isChecked ->
            task.isCompleted = isChecked
        }

        return view
    }
}

