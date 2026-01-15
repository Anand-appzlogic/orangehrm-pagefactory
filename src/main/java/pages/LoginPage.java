package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;
import utils.HighlightUtil;

@Getter
public class LoginPage {

    private WebDriver driver;

    @FindAll({
        @FindBy(css = "input[name='username']"),
        @FindBy(xpath = "//input[@placeholder='Username']"),
        @FindBy(xpath = "//input[contains(@class,'oxd-input')]")
    })
    private WebElement username;

    @FindAll({
        @FindBy(css = "input[name='password']"),
        @FindBy(xpath = "//input[@type='password']"),
        @FindBy(xpath = "//input[contains(@class,'oxd-input')]")
    })
    private WebElement password;

    @FindAll({
        @FindBy(css = "button[type='submit']"),
        @FindBy(xpath = "//button[normalize-space()='Login']"),
        @FindBy(xpath = "//button[contains(@class,'orangehrm-login-button')]")
    })
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
    }

    public void login(String user, String pass) {
        HighlightUtil.highlight(driver, username);
        username.sendKeys(user);
        try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
        
        
        HighlightUtil.highlight(driver, password);
        password.sendKeys(pass);
        try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

        HighlightUtil.highlight(driver, loginBtn);
        loginBtn.click();
        try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
    }
}
