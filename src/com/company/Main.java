package com.company;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class Main {
    private static WebDriver driver = null;
    private static String Ip = null;
    private static WebDriverWait wait = null;

    public static void main(String[] args) throws InterruptedException {
        runTest();
    }

    private static void runTest() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Joseph\\Downloads\\chromedriver_win32\\chromedriver.exe");

        System.out.print("Enter the Ip : ");
        Scanner sc = new Scanner(System.in);
        String ip = sc.next();
        Ip = ip;



        while (true) {

            System.out.println(" -- Di Auto TEST / Menu --");
            System.out.println("1: Initial Settings");
            System.out.println("2: General settings");
            System.out.println("3: Download Alert");
            System.out.println("4: Settings");
            System.out.print("Choose Action : ");


            int menu = sc.nextInt();

            if (menu == 1)
                initilaSettings();
            else if (menu == 2)
                settingsGeneral();
            else if (menu == 3)
                downloadAlert();



        }



        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //googleSecurityPage(driver);


    }

    private static void downloadAlert() throws InterruptedException{
        driver = setIpAndChromeDriver();
        setImplicitWait(driver);
        setExplicitWait(driver);
        googleSecurityPage(driver);
        logIn(driver);
        dashboardHudOverviewPage.anchorAlerts(driver).click();
        Thread.sleep(2000);
        dashboardHudOverviewPage.dropdownBySeverity(driver).click();
        dashboardHudOverviewPage.dropdownItemLast30days(driver).click();

        List<WebElement> alerts = dashboardHudOverviewPage.dropdownItemLast30daysAlerts(driver);
        for (int i = 0; i <1; i++) {
            driver.findElements(By.cssSelector("a[aria-label*=\"Analyze\"]")).get(i).click();
        }
        Thread.sleep(5000);



        String originalHandle = driver.getWindowHandle();
        String secondWindow = "";
        for(String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                secondWindow = handle;
            }
        }
        Thread.sleep(5000);
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div/div[1]/div[2]/div[1]/div/button")));
        driver.switchTo().window(originalHandle);
        driver.close();
        driver.switchTo().window(secondWindow);
        dashboardHudOverviewPage.buttonDownloadPeFile(driver).click();

    }

    private static void settingsGeneral() throws InterruptedException{
        driver = setIpAndChromeDriver();
        setImplicitWait(driver);
        setExplicitWait(driver);
        googleSecurityPage(driver);
        logIn(driver);
        dashboardHudOverviewPage.anchorSettings(driver).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*=\"/dashboard/settings-general/\"]")));
        dashboardHudOverviewPage.anchorSettingsGeneral(driver).click();
        settingsGeneral.inputSiteName(driver).clear();
        settingsGeneral.inputSiteName(driver).sendKeys("AZZIMUT");
        settingsGeneral.inputSiteLocation(driver).clear();
        settingsGeneral.inputSiteLocation(driver).sendKeys("TASHKENT");
        settingsGeneral.dropdownTimeZone(driver).click();
        settingsGeneral.inputTimeZoneSearch(driver).sendKeys("Tash");
        settingsGeneral.inputSessionTimeOut(driver).clear();
        settingsGeneral.inputSessionTimeOut(driver).sendKeys("0");
        settingsGeneral.buttonSaveGhost(driver).click();


    }

    private static void setExplicitWait(WebDriver driver) {
         wait = new WebDriverWait(driver,30);
    }

    private static void setImplicitWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private static ChromeDriver setIpAndChromeDriver(){
        driver = new ChromeDriver();
        driver.get("https://"+Ip+"");
        return (ChromeDriver) driver;
    }

    private static void logIn(WebDriver driver)throws InterruptedException{
        loginPage.inputUserName(driver).sendKeys("Admin");
        loginPage.inputPassWord(driver).sendKeys("Azzimut.123");
        loginPage.buttonLogIn(driver).click();
    }

    private static void initilaSettings()  throws InterruptedException{
        driver = new ChromeDriver();
        driver.get("https://"+Ip+"");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        googleSecurityPage(driver);
        diWelcomePage(driver);
    }

    private static void diWelcomePage(WebDriver driver) throws InterruptedException {

        DiWelcomePage.firstContinueButton(driver).click();
        DiWelcomePage.iAgreeButton(driver).click();
        DiWelcomePage.inputEmailAddress(driver).sendKeys("norden@azzimut.com");
        DiWelcomePage.inputLicanseKey(driver).sendKeys("44BS-HuTy-TfOv-S8HI-ek7S-evky-of4j-XfnY-YZpM-tf8A-LTg=");
        DiWelcomePage.radioButtonYes(driver).click();
        Thread.sleep(2000);
        DiWelcomePage.secondContinueButton(driver).click();
        DiWelcomePage.anchorFirstTimeInstallation(driver).click();
        DiWelcomePage.inputUsername(driver).sendKeys("Admin");
        DiWelcomePage.inputPassword(driver).sendKeys("Azzimut.123");
        DiWelcomePage.inputPasswordConfirm(driver).sendKeys("Azzimut.123");
        DiWelcomePage.buttonSave(driver).click();

    }

    private static void googleSecurityPage(WebDriver driver) {
        googleSecurityPage.details_button(driver).click();
        googleSecurityPage.proceed_to_anchor(driver).click();
    }

}
