package org.brit.driver;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class PlayWrightDriver {
    private static PlayWrightDriver instance = null;
    ThreadLocal<BrowserContext> browserContextThreadLocal = new ThreadLocal<>();
    ThreadLocal<Playwright> playwrightThreadLocal = new ThreadLocal<>();
    ThreadLocal<Page> pageThreadLocal = new ThreadLocal<>();

    private PlayWrightDriver() {
    }


    public synchronized static PlayWrightDriver getInstance() {
        if (instance == null) {
            instance = new PlayWrightDriver();
        }
        return instance;
    }

    public BrowserContext getNewBrowserContext() {
        if (browserContextThreadLocal.get() == null) {
            switch (System.getProperty("whereToRun", "web")) {
                case "web" -> browserContextThreadLocal
                        .set(
                                getPlayWright()
                                        .chromium()
//                                        .connect("ws://moon.aerokube.local/playwright/chromium/playwright-1.22.0?headless=false",
//                                                new BrowserType.ConnectOptions().setTimeout(30000))
                                        .launch(getLaunchOptions())
                                        .newContext(new Browser.NewContextOptions().setAcceptDownloads(true)));
                case "mobile" -> {
                    String mobileType = System.getProperty("mobileType", "Pixel 2");
                    browserContextThreadLocal.set(
                            getBrowser(DriverUtils.getMobileBrowser(mobileType))
                                    .launch(getLaunchOptions())
                                    .newContext(DriverUtils.getMobileContext(mobileType).setLocale("en-US").setAcceptDownloads(true)));
                }
            }
        }
        browserContextThreadLocal.get().setDefaultTimeout(60000);
        return browserContextThreadLocal.get();
    }

    private BrowserType getBrowser() {
        String launchBrowser = System.getProperty("launchBrowser", "chrome");
        return getBrowser(launchBrowser);
    }

    private BrowserType getBrowser(String launchBrowser) {

        switch (launchBrowser) {
            case "firefox":
                return getPlayWright().firefox();
            case "webkit":
                return getPlayWright().webkit();
            case "chrome":
            default:
                return getPlayWright().chromium();
        }
    }


    public Page getCurrentPage() {
        if (getNewBrowserContext().pages().size() == 0) {
            pageThreadLocal.set(getNewBrowserContext().newPage());
        }
        return pageThreadLocal.get();
    }

    public Playwright getPlayWright() {
        if (playwrightThreadLocal.get() == null) {
            playwrightThreadLocal.set(Playwright.create());
        }
        return playwrightThreadLocal.get();
    }

    private BrowserType.LaunchOptions getLaunchOptions() {
        return new BrowserType
                .LaunchOptions()
                .setHeadless(false)
                .setDownloadsPath(Paths.get("downloads"))
                .setTimeout(60000);
                //.setSlowMo(700);
    }

}
