package com.trello.appium;

import io.appium.java_client.AppiumDriver;


import com.trello.utils.PropertiesInfo;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserStackDriver implements IAppiumDriver {
    private static final Logger LOGGER = LogManager.getLogger(BrowserStackDriver.class.getSimpleName());
    private DesiredCapabilities capabilities = new DesiredCapabilities();
    private static final String apiDemosAPK = "bs://3ebe705752d1c45d6d132621cd1c36ee8e210366";

    @Override
    public AppiumDriver initDriver() {
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("automationName", "UIAutomator2");
//        capabilities.setCapability("deviceName", "Samsung Galaxy S22 Ultra");
//        capabilities.setCapability("platformVersion", "12.0");
//        capabilities.setCapability("app", apiDemosAPK);
        String browserStackUserName = PropertiesInfo.getInstance().getBrowserStackUserName();
        LOGGER.info(browserStackUserName);
//        capabilities.setCapability("browserstack.user", browserStackUserName);
        String browserStackUserKey = PropertiesInfo.getInstance().getBrowserStackUserKey();
        LOGGER.info(browserStackUserKey);
//        capabilities.setCapability("browserstack.key", browserStackUserKey);
//        capabilities.setCapability("Project", "AT-09-final");
//        capabilities.setCapability("build", "AT-09-1");
//        capabilities.setCapability("name", "AT-09 - ApiDemos");
//
//        HashMap<String, Object> browserstackOptions = new HashMap<>();
//        browserstackOptions.put("appiumVersion", "2.0.0");
//        browserstackOptions.put("userName", browserStackUserName);
//        browserstackOptions.put("accessKey", browserStackUserKey);
//        browserstackOptions.put("projectName", "AT-09-final");
//        browserstackOptions.put("buildName", "AT-09 - ApiDemos");
//        capabilities.setCapability("bstack:options", browserstackOptions);

        capabilities.setCapability("bstack:options", new HashMap<String, Object>() {{
            put("userName", browserStackUserName);
            put("accessKey", browserStackUserKey);
            put("projectName", "AT-09");
            put("buildName", "AT-09-ApiDemos");
            put("sessionName", "Api Demos Android");
        }});

        // Set device and os_version
        capabilities.setCapability("appium:deviceName", "Google Pixel 3");
        capabilities.setCapability("appium:platformVersion", "9.0");

        // Set URL of the application under test
        capabilities.setCapability("appium:app", apiDemosAPK);
        try {
//            return new AndroidDriver(new URL(String.format("https://%s:%s@hub.browserstack.com/wd/hub", browserStackUserName, browserStackUserKey)), capabilities);
            return new AndroidDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            LOGGER.warn(e);
        }
        return null;
    }
}
