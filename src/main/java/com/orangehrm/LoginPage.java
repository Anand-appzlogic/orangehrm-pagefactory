package com.orangehrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;


@Getter
public class LoginPage {
	private WebDriver driver;
	@FindBy(name = "username")
	private WebElement username;
	@FindBy(name="password")
	private WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	
	private WebElement loginbtn;
	
	
public LoginPage (WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	
}
public void login(String user, String pass) {
    username.sendKeys(user);
    password.sendKeys(pass);
    loginbtn.click();
}
}
