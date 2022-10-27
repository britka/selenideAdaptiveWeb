package org.brit.pages.pw;

import org.brit.pages.web.MainCategoryPage;
import org.brit.pages.web.ProductsPage;

public interface IPageMenuPW {
    MainCategoryPagePW selectMainCategory(String categoryName);

    ProductsPagePW selectCategoryAndSubCategory(String category, String subCategory);
}
