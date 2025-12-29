package com.orangehrm;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
public WebDriver driver;
public Properties prop;
public ScreenshotUtil screenshotUtil;
	
@BeforeClass
public void setup() throws Exception {
	String env = System.getProperty("env", "test"); 
    String fileName = env + ".properties";
	prop = new Properties();
	prop.load(getClass()
			.getClassLoader()
			.getResourceAsStream(fileName));
	
	String url = System.getProperty("url", prop.getProperty("url"));
	String browser = System.getProperty("browser","chrome");
	switch(browser.toLowerCase()) {
	case "firefox":
		driver = new FirefoxDriver();
		break;
	case "edge":
		driver = new EdgeDriver();
		break;
	case "chrome":
		driver = new ChromeDriver();
		break;
		
	}
	driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    driver.get(url);
    
    screenshotUtil = new ScreenshotUtil(driver);
}

@AfterClass
public void tearDown() {
    driver.quit();
}

}
