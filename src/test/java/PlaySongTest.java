import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaySongTest extends BaseTest {
    @Test
    public void playSong() {
        login("iana.kocharian@testpro.io", "CwqOPgQw");
        WebElement playButton = driver.findElement(By.cssSelector(".album-thumb-wrapper .fa.fa-play"));
        actions.moveToElement(playButton).perform();
        playButton.click();
        WebElement nextSongButton = driver.findElement(By.cssSelector(".next.fa.fa-step-forward"));
        nextSongButton.click();
        WebElement visualizer = driver.findElement(By.cssSelector("[data-testid='toggle-visualizer-btn']"));
        Assert.assertTrue(visualizer.isDisplayed());
    }

    @Test
    public void playSongByContextClick() throws InterruptedException {
        login("iana.kocharian@testpro.io", "CwqOPgQw");
        WebElement firstSongInList = driver.findElement(By.cssSelector("ol.top-song-list > li:first-child [tabindex='0']"));
        actions.contextClick(firstSongInList).perform();
        WebElement playButton = driver.findElement(By.cssSelector(".playback"));
        playButton.click();
        WebElement visualizer = driver.findElement(By.cssSelector("[data-testid='toggle-visualizer-btn']"));
        Assert.assertTrue(visualizer.isDisplayed());
    }
}
