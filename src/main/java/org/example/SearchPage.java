package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage {
    By searchField = (By.cssSelector("[type='search']"));
    By viewAllButton = (By.cssSelector("[data-test='view-all-songs-btn']"));
    By highlightSongInTheList = (By.xpath("/html//section[@id='songResultsWrapper']//table[@class='items']//td[@class='title']"));
    By addToButton = (By.cssSelector(".btn-add-to"));
    By createNewPlaylist = (By.cssSelector("#songResultsWrapper [required]"));
    By successMessage = (By.cssSelector("div.success.show"));

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

    public WebElement getSuccessMessage(WebDriverWait wait) {
        return waitAndFindWebElement(wait, successMessage);
    }

    public SearchPage(WebDriver exitedDriver) {
        super(exitedDriver);
    }
}
