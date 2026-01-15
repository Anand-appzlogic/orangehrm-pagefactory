package utils;



import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ScreenshotUtil {
	
	private WebDriver driver;
	
	
	

    public void captureScreenshot(String screenshotName) {
        try {
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        	wait.until(driver -> ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE));
        	
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            
           
            File destFolder = new File("screenshots");
            if (!destFolder.exists()) {
                destFolder.mkdir();
            }

           
            FileUtils.copyFile(src, new File(destFolder, screenshotName + ".png"));
            System.out.println("Screenshot taken: " + screenshotName + ".png");
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
}
