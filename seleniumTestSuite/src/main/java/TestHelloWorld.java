import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestHelloWorld {

	public WebDriver driver;

	public String testURL = "http://localhost:8080/greeting?name=Gaston";

	@BeforeMethod
	public void setupTest (){
		//Create a new ChromeDriver
		System.setProperty("webdriver.chrome.driver", ".//target//test-classes//chromedriver.exe");
		driver = new ChromeDriver();

		driver.navigate().to(testURL);
	}

	//-----------------------------------Tests-----------------------------------
	@Test
	public void firstTest () {
		System.out.println("TestHelloWorld Selenium test start...");

		String expectedGreeting = "Hello! Gaston";

		String retrievedGreeting = driver.findElement(By.id("greetingField")).getText();

		//Print page's title
		System.out.println("The greeting result: " + retrievedGreeting);

		//Assertion
		Assert.assertEquals(expectedGreeting, retrievedGreeting);

		System.out.println("TestHelloWorld Selenium test end.");
	}

	//-----------------------------------Test TearDown-----------------------------------
	@AfterMethod
	public void teardownTest (){
		//Close browser and end the session
		driver.quit();
	}

}
