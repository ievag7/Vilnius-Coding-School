package org.example;

import org.example.models.RealEstate;
import org.example.models.SearchRE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helper {

    public static WebDriver driver;
    static WebDriverWait wait;

    public static void setUp(){
        if(driver != null){
            return;
        }
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
//        options.addArguments("window-size=1400,800");
//        options.addArguments("disable-gpu");
//        driver = new ChromeDriver(options);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        RealEstate.driver = driver;
        RealEstate.wait = wait;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        acceptCookies();
    }

    public static void wait (int millis){
        try{
            Thread.sleep(millis);
        }catch (Exception e){}
    }

    public static void acceptCookies() {
        driver.get("https://www.aruodas.lt/");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

}
