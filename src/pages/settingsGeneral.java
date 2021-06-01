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
        element = driver.findElement(By.className("dropdown-placeholder-value"));
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
    public static WebElement buttonSaveGhost(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"settings-general\"]/div[1]/div/button"));
        return element;
    }





}
