package org.brit.pages.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PageMenuMobileWeb implements IPageMenu {
    @Override
    public MainCategoryPage selectMainCategory(String categoryName) {
        ElementsCollection topMenuItems = $$(".top-menu.mobile>li>a");
        if (topMenuItems.size() == 0){
            $(".menu-toggle").click();
            topMenuItems = $$(".top-menu.mobile>li>a");
        }
        topMenuItems.find(Condition.text(categoryName))
                .click();
        return new MainCategoryPage();
    }

    @Override
    public ProductsPage selectCategoryAndSubCategory(String category, String subCategory) {
        ElementsCollection topMenuItems = $$(".top-menu.mobile>li>a");
        if (topMenuItems.get(0).is(Condition.not(Condition.visible))){
            $(".menu-toggle").click();
            topMenuItems = $$(".top-menu.mobile>li>a");
        }
        SelenideElement parent = topMenuItems.find(Condition.text(category)).parent();
        parent.$(".sublist-toggle").click();
        parent.$$("ul>li>a").find(Condition.text(subCategory)).click();
        return new ProductsPage();
    }
}
