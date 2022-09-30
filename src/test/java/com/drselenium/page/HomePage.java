package com.drselenium.page;

import com.drselenium.method.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePage {

    Methods methods;
    public HomePage(){
        methods = new Methods();
    }
    public void home(){
        methods.waitBySecond(5);
        Assert.assertTrue(methods.isElementVisiable(By.xpath("//*[@class='logo col-4 col-lg-1 text-center']")));

        methods.click(By.xpath("//*[@class='campaign-link dr-flex ml-15']//*[@class='font-weight-bold']"));
        methods.waitBySecond(5);
    }
}