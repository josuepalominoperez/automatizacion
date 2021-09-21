package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Download_file {

    private WebDriver driver;
    private String Pathfile ="D:\\bbva\\demoPath";

    @BeforeClass
    public void before_class(){
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver.exe");

        HashMap<String,Object> chromePrefs= new HashMap<String,Object>();
        chromePrefs.put("profile.default_content_settings.popups",0);
        chromePrefs.put("download.default_directory", Pathfile);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs" , chromePrefs);

        driver= new ChromeDriver(options);
    }

    @Test
    public void main_testt(){
        driver.get("http://demo.guru99.com/test/yahoo.html");
        driver.manage().window().maximize();
        WebElement btn_download = driver.findElement(By.id("messenger-download"));
        btn_download.click();
    }
}
