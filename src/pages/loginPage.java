package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
    private static WebElement element = null;

    public static WebElement inputUserName(WebDriver driver){
        element = driver.findElement(By.id("username"));
        return element;
    }
    public static WebElement inputPassWord(WebDriver driver){
        element = driver.findElement(By.id("pwd"));
        return element;
    }
    public static WebElement buttonLogIn(WebDriver driver){
        element = driver.findElement(By.cssSelector("button[type*=\"submit\"]"));
        return element;
    }

}
