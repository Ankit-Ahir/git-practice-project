package test_cases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
	}

	@Test
	public void test1() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys("hello world");
		Thread.sleep(2000);
	}

	@Test
	public void test2() {
		Assert.assertEquals("Google", driver.getTitle());
	}

	@Test
	public void test3() {
		Assert.assertTrue(driver.findElement(By.cssSelector(".lnXdpd")).isDisplayed());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
