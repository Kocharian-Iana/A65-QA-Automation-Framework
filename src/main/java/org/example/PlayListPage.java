package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlayListPage extends BasePage {
    By plusButton = (By.cssSelector(".fa.fa-plus-circle.create"));
    By NewPlayListButton = (By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
    By newPlayListNameField = (By.cssSelector("input[placeholder='↵ to save']"));
    By deleteButton = (By.xpath("//li [contains(text(), 'Delete')]"));
    By deletePlaylistButton = (By.cssSelector(".btn-delete-playlist"));
    By playListInput = (By.cssSelector("[data-testid = 'inline-playlist-name-input']"));
    String playListLocator = "//a[contains(text(), '%s')]";


    public WebElement getPlusButton() {
        return FindElement(plusButton);
    }

    public WebElement getNewPlayListButton() {
        return FindElement(NewPlayListButton);
    }

    public WebElement getNewPlayListNameField() {
        return FindElement(newPlayListNameField);
    }

    public WebElement getDeleteButton() {
        return FindElement(deleteButton);
    }

    public WebElement getDeletePlaylistButton() {
        return FindElement(deletePlaylistButton);
    }

    public WebElement getPlayListInput() {
        return FindElement(playListInput);
    }

    public void createPlayList(String playListName) {
        getPlusButton().click();
        getNewPlayListButton().click();
        getNewPlayListNameField().click();
        getNewPlayListNameField().sendKeys(playListName);
        getNewPlayListNameField().sendKeys(Keys.ENTER);
    }

    public void deletePlayListByContextMenu(WebDriverWait wait, Actions actions, String playListName) {
        WebElement playList = waitAndFindWebElement(By.xpath(String.format("//a[contains(text(), '%s')]", playListName)));
        actions.contextClick(playList).perform();
        getDeleteButton().click();
    }

    public void deletePlayListByButton(String playListName) {
        getDeletePlaylistButton().click();

    }

    public PlayListPage(WebDriver exitedDriver) {
        super(exitedDriver);
    }

    public WebElement getPlayListByName(String playListName) {
        return waitAndFindWebElement(By.xpath(String.format(playListLocator, playListName)));

    }

    public void renamePlayListName(String currentPlayListName, String newPlayListName) {
        doubleClickToElement(getPlayListByName(currentPlayListName));
        for (int i = 0; i < currentPlayListName.length(); i++) {
            getPlayListInput().sendKeys(Keys.BACK_SPACE);
        }
        getPlayListInput().sendKeys(newPlayListName);
        getPlayListInput().sendKeys(Keys.ENTER);
        getSuccessMessage();
    }
}
