package com.heitor.tasksMicroservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heitor.tasksMicroservice.domain.Task.Task;
import com.heitor.tasksMicroservice.services.TaskService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private TaskService taskService;

    @Test
    void getAllTasks() throws Exception {
        List<Task> taskList = new ArrayList<>();
        when(taskService.getAllTasks()).thenReturn(taskList);

        mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());

        verify(taskService, times(1)).getAllTasks();
    }

    @Test
    void getTaskById_TaskExists() throws Exception {
        Long taskId = 1L;
        Task task = new Task(taskId, "Test Task", "Description");
        when(taskService.getTaskById(taskId)).thenReturn(Optional.of(task));

        mockMvc.perform(get("/tasks/{taskId}", taskId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(taskId));

        verify(taskService, times(1)).getTaskById(taskId);
    }

    @Test
    void getTaskById_TaskNotExists() throws Exception {
        Long taskId = 1L;
        when(taskService.getTaskById(taskId)).thenReturn(Optional.empty());

        mockMvc.perform(get("/tasks/{taskId}", taskId))
                .andExpect(status().isNotFound());

        verify(taskService, times(1)).getTaskById(taskId);
    }

    @Test
    void createTask() throws Exception {
        Task task = new Task(1L, "New Task", "Description");
        when(taskService.createTask(any(Task.class))).thenReturn(task);

        ResultActions result = mockMvc.perform(post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(task)));

        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L));

        verify(taskService, times(1)).createTask(any(Task.class));
    }

    @Test
    void updateTask_TaskExists() throws Exception {
        Long taskId = 1L;
        Task updatedTask = new Task(taskId, "Updated Task", "Updated Description");
        when(taskService.updateTask(eq(taskId), any(Task.class))).thenReturn(updatedTask);

        ResultActions result = mockMvc.perform(put("/tasks/{taskId}", taskId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedTask)));

        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Updated Task"));

        verify(taskService, times(1)).updateTask(eq(taskId), any(Task.class));
    }

    @Test
    void updateTask_TaskNotExists() throws Exception {
        Long taskId = 1L;
        when(taskService.updateTask(eq(taskId), any(Task.class))).thenReturn(null);

        mockMvc.perform(put("/tasks/{taskId}", taskId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new Task())))

                .andExpect(status().isNotFound());

        verify(taskService, times(1)).updateTask(eq(taskId), any(Task.class));
    }

    @Test
    void deleteTask() throws Exception {
        mockMvc.perform(delete("/tasks/{taskId}", 1L))
                .andExpect(status().isOk());

        verify(taskService, times(1)).deleteTask(1L);
    }
}
