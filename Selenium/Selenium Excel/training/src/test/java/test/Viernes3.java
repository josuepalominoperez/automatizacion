package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.util.*;

public class Viernes3 {

	WebDriver driver;
	String nuevaRutaDescarga= "D:\\bbva\\demoPath";


	@BeforeClass
	public void SetUp() {
    System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver.exe");

    HashMap<String,Object> chromePrefer = new HashMap<String,Object>();
    chromePrefer.put("profile.default_content_settings_popups",0);
    chromePrefer.put("download.default_directory",nuevaRutaDescarga);

    ChromeOptions options = new ChromeOptions();
    options.setExperimentalOption("prefs",chromePrefer);

    driver = new ChromeDriver();


	}


	@Test
	public void Atest() throws Exception {

	driver.get("https://demoqa.com/menu/");
	driver.manage().window().maximize();
	Actions actions= new Actions(driver);
	WebElement menu1 = driver.findElement(By.linkText("Main Item 2"));
	actions.moveToElement(menu1).perform();
	Thread.sleep(5000);

		}
		}






