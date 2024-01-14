import org.example.Helper;
import org.example.models.Plot;
import org.example.models.SearchRE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PlotTests {

    public static WebDriver driver;


    @Test
    public void positiveSearch() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis",   "A. Domaševičiaus g.", "Ieškau buto", new String[]{"C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\alps.jpg"}, "https://www.youtube.com/watch?v=49q1u8qtlH8", "www.tour3d.com", "500", "67777567", "email@as.com", new boolean[]{true, true, true},"99", "1234-1234-1234", "50", new String[]{"Namų valda", "Daugiabučių statyba", "Žemės ūkio", "Sklypas soduose", "Miškų ūkio", "Pramonės", "Sandėliavimo", "Komercinė", "Rekreacinė", "Kita"});
        p.fill();
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveNoDescription() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "A. Domaševičiaus g.", "Ieškau buto", new String[]{"C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\alps.jpg"}, "https://www.youtube.com/watch?v=49q1u8qtlH8", "www.tour3d.com", "500", "67777567", "email@as.com", new boolean[]{true, true, true}, "99", "1234-1234-1234", "50", new String[]{"Namų valda"});
        p.fill();
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveNoPhotos() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "A. Domaševičiaus g.", "Ieškau buto", new String[]{}, "https://www.youtube.com/watch?v=49q1u8qtlH8", "www.tour3d.com", "500", "67777567", "email@as.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveNoAddressNo() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "A. Domaševičiaus g.", "Ieškau buto", new String[]{"C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\alps.jpg"}, "https://www.youtube.com/watch?v=49q1u8qtlH8", "www.tour3d.com", "500", "67777567", "email@as.com", new boolean[]{true, true, true}, "", "1234-1234-1234", "50", new String[]{"Namų valda"});
        p.fill();
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveNoRcNo() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis",   "A. Domaševičiaus g.", "Ieškau buto", new String[]{"C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\alps.jpg"}, "https://www.youtube.com/watch?v=49q1u8qtlH8", "www.tour3d.com", "500", "67777567", "email@as.com", new boolean[]{true, true, true},"99", "", "50", new String[]{"Namų valda"});
        p.fill();
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @BeforeClass
    public void beforeClass() {
        Helper.setUp();
        driver = Helper.driver;
    }

    @BeforeMethod
    public void getWebsite() {
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=11&offer_type=1");
    }

    public static String generateRndStr(int length) {
        String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345678901234567890";
        String text = "";
        for (int i = 0; i < length; i++) {
            text += symbols.charAt((int) (Math.random() * symbols.length()));
        }
        return text;
    }
}
