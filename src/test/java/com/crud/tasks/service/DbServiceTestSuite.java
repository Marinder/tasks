package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DbServiceTestSuite {
    @InjectMocks
    private DbService dbService;

    @Mock
    private TaskRepository taskRepository;


    @Test
    public void shouldSave() {
        //Given
        Task task = new Task(1L,"test", "test");
        //When
        when(taskRepository.save(task)).thenReturn(task);
        Task taskSave = dbService.saveTask(task);
        //Then
        assertEquals(taskSave.getId(), task.getId());
        assertEquals(taskSave.getTitle(), task.getTitle());
        assertEquals(taskSave.getContent(), task.getContent());

    }

    @Test
    public void shouldGetTasks() {
        //Given
        Task task = new Task(1L,"test", "test");
        Task task2 = new Task(2L,"test", "test");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);
        taskList.add(task2);
        //When
        when(taskRepository.findAll()).thenReturn(taskList);
        List<Task>  findAllTask = dbService.getAllTasks();
        //Then
        assertEquals(findAllTask.size(),2);
    }

    @Test
    public void shouldGetTask() {
        //Given
        Task task = new Task(1L,"test", "test");
        //When
        when(taskRepository.findById(1L)).thenReturn(Optional.ofNullable(task));
        Optional<Task> taskFindById = dbService.getTask(1L);
        //Then
        assertEquals(taskFindById.get().getId(),task.getId());
    }
}
