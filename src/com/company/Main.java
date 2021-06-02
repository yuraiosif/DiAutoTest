package com.company;

import org.openqa.selenium.*;
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
    private static int fqdn = 0;
    private static JavascriptExecutor js = null;

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
            System.out.println("3: Settings Server&Domain");
            System.out.println("4: Download Alert");
            System.out.println("5: Settings");
            System.out.print("Choose Action : ");


            int menu = sc.nextInt();

            if (menu == 1)
                initilaSettings();
            else if (menu == 2)
                settingsGeneral();
            else if (menu == 3)
                settinigsServerAndDomain();
            else if (menu == 4)
                downloadAlert();


        }



        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //googleSecurityPage(driver);


    }

    private static void settinigsServerAndDomain() throws InterruptedException{

        driver = setIpAndChromeDriver();
        setImplicitWait(driver);
        setExplicitWait(driver);
        googleSecurityPage(driver);
        logIn(driver);
        dashboardHudOverviewPage.anchorSettings(driver).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*=\"/dashboard/settings-server/\"]")));
        dashboardHudOverviewPage.anchorServerAndDomain(driver).click();
        settingsServerAndDomain.inputDns1(driver).clear();
        settingsServerAndDomain.inputDns1(driver).sendKeys("192.168.1.1");
        settingsServerAndDomain.inputDns2(driver).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"settings-server\"]/div[2]/div[3]/button")));
        settingsServerAndDomain.buttonDnsSave(driver).click();
        settingsServerAndDomain.inputNetworkTime(driver).clear();
        settingsServerAndDomain.inputNetworkTime(driver).sendKeys("time.google.com");
        settingsServerAndDomain.inputDns2(driver).click();
        settingsServerAndDomain.buttonTimeSave(driver).click();
        settingsServerAndDomain.inputFqdn(driver).clear();
        settingsServerAndDomain.inputFqdn(driver).sendKeys("mmva"+fqdn+".di.local");
        Thread.sleep(4000);
        settingsServerAndDomain.buttonFqdnSave(driver).click();
        Thread.sleep(4000);
        System.out.println("Done");
        driver.quit();


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
        driver.manage().window().maximize();
        logIn(driver);
        dashboardHudOverviewPage.anchorSettings(driver).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*=\"/dashboard/settings-general/\"]")));
        dashboardHudOverviewPage.anchorSettingsGeneral(driver).click();
        settingsGeneral.inputSiteName(driver).clear();
        settingsGeneral.inputSiteName(driver).sendKeys("AZZIMUT");
        settingsGeneral.inputSiteLocation(driver).clear();
        settingsGeneral.inputSiteLocation(driver).sendKeys("TASHKENT");
        js.executeScript("arguments[0].scrollIntoView();", settingsGeneral.inputLicenseEmail(driver));
        settingsGeneral.dropdownTimeZone(driver).click();
        settingsGeneral.inputTimeZoneSearch(driver).sendKeys("Tash");
        Thread.sleep(2000);
        settingsGeneral.dropdownTimeZoneOption(driver).click();
        settingsGeneral.inputSessionTimeOut(driver).clear();
        settingsGeneral.inputSessionTimeOut(driver).sendKeys("0");
        settingsGeneral.buttonSaveGhost(driver).click();
        Thread.sleep(4000);
        System.out.println("Done");
        driver.quit();


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
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
        fqdn =  ((int)Ip.charAt(Ip.length()-2) - '0')*10 +((int)Ip.charAt(Ip.length()-1) - '0');
        return (ChromeDriver) driver;
    }

    private static void logIn(WebDriver driver)throws InterruptedException{
        loginPage.inputUserName(driver).sendKeys("Admin");
        loginPage.inputPassWord(driver).sendKeys("Azzimut.123");
        loginPage.buttonLogIn(driver).click();
    }

    private static void initilaSettings()  throws InterruptedException{
        driver = setIpAndChromeDriver();
        setImplicitWait(driver);
        setExplicitWait(driver);
        driver.manage().window().maximize();
        googleSecurityPage(driver);
        diWelcomePage(driver);
        Thread.sleep(4000);
        System.out.println("Done");
        driver.quit();

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
