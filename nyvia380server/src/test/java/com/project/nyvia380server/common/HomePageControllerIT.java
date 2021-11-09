package com.project.nyvia380server.common;

import com.project.nyvia380server.common.page.HomePageController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomePageControllerIT {


    @Test
    void indexTest() {
        HomePageController homePageController = new HomePageController();
        String response = homePageController.index();
        assertEquals("Welcome to Nyvia380 Project Page!", response);
    }




}