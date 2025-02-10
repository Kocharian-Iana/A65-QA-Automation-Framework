import org.example.BasePage;
import org.example.LoginPage;
import org.example.PlayListPage;
import org.example.SearchPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
public class AddSongToPlaylistTest extends BaseTest {
    LoginPage loginPage = null;
    SearchPage searchPage = null;
    PlayListPage playListPage = null;

    @Test(groups = "Smoke")
    public void addSongToPlaylist() {
        String playListName = "test1";
        loginPage = new LoginPage(driver);
        loginPage.login("iana.kocharian@testpro.io", "CwqOPgQw");
        searchPage = new SearchPage(driver);
        searchPage.getSearchField().sendKeys("BossStatus");
        searchPage.getSearchField().sendKeys(Keys.ENTER);
        searchPage.getViewAllButton().click();
        searchPage.getHighlightSongInTheList().click();
        searchPage.getAddToButton().click();
        searchPage.getCreateNewPlaylist().sendKeys(playListName);
        searchPage.getCreateNewPlaylist().sendKeys(Keys.ENTER);
        searchPage.getSuccessMessage().getText();
        String testMessage = searchPage.getSuccessMessage().getText();
        Assert.assertTrue(searchPage.getSuccessMessage().isDisplayed());
        Assert.assertTrue(testMessage.contains("Created playlist \"test1.\""));
        playListPage = new PlayListPage(driver);
        playListPage.deletePlayListByButton(playListName);
    }
}