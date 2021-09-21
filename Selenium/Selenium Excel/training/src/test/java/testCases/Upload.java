package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Upload {

    @Test
    public void mainx(){
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String MyUrl = "http://demo.guru99.com/test/upload/";
        driver.navigate().to(MyUrl);
        driver.manage().window().maximize();

        WebElement subir = driver.findElement(By.id("uploadfile_0"));
        WebElement checkk = driver.findElement(By.id("terms"));
        WebElement btn_enviar = driver.findElement(By.id("submitbutton"));

        subir.sendKeys("D:\\app\\hola_mundo.txt");
        checkk.click();
        btn_enviar.click();


    }
}
