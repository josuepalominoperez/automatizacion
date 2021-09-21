package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.io.File;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class IncognitoMode {

    @Test
    public void mainx(){
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        driver.manage().window().maximize();
        //driver.quit();


    }
}
