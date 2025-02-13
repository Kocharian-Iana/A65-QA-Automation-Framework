package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlayListPage extends BasePage {
    @FindBy (css=".fa.fa-plus-circle.create" )
    WebElement plusButton;
    @FindBy (css ="[data-testid='playlist-context-menu-create-simple']")
    WebElement NewPlayListButton;
    @FindBy (css ="input[placeholder='↵ to save']")
    WebElement newPlayListNameField;
    @FindBy (xpath ="//li [contains(text(), 'Delete')]")
    WebElement deleteButton;
    @FindBy (css =".btn-delete-playlist")
    WebElement deletePlaylistButton;
    @FindBy (css ="[data-testid = 'inline-playlist-name-input']")
    WebElement playListInput;
    String playListLocator = "//a[contains(text(), '%s')]";


    public WebElement getPlusButton() {
        return plusButton;
    }

    public WebElement getNewPlayListButton() {
        return NewPlayListButton;
    }

    public WebElement getNewPlayListNameField() {
        return newPlayListNameField;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public WebElement getDeletePlaylistButton() {
        return deletePlaylistButton;
    }

    public WebElement getPlayListInput() {
        return playListInput;
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
