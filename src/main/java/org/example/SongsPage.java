package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SongsPage extends BasePage{
    By  allSongsPage = (By.cssSelector("[href='\\#\\!\\/songs']"));
    public WebElement getAllSongPage(){
        return FindElement(allSongsPage);
    }
    public SongsPage(WebDriver exitedDriver) {
        super(exitedDriver);
    }
}
