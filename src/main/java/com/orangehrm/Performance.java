package com.orangehrm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Performance {
	private WebDriver driver;
	@FindBy(xpath = "//span[normalize-space()='Performance']")
	private WebElement performancePage;
	
	public Performance(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	public void clickPerformance() {
		performancePage.click();
	}

}
