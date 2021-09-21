package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Viernes2 {

	WebDriver driver;
	WebDriverWait wait;
	private static Map<Integer, Object[]> map;
	private static Screamshop2 screamshop2;
	private int contador;


	@FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")
	static WebElement first_name;

	@FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")
	static WebElement last_name;

	@FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")
	static WebElement address;

	@FindBy(xpath = "//*[@id=\"eid\"]/input")
	static WebElement email_address;

	@FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")
	static WebElement phone;

	@FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[1]/input")
	static WebElement gender;

	@FindBy(id = "checkbox2")
	static WebElement checkbox2;

	@FindBy(id = "checkbox3")
	static WebElement checkbox3;

	@FindBy(id = "msdd")
	static WebElement languages;

	@FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[8]/a")
	static WebElement languages1;

	@FindBy(xpath = "//*[@id=\"Skills\"]/option[39]")
	static WebElement skills;

	@FindBy(xpath = "//*[@id=\"countries\"]/option[177]")
	static WebElement country;

	@FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[10]/div/span/span[1]/span")
	static WebElement select_country;

	@FindBy(xpath = "//*[@id=\"select2-country-container\"]")
	static WebElement select_country1;

	@FindBy(id = "select2-country-container")
	static WebElement select_country2;

	@FindBy(xpath = "//*[@id=\"yearbox\"]/option[80]")
	static WebElement year_birth;

	@FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select/option[6]")
	static WebElement month;

	@FindBy(xpath = "//*[@id=\"daybox\"]/option[2]")
	static WebElement day;

	@FindBy(id = "firstpassword")
	static WebElement firstpassword;

	@FindBy(id = "secondpassword")
	static WebElement secondpassword;

	@FindBy(id = "submitbtn")
	static WebElement submitbtn ;






	@BeforeClass
	public void Iniciar() {
		System.setProperty("webdriver.chrome.driver", "src//main/resources//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		PageFactory.initElements(driver, Viernes2.class);
		wait = new WebDriverWait(driver, 20);
		map = new TreeMap<Integer, Object[]>();
		screamshop2 = new Screamshop2();
		contador = 0;
	}



	@Test(dataProvider = "datos")
	public void Atest(List<String> entrada) throws Exception {


		first_name.sendKeys("Oscar");



		last_name.clear();
		last_name.sendKeys("Palomino");



		address.clear();
		address.sendKeys("Av La Molina 123");


		email_address.clear();
		email_address.sendKeys("oscar@gmail.com");


		phone.clear();
		phone.sendKeys("9444487654");


		gender.click();


		screamshop2.takeScreenShotTest(driver, "imagen002");
		checkbox2.click();



		checkbox3.click();


		languages.click();
		wait.until(ExpectedConditions.visibilityOf(languages1));
		languages1.click();


		skills.click();
		screamshop2.takeScreenShotTest(driver, "imagen001");


		country.click();


		List<WebElement> options = select_country2.findElements(By.tagName("Australia"));

		for (WebElement option1 : options) {

			if("Australia".equals(option1.getText().trim()))

				option1.click();
		}


		year_birth.click();


		month.click();


		day.click();


		firstpassword.clear();
		firstpassword.sendKeys("Aliqiiqiq233");

		Thread.sleep(5000);
		secondpassword.clear();
		secondpassword.sendKeys("Aliqiiqiq233");
		screamshop2.takeScreenShotTest(driver, "imagen002");



	}

	@DataProvider(name = "datos")
	public static Object[][] datos() {
		return new Object[][] { { InputOutputExcel.readExcelFile(0)

		} };
	}

	@AfterClass
	public void FinalMetodo() {
		InputOutputExcel.SaveDataExcel(map);
	}

}
