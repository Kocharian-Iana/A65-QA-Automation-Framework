package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    WebDriver pageDriver = null;
    By successMessageLocator = (By.cssSelector("div.success.show"));

    public BasePage(WebDriver exitedDriver) {
        this.pageDriver = exitedDriver;
        // add for finding all elements @FindBy
        PageFactory.initElements(pageDriver, this);
    }

    public WebElement FindElement(By locator) {
        return pageDriver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return pageDriver.findElements(locator);
    }

    public WebElement waitAndFindWebElement(By locator) {
        WebDriverWait wait = new WebDriverWait(pageDriver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public WebElement waitUntilClickableAndFindElement(WebDriverWait wait, By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
//    public WebElement waitUntilVisible(By element){
//        return new WebDriverWait(pageDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(element));
//    }
//    public WebElement waitUntilClickable(By element){
//        return new WebDriverWait(pageDriver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));

    public void doubleClickToElement(WebElement element) {
        Actions actions = new Actions(pageDriver);
        actions.doubleClick(element).perform();
    }

    public WebElement getSuccessMessage() {
        return waitAndFindWebElement(successMessageLocator);
    }
}
