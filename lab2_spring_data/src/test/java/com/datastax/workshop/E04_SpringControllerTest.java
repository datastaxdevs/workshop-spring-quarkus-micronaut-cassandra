package com.datastax.workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import com.datastax.workshop.todo.Todo;

public class E04_SpringControllerTest {
    
    TestRestTemplate restTemplate = new TestRestTemplate();
    
    @Test
    public void should_retrieve_todolist() {
        Assertions.assertEquals(HttpStatus.OK, 
                restTemplate.exchange(System.getenv("SPRING_DATA_URL") + "/api/v1/todos/", 
                        HttpMethod.GET, new HttpEntity<String>(null, new HttpHeaders()), 
                        Todo[].class).getStatusCode());
    }

}

