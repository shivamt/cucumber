package cucumber.testComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import cucumber.pageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver initializeDriver() throws IOException {
		//properties file
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+"//src//main//java//rahulshettyacademy//resources//GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
	   
		
		} else if(browserName.equalsIgnoreCase("firefox"))
		{
			
			
			
		} else if(browserName.equalsIgnoreCase("edge")) {
			
			
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		}
	
	@BeforeMethod
	public LandingPage launchApplication() throws IOException{
		driver = initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
		
	}
	@AfterMethod
	public void tearDown() {
		
		driver.close();
	}
	
	
	
}
