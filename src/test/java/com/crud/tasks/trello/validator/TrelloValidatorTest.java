package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TrelloValidatorTest {

    @InjectMocks
    TrelloValidator trelloValidator;

    @Test
    void validateTrelloBoardsTest() {
        //Given
        TrelloList trelloList1 = new TrelloList("1", "First", true);
        TrelloList trelloList2 = new TrelloList("2", "Second", false);

        List<TrelloList> list1 = new ArrayList<>();

        list1.add(trelloList1);
        list1.add(trelloList2);

        TrelloBoard trelloBoard1 = new TrelloBoard("1", "First board", list1);

        List<TrelloBoard> trelloBoardList = new ArrayList<>();

        trelloBoardList.add(trelloBoard1);

        //When
        List<TrelloBoard> filteredBoards = trelloValidator.validateTrelloBoards(trelloBoardList);

        //Then
        assertEquals(1, filteredBoards.size());
    }

    @Test
    void validateTrelloCardTest() {
        //Given
        TrelloCard standardCard = new TrelloCard("Name", "Description", "1", "1");
        TrelloCard testCard = new TrelloCard("test", "test", "2", "2");

        //When
        trelloValidator.validateCard(standardCard);
        trelloValidator.validateCard(testCard);

        //Then
        assertEquals("test", testCard.getName());
    }
}
