package com.trello.appium;

import com.trello.utils.PropertiesInfo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserStackDriverIOS implements IAppiumDriver {
    private static final Logger LOGGER = LogManager.getLogger(BrowserStackDriverIOS.class.getSimpleName());
    private DesiredCapabilities capabilities = new DesiredCapabilities();
    private static final String apiDemosIPA = "bs://8a53bba8d39e67b7673bc588c57d3a0876524bfe";

    @Override
    public AppiumDriver initDriver() {
        String browserStackUserName = PropertiesInfo.getInstance().getBrowserStackUserName();
        String browserStackUserKey = PropertiesInfo.getInstance().getBrowserStackUserKey();
        capabilities.setCapability("bstack:options", new HashMap<String, Object>() {{
            put("userName", browserStackUserName);
            put("accessKey", browserStackUserKey);
            put("projectName", "AT-09");
            put("buildName", "AT-09-ApiDemos");
            put("sessionName", "Api Demos IOS");
        }});

        // Set device and os_version
        capabilities.setCapability("appium:deviceName", "iPhone 14 Pro");
        capabilities.setCapability("appium:platformVersion", "16.0");
        capabilities.setCapability("appium:automationName", "XCUITest");

        // Set URL of the application under test
        capabilities.setCapability("appium:app", apiDemosIPA);
        try {
            return new IOSDriver(new URL(String.format("https://%s:%s@hub.browserstack.com/wd/hub", browserStackUserName, browserStackUserKey)), capabilities);
        } catch (MalformedURLException e) {
            LOGGER.warn(e);
        }
        return null;
    }
}
