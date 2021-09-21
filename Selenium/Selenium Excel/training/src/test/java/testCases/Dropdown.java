package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Dropdown {



    @Test
    public void mainb() {
        System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver.exe");
        String baseURL = "http://demo.guru99.com/test/newtours/register.php";
        WebDriver driver = new ChromeDriver();
        driver.get(baseURL);

        WebElement nombre= driver.findElement(By.name("firstName"));
        Select drpCountry = new Select(driver.findElement(By.name("country")));

        nombre.sendKeys("Oscar");
        drpCountry.selectByVisibleText("BAHAMAS");


    }
}
