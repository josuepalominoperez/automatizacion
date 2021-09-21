package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.Viernes;
import utilities.Constants;
import utilities.ExcelUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RegisterStudentTest {
    //creating object of ExcelUtils class
    static ExcelUtils excelUtils = new ExcelUtils();

    //using the Constants class values for excel file path
    static String excelFilePath ="D:\\bbva\\demoPath\\TestData.xls";

    WebDriver driver;

    @FindBy(id = "firstName")
    static WebElement firstName;

    @FindBy(id = "lastName")
    static WebElement lastName;

    @FindBy(id = "userEmail")
    static WebElement email;

    @FindBy(id = "gender-radio-1")
    static WebElement genderMale;

    @FindBy(id = "userNumber")
    static WebElement mobile;

    @FindBy(id = "currentAddress")
    static WebElement address;

    @FindBy(id = "submit")
    static WebElement submitBtn;

    @FindBy(id = "closeLargeModal")
    static WebElement closebtn;



    @BeforeClass
    public void SetUp() throws IOException {
        //set the Chrome Driver path
        System.setProperty("webdriver.chrome.driver","src//main/resources//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        PageFactory.initElements(driver, RegisterStudentTest.class);
        //calling the ExcelUtils class method to initialise the workbook and sheet
        excelUtils.setExcelFile(excelFilePath,"STUDENT_DATA");

    }

    @Test
    public void demo()  {


        //iterate over all the row to print the data present in each cell.
        for(int i=1;i<=excelUtils.getRowCountInSheet();i++)
        {
            //Enter the values read from Excel in firstname,lastname,mobile,email,address
            firstName.sendKeys(excelUtils.getCellDataText(i,0));
            lastName.sendKeys(excelUtils.getCellDataText(i,1));
            email.sendKeys(excelUtils.getCellDataText(i,2));
            //Click on the gender radio button using javascript
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", genderMale);
            mobile.sendKeys(excelUtils.getCellDataText(i,3));
            address.sendKeys(excelUtils.getCellDataText(i,4));
            //Scroll Down verticalmente 500px
            js.executeScript("window.scrollBy(0,500)");



            //Click on submit button
            submitBtn.click();


            closebtn.click();



        }



    }


    }


