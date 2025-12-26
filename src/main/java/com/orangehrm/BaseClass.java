package com.orangehrm;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
public WebDriver driver;
public Properties prop;
	
@BeforeClass
public void setup() throws Exception {
	String env = System.getProperty("env", "test"); 
    String fileName = env + ".properties";
	prop = new Properties();
	prop.load(getClass()
			.getClassLoader()
			.getResourceAsStream(fileName));
	
	String url = prop.getProperty("url");
	driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    driver.get(url);
}

@AfterClass
public void tearDown() {
    driver.quit();
}

}
