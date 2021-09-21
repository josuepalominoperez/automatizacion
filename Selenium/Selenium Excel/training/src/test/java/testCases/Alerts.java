package testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class Alerts {

    @Test
    public void alertss(){
        //Colocar System.setProperties de preferencia para chromedriver
        //System.setProperty("webdriver.chrome.driver","/path/chromedriver");

        //Se ha comentado esto porque estamos usando el SafariDriver en su reemplazo
        //Webdriver driver = new ChromeDriver();

        //Se está usando Safari en MacOS version 11.3.1 - BigSur por lo que ya
        //viene integrado el SafariDriver , igual hay que tener las dependencias en el pom.xml
        //ademas hay que declarar el import org.openqa.selenium.safari.SafariDriver
        WebDriver driver = new SafariDriver();
        driver.get("http://demo.guru99.com/test/delete_customer.php");
        driver.manage().window().maximize();

        WebElement textito= driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"));
        WebElement btn_submit = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]"));
        textito.sendKeys("1");
        btn_submit.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
        alert.accept();


    }
}
