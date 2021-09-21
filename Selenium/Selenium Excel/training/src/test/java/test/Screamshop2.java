package test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Screamshop2 {

	public void takeScreenShotTest(WebDriver driver, String nombre) throws Exception {
		File file = new File("D:\\automatizacion3\\");
		File imagen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(imagen, new File(file.getAbsolutePath() + "\\" + nombre + ".png"));
	}

}
