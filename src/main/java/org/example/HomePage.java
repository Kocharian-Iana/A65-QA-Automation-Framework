package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {
    @FindBy(css = ".avatar")
    WebElement avatar;
    @FindBy(css = ".album-thumb-wrapper .fa.fa-play")
    WebElement playButton;
    @FindBy(css = "[data-testid='toggle-visualizer-btn']")
    WebElement visualizer;
    @FindBy(css = "ol.top-song-list > li:first-child [tabindex='0']")
    List<WebElement> firstSongInList;
    @FindBy(css = ".playback")
    WebElement PlayButtonFromContextMenu;
    @FindBy(xpath = "//div[contains(text(),'Deleted playlist \"TestPlayList.\"')]")
    WebElement toastNotification;
    @FindBy(css = "#playlists li")
    List<WebElement> allPlayLists;


    public WebElement getAvatar() {
        return avatar;
    }

    public WebElement getPlayButton() {
        return playButton;
    }

    public WebElement getVisualizer() {
        return visualizer;
    }

    public WebElement getFirstSongInList() {
        return (WebElement) firstSongInList;
    }

    public WebElement getPlayButtonFromContextMenu() {
        return PlayButtonFromContextMenu;
    }

    public WebElement getToastNotification(WebDriverWait wait) {
        return toastNotification;
    }

    public List<WebElement> getAllPlayLists() {
        return allPlayLists;
    }
    public List<WebElement> waitForUpdatedPlayLists(int previousSize) {
        WebDriverWait wait = new WebDriverWait(pageDriver, Duration.ofSeconds(5));
        wait.until(driver -> allPlayLists.size() > previousSize);
        return allPlayLists;
    }

    public HomePage(WebDriver exitedDriver) {
        super(exitedDriver);
    }
}
