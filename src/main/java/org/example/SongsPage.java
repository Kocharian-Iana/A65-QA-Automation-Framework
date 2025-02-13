package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SongsPage extends BasePage {
    @FindBy(css = "[href='\\#\\!\\/songs']")
    WebElement allSongsPage;

    public WebElement getAllSongPage() {
        return allSongsPage;
    }

    public SongsPage(WebDriver exitedDriver) {
        super(exitedDriver);
    }
}
