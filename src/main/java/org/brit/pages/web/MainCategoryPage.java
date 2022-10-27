package org.brit.pages.web;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$$;

public class MainCategoryPage extends BasePage{
    public ProductsPage selectSubCategory(String name){
        $$(".sub-category-item>h2>a")
                .find(Condition.text(name))
                .click();
        return new ProductsPage();
    }
}
