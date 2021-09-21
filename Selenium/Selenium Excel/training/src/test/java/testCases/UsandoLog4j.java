package testCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import org.apache.log4j.xml.DOMConfigurator;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;



public class UsandoLog4j {


    private static Logger Log = Logger.getLogger(UsandoLog4j.class.getName());


    @Test
    public void mainb() throws InterruptedException {
        DOMConfigurator.configure("log4j.xml");
        System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        Log.info("New driver instantiated");


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Log.info("Implicit wait applied on the driver for 10 seconds");



        driver.get("http://demo.guru99.com/test/newtours/register.php");
        Log.info("Web application launched");



        WebElement nombre= driver.findElement(By.name("firstName"));
        String name= "Jhonny";
        nombre.sendKeys(name);
        Log.info("Name sent: "+name);


        Select drpCountry = new Select(driver.findElement(By.name("country")));
        String country = "BAHAMAS";
        drpCountry.selectByVisibleText(country);
        Log.info("Country selected: "+country);


        driver.quit();
        Log.info("Browser closed");


    }
}
