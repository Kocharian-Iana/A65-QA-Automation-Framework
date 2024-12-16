import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class SongsTest extends BaseTest {
    @Test
    public void countSongs() {
        login("iana.kocharian@testpro.io", "CwqOPgQw");
        WebElement allSongsPage = driver.findElement(By.cssSelector("[href='\\#\\!\\/songs']"));
        allSongsPage.click();
        //создаем лист с лоекаторами всех  песен
        List<WebElement> songs = driver.findElements(By.cssSelector(".song-item"));
        //узнаем размер нашего списка песен
        int size = songs.size();
        System.out.println(size);
        List<String> songsNames = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            //спросить у Светланы почему мы передаём сначала get(i) а потом .getText
            String name = songs.get(i).getText();
            songsNames.add(name);
        }
        System.out.println(songsNames);
    }
}
