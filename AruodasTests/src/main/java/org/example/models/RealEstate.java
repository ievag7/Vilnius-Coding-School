package org.example.models;

import org.example.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class RealEstate {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public String region;
    public String district;
    public String quartal;
    public String street;
    public String description;
    public String[] photos;
    public String youtube;
    public String tour3d;
    public String price;
    public String phoNo;
    public String email;
    public boolean[] checkBoxes;

    public RealEstate(String region, String district, String quartal, String street, String description, String[] photos, String youtube, String tour3d, String price, String phoNo, String email, boolean[] checkBoxes) {
        this.region = region;
        this.district = district;
        this.quartal = quartal;
        this.street = street;
        this.description = description;
        this.photos = photos;
        this.youtube = youtube;
        this.tour3d = tour3d;
        this.price = price;
        this.phoNo = phoNo;
        this.email = email;
        this.checkBoxes = checkBoxes;
    }

    public void fill(){
        fillLocation();
        fillDescription();
        fillPhotos();
        fillYoutube();
        fillTour3d();
        fillPrice();
        fillPhoNo();
        fillEmail();
        fill3BottomCheckBoxes();
//        submit();


    }

    public void fillRegion(){
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[3]/span[1]/span")).click();
//        driver.findElement(By.xpath("//*[@id=\"regionDropdown\"]/li[2]")).click();
        List<WebElement> lis = driver.findElements(By.className("dropdown-input-values-address")).get(0).findElements(By.tagName("li"));
//        boolean found = false;
        for (int i = 0; i < lis.size(); i++) {
            if(lis.get(i).getText().equalsIgnoreCase(region)){
                lis.get(i).click();
//                found = true;
                break;
            }
//        if (!found){
//            driver.findElement(By.xpath("//*[@id=\"districtField\"]/label/span"));
        }
    }
    public void fillDistrict(){
        Helper.wait(500);
        driver.findElement(By.xpath("//*[@id=\"district\"]/span")).click();
//        driver.findElement(By.xpath("//*[@id=\"districts_461\"]/li[2]")).click();
        List<WebElement> lis = driver.findElements(By.className("dropdown-input-values-address")).get(1).findElements(By.tagName("li"));
        for (int i = 0; i < lis.size(); i++) {
            if(lis.get(i).getText().equalsIgnoreCase(district)){
                lis.get(i).click();
                break;
            }
        }
    }
    public void fillQuartal(){
        Helper.wait(500);
        String classList = driver.findElement(By.id("quartalField")).getAttribute("class");
        if(classList.contains("hide") || classList.contains("disabled")){
            return;
        }
        driver.findElement(By.xpath("//*[@id=\"quartalField\"]/span[1]/span[2]")).click();
//        driver.findElement(By.xpath("//*[@id=\"quartals_1\"]/li[2]")).click();
        List<WebElement> lis = driver.findElements(By.className("dropdown-input-values-address")).get(2).findElements(By.tagName("li"));
        for (int i = 0; i < lis.size(); i++) {
            if(lis.get(i).getText().equalsIgnoreCase(quartal)){
                lis.get(i).click();
                break;
            }
        }
    }
    public void fillStreet(){

        Helper.wait(500);
        String classList = driver.findElement(By.id("streetField")).getAttribute("class");
        if(classList.contains("disabled")){
            return;
        }
        driver.findElement(By.xpath("//*[@id=\"streetField\"]/span[1]/span[2]")).click();
//        driver.findElement(By.xpath("//*[@id=\"streets_1\"]/li[2]")).click();
        List<WebElement> lis;
        try {
            lis = driver.findElements(By.className("dropdown-input-values-address")).get(3).findElements(By.tagName("li"));
        } catch (Exception e) {
            lis = driver.findElements(By.className("dropdown-input-values-address")).get(2).findElements(By.tagName("li"));
        }
//        Helper.wait(500);
        for (int i = 0; i < lis.size(); i++) {
            if(lis.get(i).getText().contains(street)){
                lis.get(i).click();
                break;
            }
        }
    }

    public void fillLocation(){
        fillRegion();
        fillDistrict();
        fillQuartal();
        fillStreet();
    }
    public void fillDescription(){
        driver.findElement(By.name("notes_lt")).sendKeys(this.description);
    }
    public void fillPhotos(){
        for (int i = 0; i < this.photos.length; i++) {
            driver.findElement(By.xpath("//*[@id=\"uploadPhotoBtn\"]/input")).sendKeys(this.photos[i]);
            try{
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"photosThumbsList\"]/div[" + (i + 1) +"]/a")));
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
    public void fillYoutube(){
        driver.findElement(By.name("Video")).sendKeys(this.youtube);
    }
    public void fillTour3d(){
        driver.findElement(By.name("tour_3d")).sendKeys(this.tour3d);
    }
    public void fillPrice(){
        driver.findElement(By.id("priceField")).sendKeys(this.price);
    }
    public void fillPhoNo(){
//        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys(this.phoNo);
    }
    public void fillEmail(){
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(this.email);
    }
    public void fill3BottomCheckBoxes() {
//        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[23]/span/label/span")).click();
//        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[24]/div/div/div/label/span")).click();
//        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[25]/span[1]/div/div/label/span")).click();
        List<WebElement> lis = driver.findElement(By.className("new-object-from")).findElements(By.tagName("li"));
        if(this.checkBoxes[0]) {
            lis.get(lis.size() - 5).findElements(By.tagName("label")).get(1).click();
        }
        if(this.checkBoxes[1]) {
            lis.get(lis.size() - 4).findElements(By.tagName("label")).get(1).click();

        }
        if(this.checkBoxes[2]) {
            lis.get(lis.size() - 3).findElements(By.tagName("span")).get(1).click();
        }

//        if (checkBoxes[0]) {
//            driver.findElement(By.cssSelector("label[for='cbdont_show_in_ads'] span")).click();
//        }
//        if (checkBoxes[1]) {
//            driver.findElement(By.cssSelector("label[for='cbdont_want_chat'] span")).click();
//        }
//        if (checkBoxes[2]) {
//            driver.findElement(By.cssSelector("label[for='cbagree_to_rules'] span")).click();
//        }
    }

    public void submit(){
        driver.findElement(By.id("submitFormButton")).click();
    }
}




