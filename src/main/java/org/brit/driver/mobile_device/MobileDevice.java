package org.brit.driver.mobile_device;

import com.google.gson.annotations.SerializedName;

public class MobileDevice {
    @SerializedName("name")
    private String name;
    @SerializedName("parameters")
    private MobileDeviceParameters parameters;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MobileDeviceParameters getParameters() {
        return parameters;
    }

    public void setParameters(MobileDeviceParameters parameters) {
        this.parameters = parameters;
    }
}
