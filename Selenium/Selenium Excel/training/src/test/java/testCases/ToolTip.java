package testCases;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

@Test
public class ToolTip {
    public void jquery_tooltip() throws InterruptedException {

        String baseUrl = "http://demo.guru99.com/test/tooltip.html";
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        String expectedTooltip = "What's new in 3.2";
        driver.get(baseUrl);

        WebElement download = driver.findElement(By.xpath(".//*[@id='download_now']"));
        Actions builder = new Actions (driver);

        builder.clickAndHold().moveToElement(download);
        builder.moveToElement(download).build().perform();
        Thread.sleep(10000);

        WebElement toolTipElement = driver.findElement(By.xpath(".//*[@class='box']/div/a"));
        String actualTooltip = toolTipElement.getText();

        System.out.println("Actual Title of Tool Tip  "+actualTooltip);
        if(actualTooltip.equals(expectedTooltip)) {
            System.out.println("Test Case Passed");
        }
        driver.close();
    }
}

