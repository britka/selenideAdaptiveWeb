package org.brit.tests;

import org.apache.commons.io.FileUtils;
import org.brit.application.Product;
import org.brit.driver.PlayWrightDriver;
import org.brit.pages.pw.BasePagePW;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

@Listeners({MyListener.class})
public class PWTests2 {

//    static {
//        System.setProperty("log4j.logger.io.qameta.allure.AllureLifecycle", "OFF");
//    }
    @Test
    public void test() {
        PlayWrightDriver.getInstance().getCurrentPage().navigate("http://82.196.8.130/");
        List<Product> productsList = new BasePagePW()
                .getMainMenu()
                .goToLogin()
                .login("sbrit@provectus.com", "dgdfgsdrfwer23$@#sdweq")
                .getPageMenu()
                .selectCategoryAndSubCategory("Computers ", "Notebooks ")
                .getProductsList();
        System.out.println(productsList);
    }

    @Test
    public void test1() throws IOException {
        PlayWrightDriver.getInstance().getCurrentPage().navigate("http://82.196.8.130/");
        File file = new BasePagePW()
                .getMainMenu()
                .goToLogin()
                .login("sbrit@provectus.com", "dgdfgsdrfwer23$@#sdweq")
                .getPageMenu()
                .selectMainCategory("Digital downloads")
                .selectProduct("Science & Faith")
                .downloadSample();
        FileUtils.readLines(file, Charset.defaultCharset()).forEach(System.out::println);
    }
}
