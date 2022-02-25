package seleniumci.main;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

public class AppTest {
	public static final String URL = "http://www.google.com.br";
	public static RemoteWebDriver driver;

	@BeforeAll
	public static void config() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pedro\\eclipse-workspace\\main\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@AfterAll
	public static void close() {
		driver.close();
	}

	@Test
	public void searchRussia() {
		driver.get(URL);
		driver.findElement(By.name("q")).sendKeys("Russia");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id='hdtb-msb']/div[1]/div/div[1]"));
	}

	@Test
	public void searchUkraine() {
		driver.get(URL);
		driver.findElement(By.name("q")).sendKeys("Ukraine");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id='hdtb-msb']/div[1]/div/div[1]"));
	}
}
