import org.example.HomePage;
import org.example.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaySongTest extends BaseTest {
    LoginPage loginPage = null;
    HomePage homePage = null;

    @Test
    public void playSong() {
        loginPage = new LoginPage(driver);
        loginPage.login("iana.kocharian@testpro.io", "CwqOPgQw");
        homePage = new HomePage(driver);
        actions.moveToElement(homePage.getPlayButton()).perform();
        homePage.getPlayButton().click();
        WebElement nextSongButton = driver.findElement(By.cssSelector(".next.fa.fa-step-forward"));
        nextSongButton.click();
        Assert.assertTrue(homePage.getVisualizer().isDisplayed());
    }

    @Test
    public void playSongByContextClick() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.login("iana.kocharian@testpro.io", "CwqOPgQw");
        actions.contextClick(homePage.getFirstSongInList()).perform();
        homePage.getPlayButtonFromContextMenu().click();
        Assert.assertTrue(homePage.getVisualizer().isDisplayed());
    }
}
