//new changes
package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilitiy.WebEventListener;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public void initialize() throws IOException {
		fr = new FileReader("C:\\Users\\F884270\\eclipse-workspace\\DatadrivenPOM\\src\\main\\java\\config\\config.properties");
		prop.load(fr);
		
		if(prop.getProperty("browser").equalsIgnoreCase("Chrome")) {
		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
		}
		
		else if(prop.getProperty("browser").equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		
		} 
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	/*
	@Test
	public void verifyLogo() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]/a/img")));
		if(driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/a/img")).isDisplayed()) {
			System.out.println("logo present");
		}
		else {System.out.println("logo not present");}
	
		Thread.sleep(2000);
	}
	*/
	
}

