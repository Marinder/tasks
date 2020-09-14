package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTestSuite {

    @InjectMocks
    private TrelloMapper trelloMapper;

    @Test
    public void shouldMapToBoards() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("1", "testList", false);
        List<TrelloListDto> listDto = new ArrayList<>();
        listDto.add(trelloListDto);
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1", "testBoard", listDto);
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        trelloBoardDtoList.add(trelloBoardDto);
        //When
        List<TrelloBoard> mapperList = trelloMapper.mapToBoards(trelloBoardDtoList);
        //Then
        assertEquals(1, mapperList.size());
        assertEquals("1", mapperList.get(0).getId());
        assertEquals("testBoard", mapperList.get(0).getName());
        assertEquals("testList", mapperList.get(0).getLists().get(0).getName());
    }

    @Test
    public void shouldMapToBoardsDto() {
        TrelloList trelloList = new TrelloList("1", "testList", false);
        List<TrelloList> list = new ArrayList<>();
        list.add(trelloList);
        TrelloBoard trelloBoard = new TrelloBoard("1", "testBoard", list);
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(trelloBoard);
        //When
        List<TrelloBoardDto> mapperList = trelloMapper.mapToBoardsDto(trelloBoardList);
        //Then
        assertEquals(1, mapperList.size());
        assertEquals("1", mapperList.get(0).getId());
        assertEquals("testBoard", mapperList.get(0).getName());
        assertEquals("testList", mapperList.get(0).getLists().get(0).getName());
    }

    @Test
    public void shouldMapToList() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("1", "testList", false);
        List<TrelloListDto> listDto = new ArrayList<>();
        listDto.add(trelloListDto);
        //When
        List<TrelloList> mapperList = trelloMapper.mapToList(listDto);
        //Then
        assertEquals(1, mapperList.size());
        assertEquals("1", mapperList.get(0).getId());
        assertEquals("testList", mapperList.get(0).getName());
        assertEquals(false, mapperList.get(0).isClosed());
    }

    @Test
    public void shouldMapToListDto() {
        //Given
        TrelloList trelloList = new TrelloList("1", "testList", false);
        List<TrelloList> list = new ArrayList<>();
        list.add(trelloList);
        //When
        List<TrelloListDto> mapperList = trelloMapper.mapToListDto(list);
        //Then
        assertEquals(1, mapperList.size());
        assertEquals("1", mapperList.get(0).getId());
        assertEquals("testList", mapperList.get(0).getName());
        assertEquals(false, mapperList.get(0).isClosed());
    }

    @Test
    public void shouldMapToCard() {

        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("testName", "testDescription", "testPos", "1" );
        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        //Then
        assertEquals("1", trelloCard.getListId());
        assertEquals("testName", trelloCard.getName());
        assertEquals("testDescription", trelloCard.getDescription());
        assertEquals("testPos", trelloCard.getPos());
    }

    @Test
    public void shouldMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("testName", "testDescription", "testPos", "1" );
        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        //Then
        assertEquals("1", trelloCardDto.getListId());
        assertEquals("testName", trelloCardDto.getName());
        assertEquals("testDescription", trelloCardDto.getDescription());
        assertEquals("testPos", trelloCardDto.getPos());
    }
}
