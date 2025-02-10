package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProfilePage extends BasePage {
    By profileAvatar = (By.cssSelector("#userBadge img"));
    By currentPasswordField = (By.cssSelector("#inputProfileCurrentPassword"));
    By themes = (By.xpath("//div[contains(@data-testid, 'theme-card')]"));

    public WebElement getProfileAvatar(WebDriverWait wait) {
        wait.withTimeout(Duration.ofSeconds(20));
        return waitUntilClickableAndFindElement(wait, profileAvatar);
    }

    public WebElement getCurrentPasswordField(WebDriverWait wait) {
        wait.withTimeout(Duration.ofSeconds(20));
        return waitUntilClickableAndFindElement(wait, currentPasswordField);
    }

    public List<WebElement> getAllThemes() {
        return findElements(themes);
    }

    public void choseThemeByName(String themeName) {
        for (WebElement element : getAllThemes()
        ) {
            if (element.getText().equals(themeName)) {
                element.click();
            }
        }
    }

    public boolean themeIsSelected(String themeName) {
        for (WebElement element : getAllThemes()) {
            if (element.getAttribute("class").contains("selected")) ;
            {
                return true;
            }
        }
        return false;
    }

    public ProfilePage(WebDriver exitedDriver) {
        super(exitedDriver);
    }
}
