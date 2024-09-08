import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fiveapp.Task

class TaskViewModel : ViewModel() {

    private val _tasks = MutableLiveData<List<Task>?>()
    val tasks: MutableLiveData<List<Task>?> = _tasks

    val completedTasksCount: LiveData<Int> = Transformations.map(_tasks) { tasks ->
        tasks.count { it.isCompleted }
    }

    init {
        _tasks.value = listOf(
            Task(1, "Buy groceries", false),
            Task(2, "Walk the dog", true),
            Task(3, "Read a book", false)
        )
    }

    fun addTask(title: String) {
        val newTask = Task(
            id = (_tasks.value?.size?.toLong() ?: 0) + 1,
            title = title,
            isCompleted = false
        )
        val updatedList = _tasks.value.orEmpty() + newTask
        _tasks.value = updatedList
    }

    fun toggleTaskCompletion(task: Task) {
        val updatedList = _tasks.value?.map {
            if (it.id == task.id) it.copy(isCompleted = !it.isCompleted) else it
        }
        _tasks.value = updatedList
    }
}
