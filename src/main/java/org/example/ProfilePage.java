package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage extends BasePage{
    By profileAvatar = (By.cssSelector("#userBadge img"));
    By currentPasswordField = (By.cssSelector("#inputProfileCurrentPassword"));
    public WebElement getProfileAvatar(WebDriverWait wait){
        wait.withTimeout(Duration.ofSeconds(20));
        return waitUntilClickableAndFindElement(wait, profileAvatar);
    }
    public WebElement getCurrentPasswordField (WebDriverWait wait){
        wait.withTimeout(Duration.ofSeconds(20));
        return waitUntilClickableAndFindElement(wait,currentPasswordField);
    }
    public ProfilePage(WebDriver exitedDriver) {
        super(exitedDriver);
    }
}
