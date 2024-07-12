package com.qa.webOrder.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebOrderLoginPage {
    public WebOrderLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#ctl00_MainContent_username")
    WebElement username;
    @FindBy(css = "#ctl00_MainContent_password")
    WebElement password;
    @FindBy(css = "#ctl00_MainContent_login_button")
    WebElement loginButton;

    public void login(String username, String password) throws InterruptedException {
        Thread.sleep(2000);
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }
}
