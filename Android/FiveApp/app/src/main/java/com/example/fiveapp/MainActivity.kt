import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.fiveapp.R
import com.example.fiveapp.Task
import com.example.fiveapp.TaskAdapter
import com.example.fiveapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: TaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val adapter = TaskAdapter(this, listOf())
        binding.tasksListView.adapter = adapter

        // Add new tasks
        binding.addTaskButton.setOnClickListener {
            val taskTitle = binding.taskInput.text.toString()
            if (taskTitle.isNotEmpty()) {
                viewModel.addTask(taskTitle)
                binding.taskInput.text.clear()
            }
        }

        // Update task list
        viewModel.tasks.observe(this) { tasks ->
            (binding.tasksListView.adapter as TaskAdapter).apply {
                clear()
                if (tasks != null) {
                    addAll(tasks)
                }
                notifyDataSetChanged()
            }
        }

        // Toggle task completion
        binding.tasksListView.setOnItemClickListener { _, _, position, _ ->
            val task = adapter.getItem(position) as Task
            viewModel.toggleTaskCompletion(task)
        }
    }
}
