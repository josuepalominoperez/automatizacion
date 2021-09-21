package test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Viernes {

	WebDriver driver;
	WebDriverWait wait;
	private static Map<Integer, Object[]> map;
	private static Screamshop screamshop;
	private int contador;

	@FindBy(id = "empresa")
	static WebElement id_empresa;

	@FindBy(id = "usuario")
	static WebElement usuario;

	@FindBy(name = "eai_password")
	static WebElement password;

	@FindBy(id = "aceptar")
	static WebElement enviar;

	@FindBy(id = "kyop-menuOption-4436200510-menuLeft")
	static WebElement transferencias;

	@FindBy(id = "kyop-opcionMenuHija_m_4436200511-menuLeft")
	static WebElement transferencias_individuales;

	@FindBy(id = "b1")
	static WebElement b1;

	@FindBy(name = "Importe")
	static WebElement Importe;

	@FindBy(name = "Observaciones")
	static WebElement Observaciones;

	@FindBy(name = "Submit")
	static WebElement Submit;

	@FindBy(id = "b2")
	static WebElement b2;

	@FindBy(id = "claveTokenOperaciones")
	static WebElement claveTokenOperaciones;

    @FindBy(id = "kyop-menuLateral")
	static WebElement kyop_menuLateral;



	@BeforeClass
	public void Iniciar() {
		System.setProperty("webdriver.chrome.driver", "src//main/resources//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://test.bbvanetcash.pe/local_pibee/KDPOSolicitarCredenciales_es.html");
		driver.manage().window().maximize();
		PageFactory.initElements(driver, Viernes.class);
		wait = new WebDriverWait(driver, 1);
		map = new TreeMap<Integer, Object[]>();
		screamshop = new Screamshop();
		contador = 0;

	}

    public void Ejecutando() throws  Exception{

        id_empresa.clear();
        id_empresa.sendKeys("00009286");
        usuario.clear();
        usuario.sendKeys("USOLIDA1");
        password.sendKeys("PA112233");
        enviar.submit();
        Thread.sleep(10000);
        transferencias.click();
        transferencias_individuales.click();
        Thread.sleep(35000);
        driver.switchTo().frame("kyop-central-load-area");
        b1.click();
        Thread.sleep(20000);
        Importe.sendKeys("22");
        Observaciones.sendKeys("demo");
        Submit.click();
        Thread.sleep(10000);
        b2.click();
        claveTokenOperaciones.click();
        claveTokenOperaciones.sendKeys("11");
        Submit.click();
        driver.close();
    }


	public void TerceraParte() throws  Exception{
		driver.switchTo().defaultContent();
	}

	public void CuartaParte() throws  Exception{
		transferencias_individuales.click();
		Thread.sleep(35000);
		driver.switchTo().frame("kyop-central-load-area");
		b1.click();
		Thread.sleep(20000);
		Importe.sendKeys("22");
		Observaciones.sendKeys("demo");
		Submit.click();
		Thread.sleep(10000);
		b2.click();
		claveTokenOperaciones.click();
		claveTokenOperaciones.sendKeys("11");
		Submit.click();
	}

	@Test(dataProvider = "datos")
	public void Atest(List<String> nombre) throws Exception {



		for (int i=0;i<2;i++) {

			//contador++;
            Iniciar();
            Ejecutando();





			/*buscar.clear();
			buscar.sendKeys(obj_nombre);
			buscar.sendKeys(Keys.ENTER);*/

			//screamshop.takeScreenShotTest(driver, "imagen002");

			//map.put(contador,
				//	new Object[] { String.valueOf(contador), "registro", obj_nombre, " PASO ", " Validar en la BD" });
		}



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
