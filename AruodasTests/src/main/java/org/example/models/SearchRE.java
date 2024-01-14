package org.example.models;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class SearchRE extends RealEstate {



    public String objectType;

    public SearchRE(String region, String district, String quartal, String street, String description, String[] photos, String youtube, String tour3d, String price, String phoNo, String email, boolean[] checkBoxes, String objectType) {
        super(region, district, quartal, street, description, photos, youtube, tour3d, price, phoNo, email, checkBoxes);
        this.objectType = objectType;
    }

    @Override
    public void fill(){
        super.fill();
        fillObjectType();
       submit();
    }
    public void fillSubmit(){
        fill();
       submit();
    }

    public void fillObjectType(){
        WebElement dropdownElement = driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]/ul"));
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]/span")).click();
        List<WebElement> dropdownItems = dropdownElement.findElements(By.tagName("li"));
        for(int i = 0; i < dropdownItems.size(); i++) {
            WebElement item = dropdownItems.get(i);

            if (item.getAttribute("textContent").equals(this.objectType)) {
                item.click();
                break;
            }
        }
    }





}
