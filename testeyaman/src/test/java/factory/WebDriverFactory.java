package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

	public static WebDriver driver;
	
	public static void openChrome() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void killDriver() {
		driver.close();
		driver.quit();
	}

}
