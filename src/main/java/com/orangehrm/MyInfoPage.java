package com.orangehrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;
@Getter
public class MyInfoPage {

    private WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='My Info']")
    private WebElement myInfoMenu;

    public MyInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickMyInfo() {
        myInfoMenu.click();
    }
}

