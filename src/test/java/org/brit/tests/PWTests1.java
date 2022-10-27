package org.brit.tests;

import org.brit.driver.PlayWrightDriver;
import org.brit.pages.pw.BasePagePW;
import org.brit.pages.pw.ProductsPagePW;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PWTests1 {
    @Test
    public void test() {
        PlayWrightDriver.getInstance().getCurrentPage().navigate("http://82.196.8.130/");


        ProductsPagePW productsPagePW = new BasePagePW()
                .getMainMenu()
                .goToLogin()
                .login("sbrit@provectus.com", "dgdfgsdrfwer23$@#sdweq")
                .getPageMenu()
                .selectCategoryAndSubCategory("Computers", "Notebooks");
        int shoppingCartProductsCountBefore = productsPagePW
                .getMainMenu()
                .getShoppingCartProductsCount();


        int shoppingCartProductsCountAfter = productsPagePW
                .addProductToCart("HP Envy 6-1180ca 15.6-Inch Sleekbook")
                .getMainMenu()
                .getShoppingCartProductsCount();

        assertThat(shoppingCartProductsCountAfter).isGreaterThan(shoppingCartProductsCountBefore);
    }
}
