package org.brit.tests;

import org.brit.application.Product;
import org.brit.driver.PlayWrightDriver;
import org.brit.pages.pw.BasePagePW;
import org.testng.annotations.Test;

import java.util.List;

public class PWTests2 {
    @Test
    public void test(){
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
}
