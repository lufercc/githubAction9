package com.trello.appium;

import com.trello.utils.PropertiesInfo;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class DriverManager {
    private static DriverManager instance;
    private AppiumDriver driver;
    private WebDriverWait wait;

    private DriverManager() {
        initAndroidDriver();
    }

    private void initAndroidDriver() {
        driver = AppiumFactoryDriver.getDriver(PropertiesInfo.getInstance().getPlatformName()).initDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
