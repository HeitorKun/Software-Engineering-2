package test.java.com.heitor.tasksMicroservice;

import com.heitor.tasksMicroservice.domain.Task.Task;
import com.heitor.tasksMicroservice.domain.Task.TaskRepository;
import com.heitor.tasksMicroservice.services.TaskService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TasksMicroserviceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    public TaskServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task());//falta criar a task
        Mockito.when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> result = taskService.getAllTasks();

        assertEquals(tasks, result);
    }

    @Test
    void getTaskById() {
        Long taskId = 1L;
        Task task = new Task();
        Mockito.when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));

        Optional<Task> result = taskService.getTaskById(taskId);

        assertTrue(result.isPresent());
        assertEquals(task, result.get());
    }

    @Test
    void createTask() {
        Task task = new Task();
        Mockito.when(taskRepository.save(task)).thenReturn(task);

        Task result = taskService.createTask(task);

        assertEquals(task, result);
    }

    @Test
    void updateTask() {
        Long taskId = 1L;
        Task existingTask = new Task();
        Task updatedTask = new Task();

        Mockito.when(taskRepository.findById(taskId)).thenReturn(Optional.of(existingTask));
        Mockito.when(taskRepository.save(existingTask)).thenReturn(existingTask);

        Task result = taskService.updateTask(taskId, updatedTask);

        assertEquals(existingTask, result);
    }

    @Test
    void deleteTask() {
        Long taskId = 1L;

        taskService.deleteTask(taskId);

        Mockito.verify(taskRepository, Mockito.times(1)).deleteById(taskId);
    }
}
