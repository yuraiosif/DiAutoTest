package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DiWelcomePage {

    private static WebElement element = null;

    public static WebElement firstContinueButton(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"di-setup\"]/div/div[2]/div[2]/div[1]/div[3]/button"));
        return element;
    }
    public static WebElement iAgreeButton(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"di-setup\"]/div/div[2]/div[2]/div[2]/div[3]/button[2]"));
        return element;
    }
    public static WebElement inputEmailAddress(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"di-setup\"]/div/div[2]/div[2]/div[3]/div[2]/input[1]"));
        return element;
    }
    public static WebElement inputLicanseKey(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"di-setup\"]/div/div[2]/div[2]/div[3]/div[2]/input[2]"));
        return element;
    }

    public static WebElement radioButtonYes(WebDriver driver){
        element = driver.findElement(By.cssSelector("input[value='yes']"));
        return element;
    }

    public static WebElement secondContinueButton(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"di-setup\"]/div/div[2]/div[2]/div[4]/div[2]/button[2]"));
        return element;
    }
    public static WebElement anchorFirstTimeInstallation(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"di-setup\"]/div/div[2]/div[2]/div[5]/a[2]"));
        return element;
    }
    public static WebElement inputUsername(WebDriver driver){
        element = driver.findElement(By.name("username"));
        return element;
    }
    public static WebElement inputPassword(WebDriver driver){
        element = driver.findElement(By.name("password"));
        return element;
    }
    public static WebElement inputPasswordConfirm(WebDriver driver){
        element = driver.findElement(By.name("passwordconfirm"));
        return element;
    }
    public static WebElement buttonSave(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"admin-create-form\"]/div[2]/button[2]"));
        return element;
    }



}
