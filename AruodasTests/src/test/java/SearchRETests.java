import org.example.Helper;
import org.example.models.SearchRE;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchRETests {

    public static WebDriver driver;
   // static WebDriverWait wait;


    @Test
    public void positiveSearch() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "A. Domaševičiaus g.", "Ieškau buto", new String[]{"C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\alps.jpg"}, "https://www.youtube.com/watch?v=49q1u8qtlH8", "www.tour3d.com", "500", "67777567", "email@as.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeNoObjectType() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "A. Domaševičiaus g.", "Ieškau buto", new String[]{"C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\alps.jpg"}, "https://www.youtube.com/watch?v=49q1u8qtlH8", "www.tour3d.com", "500", "67777567", "email@as.com", new boolean[]{true, true, true},"");
        sre.fill();
        String actual = driver.findElement(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow")).getText();
        Assert.assertEquals(actual, "Pasirinkite veiksmą");
    }

    @Test
    public void positiveNoDescription() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "A. Domaševičiaus g.", "", new String[]{"C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\alps.jpg"}, "https://www.youtube.com/watch?v=49q1u8qtlH8", "www.tour3d.com", "500", "67777567", "email@as.com", new boolean[]{true, true, true}, "Sklypai kaime");
        sre.fill();
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeDescription25KCharacters() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "A. Domaševičiaus g.", generateRndStr(25000), new String[]{"C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\alps.jpg"}, "https://www.youtube.com/watch?v=49q1u8qtlH8", "www.tour3d.com", "500", "67777567", "email@as.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();

        System.out.println(driver.findElement(By.name("notes_lt")).getAttribute("value").length());
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
    public void positivePhotos37() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "A. Domaševičiaus g.", "Ieškau buto", new String[]{"C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\alps.jpg","C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\abandoned.jpg","C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\abandoned.jpg","C:\\Users\\Ieva\\Desktop\\abandoned.jpg","C:\\Users\\Ieva\\Desktop\\abandoned.jpg","C:\\Users\\Ieva\\Desktop\\abandoned.jpg","C:\\Users\\Ieva\\Desktop\\abandoned.jpg","C:\\Users\\Ieva\\Desktop\\abandoned.jpg","C:\\Users\\Ieva\\Desktop\\abandoned.jpg","C:\\Users\\Ieva\\Desktop\\abandoned.jpg","C:\\Users\\Ieva\\Desktop\\abandoned.jpg","C:\\Users\\Ieva\\Desktop\\abandoned.jpg","C:\\Users\\Ieva\\Desktop\\abandoned.jpg","C:\\Users\\Ieva\\Desktop\\abandoned.jpg"}, "https://www.youtube.com/watch?v=49q1u8qtlH8", "www.tour3d.com", "500", "", "email@as.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativePhotoSmallerThan433x460() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "A. Domaševičiaus g.", "Ieškau buto", new String[]{"C:\\Users\\Ieva\\Desktop\\sea1.jpg"}, "https://www.youtube.com/watch?v=49q1u8qtlH8", "www.tour3d.com", "500", "67777567", "email@as.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertNotEquals(actual, "Užsakyti");
    }

    @Test
    public void negativePdfFileInPhotoField() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "A. Domaševičiaus g.", "Ieškau buto", new String[]{"C:/Users/Ieva/Desktop/sample.pdf", "C:\\Users\\Ieva\\Desktop\\abandoned.jpg"}, "https://www.youtube.com/watch?v=49q1u8qtlH8", "www.tour3d.com", "500", "67777567", "email@as.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertNotEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveNoYoutubeLink() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "A. Domaševičiaus g.", "Ieškau buto", new String[]{"C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\alps.jpg"}, "", "www.tour3d.com", "500", "67777567", "email@as.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeGeneralYoutubeLink() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "A. Domaševičiaus g.", "Ieškau buto", new String[]{"C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\alps.jpg"}, "https://www.youtube.com/", "www.tour3d.com", "500", "67777567", "email@as.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.cssSelector("#newObjectForm > ul > li.has-error > span.error-arrow")).getText();
        Assert.assertEquals(actual, "Blogas embed kodas");
    }

    @Test
    public void positiveNoTour3dLink() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "A. Domaševičiaus g.", "Ieškau buto", new String[]{"C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\alps.jpg"}, "https://www.youtube.com/watch?v=49q1u8qtlH8", "", "500", "67777567", "email@as.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeWrongTour3dLink() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "A. Domaševičiaus g.", "Ieškau buto", new String[]{"C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\alps.jpg"}, "https://www.youtube.com/watch?v=49q1u8qtlH8", "www.tour3dcom", "500", "67777567", "email@as.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.cssSelector("#newObjectForm > ul > li.has-error > span.error-arrow.tour-3d-error-arrow")).getText();
