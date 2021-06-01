package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class googleSecurityPage {

    private static WebElement element = null;

    public static WebElement details_button(WebDriver driver){
        element = driver.findElement(By.id("details-button"));
        return element;
    }
    public static WebElement proceed_to_anchor(WebDriver driver){
        element = driver.findElement(By.id("proceed-link"));
        return element;
    }


}
