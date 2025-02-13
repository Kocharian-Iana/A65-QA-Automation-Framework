package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
    @FindBy(css = "a[href='registration']")
    WebElement registrationButton;
    @FindBy(css = "[type='email']")
    WebElement emailField;

    public WebElement getRegistrationButton() {
        return registrationButton;
    }

    public WebElement getEmailField() {
        return emailField;
    }


    public RegistrationPage(WebDriver exitedDriver) {
        super(exitedDriver);
    }
}
