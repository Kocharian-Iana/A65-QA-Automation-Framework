package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver pageDriver = null;

    public BasePage(WebDriver exitedDriver) {
        this.pageDriver = exitedDriver;
    }

    public WebElement FindElement(By locator) {
        return pageDriver.findElement(locator);
    }

    public WebElement waitAndFindWebElement(WebDriverWait wait, By locator) {
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
}
