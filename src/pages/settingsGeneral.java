package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class settingsGeneral {

    private static WebElement element = null;

    public static WebElement inputSiteName(WebDriver driver){
        element = driver.findElement(By.name("site_name"));
        return element;
    }
    public static WebElement inputSiteLocation(WebDriver driver){
        element = driver.findElement(By.name("site-location"));
        return element;
    }
    public static WebElement dropdownTimeZone(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"settings-general\"]/div/div[2]/div[2]/div[1]/div/div/div[1]/span"));
        return element;
    }
    public static WebElement dropdownTimeZoneOption(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"settings-general\"]/div[2]/div[2]/div[2]/div[1]/div/div/div[2]/ul/li[2]"));
        return element;
    }
    public static WebElement inputTimeZoneSearch(WebDriver driver){
        element = driver.findElement(By.className("search"));
        return element;
    }
    public static WebElement inputSessionTimeOut(WebDriver driver){
        element = driver.findElement(By.id("sessiontimeout"));
        return element;
    }
    public static WebElement inputLicenseEmail(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"settings-general\"]/div[2]/div[1]/div[2]/div[2]/div[1]/input"));
        return element;
    }
    public static WebElement buttonSaveGhost(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"settings-general\"]/div[1]/div/button"));
        return element;
    }





}
