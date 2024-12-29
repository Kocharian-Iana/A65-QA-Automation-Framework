package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends BasePage{

    By registrationButton = (By.cssSelector("a[href='registration']"));
    By  emailField = (By.cssSelector("[type='email']"));
    public WebElement getRegistrationButton(){
        return FindElement(registrationButton);
    }
    public WebElement getEmailField(){
        return FindElement(emailField);}


    public RegistrationPage(WebDriver exitedDriver) {
        super(exitedDriver);
    }
}
