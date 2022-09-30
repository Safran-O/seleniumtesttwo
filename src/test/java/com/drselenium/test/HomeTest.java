package com.drselenium.test;

import com.drselenium.driver.BaseTest;
import com.drselenium.page.HomePage;
import org.junit.Test;

public class HomeTest extends BaseTest {
    @Test
    public void homeTest(){
        HomePage homePage = new HomePage();
        homePage.home();
    }
}
