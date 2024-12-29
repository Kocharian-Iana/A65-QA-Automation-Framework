package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    By loginField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");
    By submitButton = By.cssSelector("[type='submit']");


    public LoginPage(WebDriver exitedDriver) {
        super(exitedDriver);
    }

    public void login(String email, String password) {
        FindElement(loginField).sendKeys(email);
        FindElement(passwordField).sendKeys(password);
        FindElement(submitButton).click();
    }
}
