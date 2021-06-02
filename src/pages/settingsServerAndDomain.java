package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class settingsServerAndDomain {
    private static WebElement element = null;

    public static WebElement inputDns1(WebDriver driver){
        element = driver.findElement(By.id("dns1"));
        return element;
    }
    public static WebElement inputDns2(WebDriver driver){
        element = driver.findElement(By.id("dns2"));
        return element;
    }
    public static WebElement inputNetworkTime(WebDriver driver){
        element = driver.findElement(By.id("ntp"));
        return element;
    }
    public static WebElement inputFqdn(WebDriver driver){
        element = driver.findElement(By.id("fqdn"));
        return element;
    }
    public static WebElement buttonDnsSave(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"settings-server\"]/div[2]/div[3]/button"));
        return element;
    }
    public static WebElement buttonTimeSave(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"settings-server\"]/div[2]/div[2]/button"));
        return element;
    }
    public static WebElement buttonFqdnSave(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"settings-server\"]/div[2]/div[1]/button"));
        return element;
    }

}