//        System.out.println(actual);
        Assert.assertEquals(actual, "Bloga nuoroda");
    }

    @Test
    public void negativeNoPrice() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "A. Domaševičiaus g.", "Ieškau buto", new String[]{"C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\alps.jpg"}, "https://www.youtube.com/watch?v=49q1u8qtlH8", "www.tour3d.com", "", "67777567", "email@as.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.cssSelector("#newObjectForm > ul > li.field-interval-row.required-form-field.has-error > span.error-arrow")).getText();
        Assert.assertEquals(actual, "Neteisinga kaina");
    }

    @Test
    public void negativeMinusPrice() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "A. Domaševičiaus g.", "Ieškau buto", new String[]{"C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\alps.jpg"}, "https://www.youtube.com/watch?v=49q1u8qtlH8", "www.tour3d.com", "-500", "67777567", "email@as.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativePriceOnlyLetters() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "A. Domaševičiaus g.", "Ieškau buto", new String[]{"C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\alps.jpg"}, "https://www.youtube.com/watch?v=49q1u8qtlH8", "www.tour3d.com", "ASdfghjjkl", "67777567", "email@as.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.cssSelector("#newObjectForm > ul > li.field-interval-row.required-form-field.has-error > span.error-arrow")).getText();
        Assert.assertEquals(actual, "Neteisinga kaina");
    }

    @Test
    public void negativePriceSpecialCharacters() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "A. Domaševičiaus g.", "Ieškau buto", new String[]{"C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\alps.jpg"}, "https://www.youtube.com/watch?v=49q1u8qtlH8", "www.tour3d.com", "$#^&*^%^%^^$#", "67777567", "email@as.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.cssSelector("#newObjectForm > ul > li.field-interval-row.required-form-field.has-error > span.error-arrow")).getText();
        Assert.assertEquals(actual, "Neteisinga kaina");
    }

    @Test
    public void negativePriceZero() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "A. Domaševičiaus g.", "Ieškau buto", new String[]{"C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\alps.jpg"}, "https://www.youtube.com/watch?v=49q1u8qtlH8", "www.tour3d.com", "0", "67777567", "email@as.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.cssSelector("#newObjectForm > ul > li.field-interval-row.required-form-field.has-error > span.error-arrow")).getText();
        Assert.assertEquals(actual, "Neteisinga kaina");
    }

    @Test
    public void negativeNoPhoNo() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "A. Domaševičiaus g.", "Ieškau buto", new String[]{"C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\alps.jpg"}, "https://www.youtube.com/watch?v=49q1u8qtlH8", "www.tour3d.com", "500", "", "email@as.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow")).getText();
        Assert.assertEquals(actual, "Neteisingas telefono numeris");
    }

    @Test
    public void negativeNoEmail() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "A. Domaševičiaus g.", "Ieškau buto", new String[]{"C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\alps.jpg"}, "https://www.youtube.com/watch?v=49q1u8qtlH8", "www.tour3d.com", "500", "67777567", "", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow")).getText();
        Assert.assertEquals(actual, "Nurodykite el. pašto adresą, kad vėliau galėtumėte redaguoti arba pašalinti skelbimą");
    }

    @Test
    public void negativeEmailNoAt() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "A. Domaševičiaus g.", "Ieškau buto", new String[]{"C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\alps.jpg"}, "https://www.youtube.com/watch?v=49q1u8qtlH8", "www.tour3d.com", "500", "67777567", "emailas.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Maximum wait time of 10 seconds
        try {
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow")));
            String actualErrorMessage = errorElement.getText();
            Assert.assertEquals(actualErrorMessage, "Blogas el. pašto adresas");
        } catch (TimeoutException e) {
            // If element is not found or not visible within the specified time, handle accordingly
            Assert.fail("Error message element not found or not visible");
        }
    }

    @Test
    public void negativeEmailNoDomain() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "A. Domaševičiaus g.", "Ieškau buto", new String[]{"C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\alps.jpg"}, "https://www.youtube.com/watch?v=49q1u8qtlH8", "www.tour3d.com", "500", "67777567", "email@", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Maximum wait time of 10 seconds
        try {
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow")));
            String actualErrorMessage = errorElement.getText();
            Assert.assertEquals(actualErrorMessage, "Blogas el. pašto adresas");
        } catch (TimeoutException e) {
            // If element is not found or not visible within the specified time, handle accordingly
            Assert.fail("Error message element not found or not visible");
        }
    }

    @Test
    public void negativeEmailNoDot() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "A. Domaševičiaus g.", "Ieškau buto", new String[]{"C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\alps.jpg"}, "https://www.youtube.com/watch?v=49q1u8qtlH8", "www.tour3d.com", "500", "67777567", "email@ascom", new boolean[]{true, true, true},"Butai nuomotis");
        sre.fill();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Maximum wait time of 10 seconds
        try {
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow")));
            String actualErrorMessage = errorElement.getText();
            Assert.assertEquals(actualErrorMessage, "Blogas el. pašto adresas");
        } catch (TimeoutException e) {
            // If element is not found or not visible within the specified time, handle accordingly
            Assert.fail("Error message element not found or not visible");
        }
    }

    @Test
    public void negativeEmailSpecialCharacters() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "A. Domaševičiaus g.", "Ieškau buto", new String[]{"C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\alps.jpg"}, "https://www.youtube.com/watch?v=49q1u8qtlH8", "www.tour3d.com", "500", "67777567", "$#^&*^%^%^^$#&#@as.com", new boolean[]{true, true, true},"Butai nuomotis");
        sre.fill();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Maximum wait time of 10 seconds
        try {
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow")));
            String actualErrorMessage = errorElement.getText();
            Assert.assertEquals(actualErrorMessage, "Blogas el. pašto adresas");
        } catch (TimeoutException e) {
            // If element is not found or not visible within the specified time, handle accordingly
            Assert.fail("Error message element not found or not visible");
        }
    }

    @Test
    public void positiveEmail2Dots() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "A. Domaševičiaus g.", "Ieškau buto", new String[]{"C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\alps.jpg"}, "https://www.youtube.com/watch?v=49q1u8qtlH8", "www.tour3d.com", "500", "67777567", "email.as@as.com", new boolean[]{true, true, true},"Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeEmailStartsWithDot() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "A. Domaševičiaus g.", "Ieškau buto", new String[]{"C:\\Users\\Ieva\\Desktop\\abandoned.jpg", "C:\\Users\\Ieva\\Desktop\\alps.jpg"}, "https://www.youtube.com/watch?v=49q1u8qtlH8", "www.tour3d.com", "500", "67777567", ".emailas@as.com", new boolean[]{true, true, true},"Butai nuomotis");
        sre.fill();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Maximum wait time of 10 seconds
        try {
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow")));
            String actualErrorMessage = errorElement.getText();
            Assert.assertEquals(actualErrorMessage, "Blogas el. pašto adresas");
        } catch (TimeoutException e) {
            // If element is not found or not visible within the specified time, handle accordingly
            Assert.fail("Error message element not found or not visible");
        }
    }





    @BeforeClass
    public void beforeClass() {
        Helper.setUp();
        driver = Helper.driver;
    }


    @BeforeMethod
    public void getWebsite() {
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=10");
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










