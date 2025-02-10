package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage {
    By avatar = (By.cssSelector(".avatar"));
    By playButton = (By.cssSelector(".album-thumb-wrapper .fa.fa-play"));
    By visualizer = (By.cssSelector("[data-testid='toggle-visualizer-btn']"));
    By firstSongInList = (By.cssSelector("ol.top-song-list > li:first-child [tabindex='0']"));
    By PlayButtonFromContextMenu = (By.cssSelector(".playback"));
    By toastNotification = (By.xpath("//div[contains(text(),'Deleted playlist \"TestPlayList.\"')]"));
    By allPlayLists = (By.cssSelector("#playlists li"));


    public WebElement getAvatar() {
        return FindElement(avatar);
    }

    public WebElement getPlayButton() {
        return FindElement(playButton);
    }

    public WebElement getVisualizer() {
        return FindElement(visualizer);
    }

    public WebElement getFirstSongInList() {
        return FindElement(firstSongInList);
    }

    public WebElement getPlayButtonFromContextMenu() {
        return FindElement(PlayButtonFromContextMenu);
    }

    public WebElement getToastNotification(WebDriverWait wait) {
        return waitAndFindWebElement(toastNotification);
    }

    public List<WebElement> getAllPlayLists() {
        return findElements(allPlayLists);
    }

    public HomePage(WebDriver exitedDriver) {
        super(exitedDriver);
    }
}
