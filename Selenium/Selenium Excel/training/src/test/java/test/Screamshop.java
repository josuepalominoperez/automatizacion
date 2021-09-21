package test;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screamshop {

	public void takeScreenShotTest(WebDriver driver, String nombre) throws Exception {
		File file = new File("D:\\automatizacion\\");
		File imagen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(imagen, new File(file.getAbsolutePath() + "\\" + nombre + ".png"));
	}

}
