package utils;



import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HighlightUtil {

    public static void highlight(WebDriver driver, WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        String originalStyle = element.getAttribute("style");

        js.executeScript(
            "arguments[0].setAttribute('style', 'border: 3px solid red;');",
            element
        );

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        js.executeScript(
            "arguments[0].setAttribute('style', arguments[1]);",
            element, originalStyle
        );
    }

	
}

