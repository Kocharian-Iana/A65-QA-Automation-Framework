package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    @FindBy(css = "[type='email']")
    WebElement loginField;
    @FindBy(css = "[type='password']")
    WebElement passwordField;
    @FindBy(css = "[type='submit']")
    WebElement submitButton;


    public LoginPage(WebDriver exitedDriver) {
        super(exitedDriver);
    }

    public void waitForHomePageToLoad() {
        WebDriverWait wait = new WebDriverWait(pageDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://qa.koel.app/#!/home"));
    }

    public void login(String email, String password) {
        loginField.sendKeys(email);
        passwordField.sendKeys(password);
        submitButton.click();
    }
}
