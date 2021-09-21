package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

public class iFrame {

    private WebDriver driver;
    private String Pathfile ="D:\\demo\\demoPath";


    @Test
    public void main_testt(){
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/guru99home/");
        driver.manage().window().maximize();
        driver.switchTo().frame("a077aa5e"); //switching the frame by ID

        System.out.println("********We are switch to the iframe*******");
        driver.findElement(By.xpath("html/body/a/img")).click();
        //Clicks the iframe

        System.out.println("*********We are done***************");
    }
}
