package com.trello.tests;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestMobile {
    @Test
    public void testPass() {
        Assert.assertTrue(true);
    }
}

//    @Test
//    public void testMobile() throws MalformedURLException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("appium:deviceName", "emulator-5554");
//
//        capabilities.setCapability("appium:platformName", "android");
//        capabilities.setCapability("appium:app", "C:\\Users\\USER\\Downloads\\ApiDemos.apk");
//        capabilities.setCapability("appium:automationName", "uiautomator2");
//        capabilities.setCapability("appium:fullReset", "false");
//        capabilities.setCapability("appium:noReset", "true");
//        capabilities.setCapability("appium:forceAppLaunch", "true");
//
//
//        AppiumDriver driver = new AndroidDriver(new URL("http://localhost:4723/"), capabilities);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("OS")));
//
//        FluentWait<AppiumDriver> waitF = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
//
//        WebElement foo = waitF.until(driverF -> {
//            return driverF.findElement(By.xpath("//android.widget.TextView[@content-desc=\"OS\"]"));
//        });
//        System.out.println(foo.getText());
//        WebElement osOption = driver.findElement(new AppiumBy.ByAccessibilityId("OS"));
//        if (osOption.isDisplayed()) {
//
//            osOption.click();
//        }
//
//        WebElement sensorOption = driver.findElement(new AppiumBy.ByAccessibilityId("Sensors"));
//
//        Assert.assertEquals(sensorOption.getText(), "Sensors");
//        driver.quit();
//    }

//    @Test
//    public void testMobileGestures() throws MalformedURLException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("appium:deviceName", "emulator-5554");
//
//        capabilities.setCapability("appium:platformName", "android");
//        capabilities.setCapability("appium:app", "C:\\Users\\USER\\Downloads\\ApiDemos.apk");
//        capabilities.setCapability("appium:automationName", "uiautomator2");
//        capabilities.setCapability("appium:fullReset", "false");
//        capabilities.setCapability("appium:noReset", "true");
//        capabilities.setCapability("appium:forceAppLaunch", "true");
//
//
//        AppiumDriver driver = new AndroidDriver(new URL("http://localhost:4723/"), capabilities);
//
//        WebElement osOption = driver.findElement(new AppiumBy.ByAccessibilityId("Views"));
////        driver.executeScript("mobile: clickGesture ", ImmutableMap.of(
////                "elementId ", ((RemoteWebElement) osOption).getId()
////        ));
////        driver.executeScript("mobile: longClickGesture ", ImmutableMap.of(
////                "elementId ", ((RemoteWebElement) osOption).getId(), "duration", 3000
////        ));
//        osOption.click();
//        driver.executeScript("mobile: scrollGesture ", ImmutableMap.of(
//                "left", 100, "top", 300, "width", 1800, "height", 1800,
//                "direction", "down",
//                "percent", 0.75
//        ));
//
////        WebElement sensorOption = driver.findElement(new AppiumBy.ByAccessibilityId("Sensors"));
////
////        Assert.assertEquals(sensorOption.getText(), "Sensors");
//        driver.quit();
//    }
//}
