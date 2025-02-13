package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
    @FindBy(css = "[type='search']")
    WebElement searchField;
    @FindBy(css = "[data-test='view-all-songs-btn']")
    WebElement viewAllButton;
    @FindBy(xpath = "/html//section[@id='songResultsWrapper']//table[@class='items']//td[@class='title']")
    WebElement highlightSongInTheList;
    @FindBy(css = ".btn-add-to")
    WebElement addToButton;
    @FindBy(css = "#songResultsWrapper [required]")
    WebElement createNewPlaylist;


    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getViewAllButton() {
        return viewAllButton;
    }

    public WebElement getHighlightSongInTheList() {
        return highlightSongInTheList;
    }

    public WebElement getAddToButton() {
        return addToButton;
    }

    public WebElement getCreateNewPlaylist() {
        return createNewPlaylist;
    }

    public SearchPage(WebDriver exitedDriver) {
        super(exitedDriver);
    }
}
