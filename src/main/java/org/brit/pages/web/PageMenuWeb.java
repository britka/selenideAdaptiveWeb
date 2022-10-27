package org.brit.pages.web;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$$;

public class PageMenuWeb implements IPageMenu {
    @Override
    public MainCategoryPage selectMainCategory(String categoryName) {
        $$(".top-menu>li>a")
                .find(Condition.text(categoryName))
                .click();
        return new MainCategoryPage();
    }

    @Override
    public ProductsPage selectCategoryAndSubCategory(String category, String subCategory) {
        $$(".top-menu>li>a")
                .find(Condition.text(category))
                .hover()
                .parent()
                .$$("ul>li>a")
                .find(Condition.text(subCategory))
                .click();
        return new ProductsPage();

    }
}
