package org.brit.pages.pw;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.brit.driver.PlayWrightDriver;
import org.brit.pages.web.*;

import java.lang.reflect.InvocationTargetException;

public class MainMenuPW {
    Page page = PlayWrightDriver.getInstance().getCurrentPage();

    private String menuRootElement = ".header-links>ul";

    public LoginPagePW goToLogin() {
        return selectMenuItem(MenuItem.LOGIN, LoginPagePW.class);
    }

    public BasePagePW logout() {
        return selectMenuItem(MenuItem.LOGOUT, BasePagePW.class);
    }

    public MyAccountPagePW goToMyAccount() {
        return selectMenuItem(MenuItem.MY_ACCOUNT, MyAccountPagePW.class);
    }

    public ShoppingCartPagePW goToShoppingCart() {
        return selectMenuItem(MenuItem.SHOPPING_CART, ShoppingCartPagePW.class);
    }

    public WithListPagePW goToWishList() {
        return selectMenuItem(MenuItem.WISHLIST, WithListPagePW.class);
    }

    public int getShoppingCartProductsCount() {
        return Integer.parseInt(getMenuItemElement(MenuItem.SHOPPING_CART)
                .locator(".cart-qty")
                .textContent()
                .replace("(", "").replace(")", ""));

    }

    private <T extends BasePagePW> T selectMenuItem(MenuItem menuItem, Class<T> pageToReturn) {
        getMenuItemElement(menuItem)
                .click();
        try {
            return pageToReturn.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private Locator getMenuItemElement(MenuItem menuItem) {
        return page.locator(menuRootElement)
                .locator("." + menuItem.getValue());
    }

    public enum MenuItem {
        REGISTER("ico-register"),
        LOGIN("ico-login"),
        WISHLIST("ico-wishlist"),
        SHOPPING_CART("ico-cart"),
        MY_ACCOUNT("ico-account"),
        LOGOUT("ico-account");

        private String value;

        MenuItem(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
