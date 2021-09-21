package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//Edit temp-testng-customsuite.xml
//it will run 3 tests , 1 per browser
public class TestsMultipleSession {
    @Test (priority = 0)
    public void executeSessionOne(){
        //First session of WebDriver
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Goto guru99 site
        driver.get("http://demo.guru99.com/V4/");
        //find user name text box and fill it
        driver.findElement(By.name("uid")).sendKeys("mngr318773");
        driver.findElement(By.name("password")).sendKeys("vAredub");

    }

    @Test (priority = 1)
    public void executeSessionTwo(){
        //Second session of WebDriver
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Goto guru99 site
        driver.get("http://demo.guru99.com/V4/");
        //find user name text box and fill it
        driver.findElement(By.name("uid")).sendKeys("mngr318773");
        driver.findElement(By.name("password")).sendKeys("vAredub");

    }

    @Test (priority = 2)
    public void executeSessionThree(){
        //Third session of WebDriver
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Goto guru99 site
        driver.get("http://demo.guru99.com/V4/");
        //find user name text box and fill it
        driver.findElement(By.name("uid")).sendKeys("mngr318773");
        driver.findElement(By.name("password")).sendKeys("vAredub");

    }
}
