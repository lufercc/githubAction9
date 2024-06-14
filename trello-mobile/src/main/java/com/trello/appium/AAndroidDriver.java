package com.trello.appium;

import com.trello.utils.PathUtils;
import com.trello.utils.PropertiesInfo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AAndroidDriver implements IAppiumDriver {
    private DesiredCapabilities capabilities = new DesiredCapabilities();
    private String apiDemosApk = PathUtils.buildPath("trello-mobile/src/test/resources/apps/apiDemos.apk");

    @Override
    public AppiumDriver initDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("appium:deviceName", "emulator-5554");
        capabilities.setCapability("appium:deviceName", "S22 Ultra de Bruno");

//        capabilities.setCapability("appium:platformVersion","11.0");
        capabilities.setCapability("appium:platformName", "android");
        capabilities.setCapability("appium:automationName", "uiautomator2");

        if (PropertiesInfo.getInstance().getApiDemosFlag()) {
            capabilities.setCapability("appium:app", apiDemosApk);
            capabilities.setCapability("appium:autoGrantPermissions", true);
            capabilities.setCapability("appium:skipDeviceInitialization", true);
            capabilities.setCapability("appium:noReset", true);
                    capabilities.setCapability("appium:allowTestPackages", true);
            capabilities.setCapability("appium:app", apiDemosApk);
        } else {
            capabilities.setCapability("appium:appPackage", "com.trello");
            capabilities.setCapability("appium:appActivity", ".home.HomeActivity");
            capabilities.setCapability("appium:fullReset", "false");
            capabilities.setCapability("appium:noReset", "true");
        }


        capabilities.setCapability("appium:forceAppLaunch", "true");


        try {
            return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
