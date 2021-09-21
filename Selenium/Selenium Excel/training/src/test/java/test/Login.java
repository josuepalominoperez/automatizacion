package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {


    public static void main (String[] args){
        System.setProperty("webdriver.chrome.driver" , "src//main//resources//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rsps100.com/vote/760?__cf_chl_jschl_tk__=d5cf59cd19e195dcaa52cd566b75eb05d5302f3c-1614133824-0-AVLPA9Yltf7ducMQvfiKKjEhNvo0h56oQpv8S-P_1dDWksYC4Oy_fJGw_48rowhHHwLSK2ftRhqkaL3CfGsQ73NMGldxNjPG7j6L3CFUP5XAPOrmWYlTr2P68mfdl4xdjlxRYuZrkN_FMQpCUXGHkMSqfxwyhDA3-KjoFabThW8RQNchoOzu2l9ZWVAmi8woYw2l8_X-o0wXDk0Y_tfgB2EaUn6oGg5vnt_rctcdwj5ZTCPWxmYhO_4Q0AHMXaGC7ogS6T5_uFb6Ag4lvzUd3GRWv53hW5Bfrx8IzJtZO8e1uD-_Um3HyijMUbTplS0hGO1im5l4oeOV1Eb9nUwa2hdWHp1P3FkZh5EdKJlvPxAuYSc4X0vBtcGFdbd6RJHvXQ");
        new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-checkmark"))).click();
    }
}
