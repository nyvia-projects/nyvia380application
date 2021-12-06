package com.project.nyvia380server.common.user;

import com.project.nyvia380server.util.Utils;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@WebMvcTest(UserController.class)
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean //collaborator
    private UserService service;

    @MockBean
    private Utils utils;

    @Test
    void contextLoads(){
        log.info("Testing Context Loads");
        assertNotNull(mockMvc);
    }

    @Test
    void index() {
        log.info("Testing index");
        assertEquals("Message from RestController", service.getMessage());
    }

    @Test
    void getUsers() {
    }

    @Test
    void getUser() {
    }

    @Test
    void insertUser() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void getUserCount() {
    }
}