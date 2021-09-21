package testCases;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class OpeningNewTab {



    @Test
    public void maincd() {
        System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver.exe");
        ChromeDriver driver= new ChromeDriver();
        String baseURL = "http://www.google.com";
        driver.get(baseURL);

        String theURL = "https://www.guru99.com/selenium-tutorial.html";
        ((JavascriptExecutor)driver).executeScript("window.open(arguments[0])",theURL);


    }
}
