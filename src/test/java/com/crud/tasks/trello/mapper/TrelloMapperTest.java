package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TrelloMapperTest {

    @InjectMocks
    TrelloMapper trelloMapper;

    @Test
    void mapToBoardsTest() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "list name", true);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "2 list name", false);
        TrelloListDto trelloListDto3 = new TrelloListDto("3", "3 list name", true);

        List<TrelloListDto> list1 = new ArrayList<>();
        List<TrelloListDto> list2 = new ArrayList<>();

        list1.add(trelloListDto1);
        list1.add(trelloListDto2);
        list2.add(trelloListDto3);

        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("4", "Board 1", list1);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("5", "Board 2", list2);

        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();

        trelloBoardDtoList.add(trelloBoardDto1);
        trelloBoardDtoList.add(trelloBoardDto2);

        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDtoList);

        //Then
        assertEquals("2", trelloBoards.get(0).getLists().get(1).getId());
        assertEquals("3 list name", trelloBoards.get(1).getLists().get(0).getName());
    }

    @Test
    void mapToBoardsDtoTest() {
        //Given
        TrelloList trelloList1 = new TrelloList("1", "First", true);
        TrelloList trelloList2 = new TrelloList("2", "Second", false);
        TrelloList trelloList3 = new TrelloList("3", "Third", true);

        List<TrelloList> list1 = new ArrayList<>();
        List<TrelloList> list2 = new ArrayList<>();

        list1.add(trelloList1);
        list1.add(trelloList2);
        list2.add(trelloList3);

        TrelloBoard trelloBoard1 = new TrelloBoard("1", "First board", list1);
        TrelloBoard trelloBoard2 = new TrelloBoard("2", "Second board", list2);

        List<TrelloBoard> trelloBoardList = new ArrayList<>();

        trelloBoardList.add(trelloBoard1);
        trelloBoardList.add(trelloBoard2);

        //When
        List<TrelloBoardDto> trelloBoardDtoList = trelloMapper.mapToBoardsDto(trelloBoardList);

        //Then
        assertFalse(trelloBoardDtoList.get(0).getLists().get(1).isClosed());
    }

    @Test
    void mapToListTest() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "list name", true);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "2 list name", false);
        TrelloListDto trelloListDto3 = new TrelloListDto("3", "3 list name", true);

        List<TrelloListDto> list1 = new ArrayList<>();

        list1.add(trelloListDto1);
        list1.add(trelloListDto2);
        list1.add(trelloListDto3);

        //When
        List<TrelloList> trelloLists = trelloMapper.mapToList(list1);

        //Then
        assertTrue(trelloLists.get(2).isClosed());
    }

    @Test
    void mapToListDtoTest() {
        //Given
        TrelloList trelloList1 = new TrelloList("1", "First", true);
        TrelloList trelloList2 = new TrelloList("2", "Second", false);
        TrelloList trelloList3 = new TrelloList("3", "Third", true);

        List<TrelloList> list1 = new ArrayList<>();

        list1.add(trelloList1);
        list1.add(trelloList2);
        list1.add(trelloList3);

        //When
        List<TrelloListDto> trelloListDtoList = trelloMapper.mapToListDto(list1);

        //Then
        assertEquals("2", trelloListDtoList.get(1).getId());
    }

    @Test
    void mapToCardDto() {
        //Given
        TrelloCard trelloCard1 = new TrelloCard("Name", "Description", "1", "1");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard1);

        //Then
        assertEquals("Name", trelloCardDto.getName());
    }

    @Test
    void mapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("First name", "First description", "1", "1");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals("1", trelloCard.getListId());
    }
}
