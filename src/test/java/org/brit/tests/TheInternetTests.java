package org.brit.tests;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Route;
import com.microsoft.playwright.options.Media;
import org.brit.driver.PlayWrightDriver;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.sleep;

public class TheInternetTests {
    @Test
    public void waiterTest() throws InterruptedException {
        Page currentPage = PlayWrightDriver.getInstance().getCurrentPage();
        currentPage.route("**/login", route -> {
            Map<String, String> headers = new HashMap<>(route.request().headers());
            headers.remove("sec-fetch-user");
            headers.remove("upgrade-insecure-requests");
            route.resume(new Route.ResumeOptions().setHeaders(headers));
        });

// Continue requests as POST.
        currentPage.navigate("https://staging.planner.provectus.pro/login");
//        currentPage.route("**/*", route -> {
//            if (route.request().isNavigationRequest()){
//                Map<String, String> headers = new HashMap<>(route.request().headers());
//                headers.put("sec-fetch-user", "?1");
//                headers.put("upgrade-insecure-requests", "0");
//                route.resume(new Route.ResumeOptions().setHeaders(headers));
//            }});
//        currentPage.route("**/*", route -> route.resume(new Route.ResumeOptions().setMethod("GET")));
        currentPage.fill("#identifierId", "sbrit@provectus.com");
        currentPage.locator("#identifierNext").locator("button").click();
        currentPage.fill("[name=password]", "Artem2012_");
        currentPage.locator("#passwordNext").locator("button").click();
        sleep(5000);
    }
}
