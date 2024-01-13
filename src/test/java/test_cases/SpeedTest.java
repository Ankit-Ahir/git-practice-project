package test_cases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SpeedTest {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		driver.get("https://www.google.com/");
	}

	@Test
	public void test() {
		driver.findElement(By.name("q")).sendKeys("speedtest");
		List<WebElement> elements = driver.findElements(By.xpath("//ul/li"));
		for (WebElement element : elements) {
			if (element.getText().equalsIgnoreCase("speedtest")) {
				element.click();
				break;
			}
		}

		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//div[text()='RUN SPEED TEST']"))));
		driver.findElement(By.xpath("//div[text()='RUN SPEED TEST']")).click();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ARSzzc"))));
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.cssSelector(".spiqle"))));
		System.out.print(
				driver.findElement(By.cssSelector(".spiqle"))
						.getText() + " ");
		System.out.println(driver.findElement(By.cssSelector(".jct7Wc")).getText());
		System.out.print(driver.findElement(By.xpath("//div[contains(@id,'upload')]//p[@class='spiqle']"))
						.getText() + " ");
		System.out.println(driver.findElement(By.xpath("//div[contains(@id,'upload')]//p[@class='jct7Wc']")).getText());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
