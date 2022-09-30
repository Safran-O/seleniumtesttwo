package com.drselenium.method;

import com.drselenium.driver.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import javax.swing.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Methods {
    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsdriver;

    public Methods() {

        driver = BaseTest.driver;
        wait = new FluentWait<WebDriver>(driver);
        wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        jsdriver = (JavascriptExecutor) driver;
    }

    public WebElement findElement(By by) {

        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void click(By by) {
        findElement(by).click();
    }

    public void waitBySecond(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void implicitWait(By by, long seconds){
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable((by)));
    }


    public boolean isElementVisiable(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
        //return false;
    }

    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
    }

    public void scrollWithAction(By by) { //aşağı doğru kaydırma yapar.
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }

    public void scrollWithJavascript(By by) {
        jsdriver.executeScript("arguments[0].scrollIntoView();", findElement(by));
    }

    public Select getSelect(By by) {
        return new Select(findElement(by));
    }

    public void selectByText(By by, String text) { //selecetion alanlarında değer seçer, Fiyat Artan gibi
        getSelect(by).selectByVisibleText(text);
    }

    public String getAttribute(By by, String attributeName) { //alandan değer çeker. Logindeki Password yazar o mesela
        return findElement(by).getAttribute(attributeName);
    }

    public String getText(By by){
        return findElement(by).getText(); //id vs alanında yazılan değeri çeker
    }
    //document.getElementById('search-input').value Chrome da Console ile değeri almak için kullanılır.
    //$('#button1').click() sistemde konsoleda click işlemi için kullanılır.

    public String getValue(By by){
        return jsdriver.executeScript("return arguments[0].value",findElement(by)).toString();
    }//alana gönderilen değeri çeker.
}
