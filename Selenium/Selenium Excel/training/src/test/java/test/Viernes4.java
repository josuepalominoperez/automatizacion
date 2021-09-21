package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Viernes4 {

	WebDriver driver;
	String rutaUpload= "D:\\bbva\\demoPath\\sample.pdf";

	@BeforeClass
	public void Iniciar() {
		System.setProperty("webdriver.chrome.driver", "src//main/resources//chromedriver.exe");
		driver = new ChromeDriver();
	}

    public void Ejecutando() throws Exception{
	File file  = new File(rutaUpload);
	String path= file.getAbsolutePath();
	driver.get("http://the-internet.herokuapp.com/upload");
	driver.manage().window().maximize();
	PageFactory.initElements(driver, Viernes4.class);
    driver.findElement(By.id("file-upload")).sendKeys(path);
    driver.findElement(By.id("file-submit")).click();
    Thread.sleep(10000);
  }






	@Test
	public void Atest() throws Exception {



		for (int i=0;i<1;i++) {


            Iniciar();
            Ejecutando();






		}



	}

	@AfterClass
	public void TearDown(){
		driver.quit();
	}





}
