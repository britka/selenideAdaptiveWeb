package org.brit.pages.web;

public interface IPageMenu {
    MainCategoryPage selectMainCategory(String categoryName);

    ProductsPage selectCategoryAndSubCategory(String category, String subCategory);
}
