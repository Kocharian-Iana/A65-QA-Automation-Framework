package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage {
    By searchField = (By.cssSelector("[type='search']"));
    By viewAllButton = (By.cssSelector("[data-test='view-all-songs-btn']"));
    By highlightSongInTheList = (By.xpath("/html//section[@id='songResultsWrapper']//table[@class='items']//td[@class='title']"));
    By addToButton = (By.cssSelector(".btn-add-to"));
    By createNewPlaylist = (By.cssSelector("#songResultsWrapper [required]"));


    public WebElement getSearchField() {
        return FindElement(searchField);
    }

    public WebElement getViewAllButton() {
        return FindElement(viewAllButton);
    }

    public WebElement getHighlightSongInTheList() {
        return FindElement(highlightSongInTheList);
    }

    public WebElement getAddToButton() {
        return FindElement(addToButton);
    }

    public WebElement getCreateNewPlaylist() {
        return FindElement(createNewPlaylist);
    }
    public SearchPage(WebDriver exitedDriver) {
        super(exitedDriver);
    }
}
