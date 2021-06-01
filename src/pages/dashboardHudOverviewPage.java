package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class dashboardHudOverviewPage
{
    private static WebElement element = null;
    private static List<WebElement> elements = null;


    public static WebElement anchorSettings(WebDriver driver){
        element = driver.findElement(By.cssSelector("a[data-hint*=\"Settings\"]"));
        return element;
    }
    public static WebElement anchorSettingsGeneral(WebDriver driver){
        element = driver.findElement(By.cssSelector("a[href*=\"/dashboard/settings-general/\"]"));
        return element;
    }
    public static WebElement anchorAlerts(WebDriver driver){
        element = driver.findElement(By.cssSelector("a[data-hint*=\"Alerts\"]"));
        return element;
    }
    public static WebElement dropdownBySeverity(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/aside/nav/ul/li[2]/div/ul/li[1]/a"));
        return element;
    }
    public static WebElement dropdownItemLast30days(WebDriver driver){
        element = driver.findElement(By.cssSelector("a[href*=\"/dashboard/alerts/?by=Severity&option=Last30days\"]"));
        return element;
    }
    public static List<WebElement> dropdownItemLast30daysAlerts(WebDriver driver){
        elements = driver.findElements(By.className("table-collapse-item"));
        return elements;
    }
    public static WebElement buttonDownloadPeFile(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/main/div/div[1]/div[2]/div[1]/div/button"));
        return element;
    }

}
