
package org.brit.driver.mobile_device;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.playwright.options.ScreenSize;
import com.microsoft.playwright.options.ViewportSize;

public class MobileDeviceParameters {
    @SerializedName("userAgent")
    @Expose
    private String userAgent;
    @SerializedName("viewport")
    @Expose
    private Viewport viewport;
    @SerializedName("deviceScaleFactor")
    @Expose
    private Double deviceScaleFactor;
    @SerializedName("isMobile")
    @Expose
    private Boolean isMobile;
    @SerializedName("hasTouch")
    @Expose
    private Boolean hasTouch;
    @SerializedName("defaultBrowserType")
    @Expose
    private String defaultBrowserType;

    @SerializedName("screen")
    private Screen screen;

    public ScreenSize getScreenSize() {
        return new ScreenSize(screen.getWidth(), screen.getHeight());
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Screen getScreen() {
        return screen;
    }

    public MobileDeviceParameters withScreen(Screen screen) {
        this.screen = screen;
        return this;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public MobileDeviceParameters withUserAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    public ViewportSize getViewportSize() {
        return new ViewportSize(viewport.getWidth(), viewport.getHeight());
    }

    public Viewport getViewport() {
        return viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }

    public MobileDeviceParameters withViewport(Viewport viewport) {
        this.viewport = viewport;
        return this;
    }

    public Double getDeviceScaleFactor() {
        return deviceScaleFactor;
    }

    public void setDeviceScaleFactor(Double deviceScaleFactor) {
        this.deviceScaleFactor = deviceScaleFactor;
    }

    public MobileDeviceParameters withDeviceScaleFactor(Double deviceScaleFactor) {
        this.deviceScaleFactor = deviceScaleFactor;
        return this;
    }

    public Boolean getIsMobile() {
        return isMobile;
    }

    public void setIsMobile(Boolean isMobile) {
        this.isMobile = isMobile;
    }

    public MobileDeviceParameters withIsMobile(Boolean isMobile) {
        this.isMobile = isMobile;
        return this;
    }

    public Boolean getHasTouch() {
        return hasTouch;
    }

    public void setHasTouch(Boolean hasTouch) {
        this.hasTouch = hasTouch;
    }

    public MobileDeviceParameters withHasTouch(Boolean hasTouch) {
        this.hasTouch = hasTouch;
        return this;
    }

    public String getDefaultBrowserType() {
        return defaultBrowserType;
    }

    public void setDefaultBrowserType(String defaultBrowserType) {
        this.defaultBrowserType = defaultBrowserType;
    }

    public MobileDeviceParameters withDefaultBrowserType(String defaultBrowserType) {
        this.defaultBrowserType = defaultBrowserType;
        return this;
    }

}
