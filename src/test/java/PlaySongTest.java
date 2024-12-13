import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class PlaySongTest extends BaseTest {
    @Test
    public void playSong() {
        login("iana.kocharian@testpro.io", "CwqOPgQw");
        WebElement playButton = driver.findElement(By.cssSelector(".album-thumb-wrapper .fa.fa-play"));
        Actions actions = new Actions(driver);
        actions.moveToElement(playButton).perform();
        playButton.click();
        WebElement nextSongButton = driver.findElement(By.cssSelector(".next.fa.fa-step-forward"));
        nextSongButton.click();
        WebElement visualizer = driver.findElement(By.cssSelector("[data-testid='toggle-visualizer-btn']"));
        Assert.assertTrue(visualizer.isDisplayed());
    }
}
