package com.sap.it.qe.pets.Steps;

import java.io.File;
import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

@Slf4j
public class BaseSteps {

    public static WebDriver driver;
    public static FluentWait<WebDriver> fluentWait;
    static int count = 0;

    // Constructor for Remote Environment

//    public BaseSteps() {
//        count++;
//        System.out.println("Initialized: " + count++);
//
//        String chromeDriverPath = "";
//        Platform currentPlatform = Platform.getCurrent().family();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--no-sandbox");
//        switch (currentPlatform) {
//
//            case WINDOWS:
//                chromeDriverPath = "C:\\developmenttools\\START\\webdrivers\\chromedriver.exe";
//                break;
//
//            case UNIX:
//                chromeDriverPath = "/usr/bin/chromedriver";
//                options.addArguments("--headless=new");
//                options.addArguments("window-size=1600,900");
//                options.addArguments("--no-sandbox");
//                options.addArguments("--disable-dev-shm-usage");
//                options.addArguments("--whitelisted-ips=''");
//                break;
//        }
//
//        ChromeDriverService service = new ChromeDriverService.Builder()
//                .usingDriverExecutable(new File(chromeDriverPath))
//                .usingAnyFreePort().build();
//        driver = new ChromeDriver(service, options);
//
//        fluentWait = new WebDriverWait(driver, Duration.ofSeconds(20))
//                .ignoring(ElementClickInterceptedException.class);
//   }

//    Constructor for Local Environment

    public BaseSteps() {
        count++;
        System.out.println("Initialized: " + count++);
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1600, 900");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("applicationCacheEnabled=false");

        String chromeDriverPath = "";
        chromeDriverPath = "C:\\SAPDevelop\\QIR\\driver\\chrome-win32\\chrome-win32\\chromedriver.exe";
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(chromeDriverPath))
                .usingAnyFreePort().build();
        driver = new ChromeDriver(service, options);

        fluentWait = new WebDriverWait(driver, Duration.ofSeconds(20))
                .ignoring(ElementClickInterceptedException.class);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void waitForElementClickable(WebElement webElement) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void waitForVisible(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public static void waitForVisibleVariableTime(By element, long time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void waitABitClickable(WebElement element) {
        fluentWait.until(
                ExpectedConditions.and(
                        ExpectedConditions.elementToBeClickable(element),
                        ExpectedConditions.visibilityOf(element)
                ));
    }

    public static void clickWhenAvailable(WebElement element) {
        waitABitClickable(element);
        try {
            element.click();
        } catch (Exception e) {
            try {
                Thread.sleep(3000);
                element.click();
            } catch (ElementClickInterceptedException | InterruptedException ignored) {
            }
        }
    }
}