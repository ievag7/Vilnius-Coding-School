package org.example.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Plot extends RealEstate{
    public String addressNo;
    public String rcNo;
    public String area;
    public String[] purposes;

    public Plot(String region, String district, String quartal, String street, String description, String[] photos, String youtube, String tour3d, String price, String phoNo, String email, boolean[] checkBoxes, String addressNo, String rcNo, String area, String[] purposes) {
        super(region, district, quartal, street, description, photos, youtube, tour3d, price, phoNo, email, checkBoxes);
        this.addressNo = addressNo;
        this.rcNo = rcNo;
        this.area = area;
        this.purposes = purposes;
    }

    @Override
    public void fill(){
        super.fill();
        setPurposes();
        setArea();
        setAddressNo();
        setRcNo();


        submit();
    }


    public void setAddressNo(){
        driver.findElement(By.name("FHouseNum")).sendKeys(this.addressNo);
    }
    public void setRcNo(){
        driver.findElement(By.name("RCNumber")).sendKeys(this.rcNo);
    }
    public void setArea(){
        driver.findElement(By.name("FAreaOverAll")).sendKeys(this.area);
    }
    public void setPurposes() {
        for (int i = 0; i < purposes.length; i++) {
            switch (purposes[i]) {
                case "Namų valda":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[1]/label")).click();
                    break;
                case "Daugiabučių statyba":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[2]/label")).click();
                    break;
                case "Žemės ūkio":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[3]/label")).click();
                    break;
                case "Sklypas soduose":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[4]/label")).click();
                    break;
                case "Miškų ūkio":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[5]/label")).click();
                    break;
                case "Pramonės":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[6]/label")).click();
                    break;
                case "Sandėliavimo":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[7]/label")).click();
                    break;
                case "Komercinė":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[8]/label")).click();
                    break;
                case "Rekreacinė":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[9]/label")).click();
                    break;
                case "Kita":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[10]/label")).click();
                    break;

//                    List<WebElement> listPurposes = driver.findElements(By.cssSelector("label[for^='cb_FIntendance_']"));  // šis sprendimas gali dirbti daug lėčiau, bet jeigu bus pasikeitimų, čia nereiks leisti lokatorių)
//                System.out.println();
//                for (int j = 0; j < listPurposes.size(); j++) {
//                    if (listPurposes.get(i).getText().equals(this.purposes(j))){
//                        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[" + (i+1) + "]/label")).click();
//                        break;
//                    }
//
////                }
            }

            }

        }




    }
