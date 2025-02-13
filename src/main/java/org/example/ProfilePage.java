package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProfilePage extends BasePage {
    @FindBy(css = "#userBadge img")
    WebElement profileAvatar;
    @FindBy(css = "#inputProfileCurrentPassword")
    WebElement currentPasswordField;
    @FindBy(xpath = "//div[contains(@data-testid, 'theme-card')]")
    List<WebElement> themes;

    public WebElement waitForAvatarToBeClickable(WebDriverWait wait) {
        return wait.until(ExpectedConditions.elementToBeClickable(profileAvatar));
    }

    public WebElement getCurrentPasswordField() {
        return currentPasswordField;
    }

    public List<WebElement> getAllThemes() {
        return themes;
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
