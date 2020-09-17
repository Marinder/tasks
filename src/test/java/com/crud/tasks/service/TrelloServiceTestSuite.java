package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTestSuite {
    @InjectMocks
    private TrelloService trelloService;

    @Mock
    private AdminConfig adminConfig;

    @Mock
    private TrelloClient trelloClient;

    @Mock
    private SimpleEmailService emailService;

    @Test
    public void shouldFetchTrelloBoards() {
        //Given
        List<TrelloBoardDto> trelloBoardDto = new ArrayList<>();

        when(trelloClient.getTrelloBoards()).thenReturn(trelloBoardDto);

        //When
        List<TrelloBoardDto> fetchedTrelloBoards = trelloService.fetchTrelloBoards();

        //Then
        assertEquals(0, fetchedTrelloBoards.size());
    }


    @Test
    public void shouldCreateCard(){
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Test task","Test description","top","test_id");

        CreatedTrelloCardDto creadteTrelloCardDto = new CreatedTrelloCardDto("1","Test task","http://test.com");

        when(trelloClient.createNewCard(trelloCardDto)).thenReturn(creadteTrelloCardDto);

        //When
        CreatedTrelloCardDto newCard = trelloService.createTrelloCard(trelloCardDto);

        //Then
        assertEquals("1", newCard.getId());
        assertEquals("Test task", newCard.getName());
        assertEquals("http://test.com", newCard.getShortUrl());
    }
}
