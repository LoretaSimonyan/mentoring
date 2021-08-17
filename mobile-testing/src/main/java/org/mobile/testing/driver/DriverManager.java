package org.mobile.testing.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mobile.testing.configuration.AddressConfiguration;
import org.mobile.testing.configuration.CapabilitiesConfiguration;
import org.mobile.testing.configuration.ConfigurationReader;
import org.mobile.testing.configuration.EnvironmentType;

import java.io.IOException;

import static java.lang.String.format;


public class DriverManager {
//
//    private static final Logger LOG = LogManager.getRootLogger();
    private static final EnvironmentType ENVIRONMENT_TYPE = EnvironmentType.valueOf(ConfigurationReader.getInstance().env().toUpperCase());
    private static AppiumDriver<MobileElement> driver;

    private DriverManager() {

    }

    public static AppiumDriver<MobileElement> getDriver() {
        if (driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    private static AppiumDriver<MobileElement> createDriver() {
        switch (ENVIRONMENT_TYPE) {
            case LOCAL:
                driver = new AndroidDriver<>(AddressConfiguration.getAppiumDriverLocalService(ConfigurationReader.getInstance().appiumPort()),
                        CapabilitiesConfiguration.getLocalCapabilities());
                break;
            default:
                throw new IllegalArgumentException(format("Unexpected environment value: %s", ENVIRONMENT_TYPE));
        }
        //LOG.info("Driver is created");
        //LOG.info("Environment type is {}", ENVIRONMENT_TYPE);
        return driver;
    }

    public static void closeDriver() {
        if(!(getDriver() == null)) {
            getDriver().quit();
        }
        driver = null;
      //  LOG.info(("Driver is closed"));
    }

    public  static  void closeAppium() {
        AddressConfiguration.stopService();
    }

    public static void closeEmulator(){
        try {
            Runtime.getRuntime().exec(format("adb -s %s emu kill", ConfigurationReader.getInstance().udid()));
          //  LOG.info(("AVD is closed"));
        } catch (IOException e) {
           // LOG.info("AVD  was not closed, {}", e.getMessage());
        }
    }
}
