package com.drselenium.test;

import com.drselenium.page.ProductPage;
import org.junit.Test;

public class ProductTest {
    @Test
    public void productTest(){
        ProductPage productPage = new ProductPage();
        productPage.setAndClick();
    }
}
