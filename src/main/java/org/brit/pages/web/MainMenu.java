package org.brit.pages.web;


import com.codeborne.selenide.SelenideElement;
import lombok.SneakyThrows;

import java.lang.reflect.InvocationTargetException;

import static com.codeborne.selenide.Selenide.$;

public class MainMenu {

    private SelenideElement menuRootElement = $(".header-links>ul");

    public LoginPage goToLogin(){
        return selectMenuItem(MenuItem.LOGIN, LoginPage.class);
    }

    public BasePage logout(){
        return selectMenuItem(MenuItem.LOGOUT, BasePage.class);
    }

    public MyAccountPage goToMyAccount(){
        return selectMenuItem(MenuItem.MY_ACCOUNT, MyAccountPage.class);
    }

    public ShoppingCartPage goToShoppingCart(){
        return selectMenuItem(MenuItem.SHOPPING_CART, ShoppingCartPage.class);
    }

    public WithListPage goToWishList(){
        return selectMenuItem(MenuItem.WISHLIST, WithListPage.class);
    }

    private <T extends BasePage> T selectMenuItem(MenuItem menuItem, Class<T> pageToReturn) {
        menuRootElement.$("." + menuItem.getValue()).click();
        try {
            return pageToReturn.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
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
