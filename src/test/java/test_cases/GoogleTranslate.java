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

public class GoogleTranslate {

	WebDriver driver;
	WebDriverWait wait;
	String text = "test";

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		driver.get("https://www.google.com/");
	}

	@Test
	public void englishToMarathi() {
		driver.findElement(By.name("q")).sendKeys("google translate english to marathi");
		List<WebElement> elements = driver.findElements(By.xpath("//ul/li"));
		for (WebElement element : elements) {
			if (element.getText().equalsIgnoreCase("google translate english to marathi")) {
				element.click();
				break;
			}
		}
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#tw-source-text-ta"))));
		driver.findElement(By.cssSelector("#tw-source-text-ta")).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='tw-cpy-btn']/span"))));
		System.out.println("english to marathi conversion of " + text + " "
				+ driver.findElement(By.cssSelector("#tw-target-text")).getText());
	}

	@Test
	public void englishToHindi() {
		driver.findElement(By.name("q")).sendKeys("google translate english to hindi");
		List<WebElement> elements = driver.findElements(By.xpath("//ul/li"));
		for (WebElement element : elements) {
			if (element.getText().equalsIgnoreCase("google translate english to hindi")) {
				element.click();
				break;
			}
		}
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#tw-source-text-ta"))));
		driver.findElement(By.cssSelector("#tw-source-text-ta")).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='tw-cpy-btn']/span"))));
		System.out.println("english to hindi conversion of " + text + " "
				+ driver.findElement(By.cssSelector("#tw-target-text")).getText());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
