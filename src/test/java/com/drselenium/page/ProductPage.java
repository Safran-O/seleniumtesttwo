package com.drselenium.page;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import com.drselenium.method.Methods;
import org.openqa.selenium.By;

public class ProductPage {
    Methods methods;
    Logger logger = LogManager.getLogger(ProductPage.class);

    public ProductPage(){
        methods = new Methods();
    }

    public void setAndClick(){
        methods.sendKeys(By.xpath("//*[@class='search-input col-12 py-10 px-40 px-lg-50']"),"Aşkımız Eski Bir Roman");
        methods.implicitWait(By.cssSelector("//*[@class='search-input col-12 py-10 px-40 px-lg-50']"),10);
        methods.click(By.id("searchIcon"));
    }
}
