package com.crud.tasks.mapper;


import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.domain.TrelloListDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TaskMapperTestSuite {
    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    public void shouldMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "testTitle", "testContent");
        //When
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals(taskDto.getId(), task.getId());
        assertEquals(taskDto.getTitle(), task.getTitle());
        assertEquals(taskDto.getContent(), task.getContent());
    }

    @Test
    public void shouldMapToTaskDto() {
        //Given
        Task task = new Task(1L, "testTitle", "testContent");
        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals(taskDto.getId(), task.getId());
        assertEquals(taskDto.getTitle(), task.getTitle());
        assertEquals(taskDto.getContent(), task.getContent());
    }

    @Test
    public void shouldMapToTaskDtoList() {
        //Given
        Task task = new Task(1L, "testTitle", "testContent");
        List<Task> list = new ArrayList<>();
        list.add(task);
        //When
        List<TaskDto> mapperList = taskMapper.mapToTaskDtoList(list);
        //Then
        assertEquals(1, mapperList.size());
        assertEquals(mapperList.get(0).getId(), task.getId());
        assertEquals(mapperList.get(0).getTitle(), task.getTitle());
        assertEquals(mapperList.get(0).getContent(), task.getContent());

    }
}
