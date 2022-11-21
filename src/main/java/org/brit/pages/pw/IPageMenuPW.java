package org.brit.pages.pw;

import io.qameta.allure.Step;
import org.brit.pages.web.MainCategoryPage;
import org.brit.pages.web.ProductsPage;

public interface IPageMenuPW {
    @Step
    MainCategoryPagePW selectMainCategory(String categoryName);

    @Step
    ProductsPagePW selectCategoryAndSubCategory(String category, String subCategory);
}
