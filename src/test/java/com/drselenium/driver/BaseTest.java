package com.drselenium.driver;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {
    public static WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/java/resources/chromedriver.exe");
        //2. kısım resources altında sağ click copy path deyip alıyoruz 3.su
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("disable-plugins");
        chromeOptions.addArguments("disable-popup-blocking");
        chromeOptions.addArguments("ignore-certificate-errors");
        chromeOptions.addArguments("disable-translate");
        chromeOptions.addArguments("disable-extensions");

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        chromeOptions.merge(desiredCapabilities);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.get("https://www.dr.com.tr/");
    }
    @After
    public void tearDown(){
        if (driver != null){
            //quit driverı kapatır, close ise sayfayı kapar.
            driver.close();
            driver.quit();
        }
    }
}
