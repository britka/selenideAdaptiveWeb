package org.brit.driver;

import com.microsoft.playwright.*;

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
                                getBrowser()
                                        .launch(new BrowserType
                                                .LaunchOptions()
                                                .setHeadless(false)
                                        )
                                        .newContext());
                case "mobile" -> {
                    String mobileType = System.getProperty("mobileType", "Pixel 2");
                    browserContextThreadLocal.set(
                            getBrowser(DriverUtils.getMobileBrowser(mobileType))
                                    .launch(new BrowserType
                                            .LaunchOptions()
                                            .setHeadless(false))
                                    .newContext(DriverUtils.getMobileContext(mobileType).setLocale("en-US")));
                }
            }
        }
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

}
