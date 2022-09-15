package com.crud.tasks.trello.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TrelloConfigTest {

    @Autowired
    TrelloConfig trelloConfig;

    @Test
    void shouldGetTrelloApiEndpoint() {
        //Given & When
        String endpoint = trelloConfig.getTrelloApiEndpoint();

        //Then
        assertNotNull(endpoint);
    }

    @Test
    void shouldGetTrelloAppKey() {
        //Given & When
        String key = trelloConfig.getTrelloAppKey();

        //Then
        assertNotNull(key);
    }

    @Test
    void shouldGetTrelloToken() {
        //Given & When
        String token = trelloConfig.getTrelloToken();

        //Then
        assertNotNull(token);
    }

    @Test
    void shouldGetTrelloUser() {
        //Given & When
        String user = trelloConfig.getTrelloUser();

        //Then
        assertNotNull(user);
    }
}
