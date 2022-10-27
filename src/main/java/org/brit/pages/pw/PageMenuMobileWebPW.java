package org.brit.pages.pw;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.brit.driver.PlayWrightDriver;

public class PageMenuMobileWebPW implements IPageMenuPW {
    Page page = PlayWrightDriver.getInstance().getCurrentPage();

    @Override
    public MainCategoryPagePW selectMainCategory(String categoryName) {
        page.click(".menu-toggle");
        page.locator(".top-menu.mobile>li>a", new Page.LocatorOptions().setHasText(categoryName))
                .click();
        return new MainCategoryPagePW();
    }

    @Override
    public ProductsPagePW selectCategoryAndSubCategory(String category, String subCategory) {
        page.click(".menu-toggle");
        Locator parent = page.locator(".top-menu.mobile>li>a", new Page.LocatorOptions().setHasText(category))
                .locator("xpath=./..");
        parent
                .locator(".sublist-toggle")
                .click();
        parent.locator("ul>li>a", new Locator.LocatorOptions().setHasText(subCategory))
                .click();
        return new ProductsPagePW();
    }
}
