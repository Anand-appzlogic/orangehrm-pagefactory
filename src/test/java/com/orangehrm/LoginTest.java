package com.orangehrm;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    @Test(priority = 1)
    public void testLoginAndMyInfo() {
    	String env = System.getProperty("env", "test");

    	String username = System.getProperty(
    	        "username",
    	        prop.getProperty("username")
    	);

    	String password = System.getProperty(
    	        "password",
    	        prop.getProperty("password")
    	);
    	System.out.println("Running on environment : " + env);
    	System.out.println("Username entered       : " + username);
    	System.out.println("Password entered       : " + password);
    	
    	

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),
                "Login failed");
        }
    
    @Test(priority = 2, dependsOnMethods = "testLoginAndMyInfo")
    public void myInfoTest() {

        MyInfoPage myInfoPage = new MyInfoPage(driver);
        myInfoPage.clickMyInfo();

        Assert.assertTrue(driver.getCurrentUrl().contains("viewPersonalDetails"),
                "My Info page not opened");
    }
    
    @Test(priority = 3)
    public void performanceTest() {
    	Performance performance = new Performance(driver);
    	performance.clickPerformance();
    	Assert.assertTrue(driver.getCurrentUrl().contains("searchEvaluatePerformanceReview"), 
    			"performance page not opned");
    }
     
    
}
