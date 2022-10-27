package org.brit.driver;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.microsoft.playwright.Browser;
import org.brit.driver.mobile_device.MobileDeviceParameters;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DriverUtils {
    public static Browser.NewContextOptions getMobileContext(String mobileContext) {
        Map<String, MobileDeviceParameters> mobileList = readMobilesList();
        MobileDeviceParameters mobileDeviceParameters = mobileList.get(mobileContext);
        Browser.NewContextOptions newContextOptions = new Browser.NewContextOptions()
                .setUserAgent(mobileDeviceParameters.getUserAgent())
                .setViewportSize(mobileDeviceParameters.getViewportSize())
                .setDeviceScaleFactor(mobileDeviceParameters.getDeviceScaleFactor())
                .setIsMobile(mobileDeviceParameters.getIsMobile())
                .setHasTouch(mobileDeviceParameters.getHasTouch());
        if (mobileDeviceParameters.getScreen() != null) {
            newContextOptions.setScreenSize(mobileDeviceParameters.getScreenSize());
        }
        return newContextOptions;
    }

    public static String getMobileBrowser(String mobileContext) {
        return readMobilesList().get(mobileContext).getDefaultBrowserType();
    }

    public static Map<String, MobileDeviceParameters> readMobilesList() {
        String file = DriverUtils.class.getClassLoader().getResource("devices/devices.yaml").getFile();
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        TypeReference<Map<String, MobileDeviceParameters>> typeRef = new TypeReference<>() {
        };
        Map<String, MobileDeviceParameters> mobileList = null;
        try {
            mobileList = objectMapper.readValue(new File(file), typeRef);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return mobileList;
    }

}
