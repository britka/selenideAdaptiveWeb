package org.brit.pages.pw;

import com.codeborne.selenide.Condition;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.brit.driver.PlayWrightDriver;
import org.brit.pages.web.MainCategoryPage;
import org.brit.pages.web.ProductsPage;

import static com.codeborne.selenide.Selenide.$$;

public class PageMenuWebPW implements IPageMenuPW {
    Page page = PlayWrightDriver.getInstance().getCurrentPage();


    @Override
    public MainCategoryPagePW selectMainCategory(String categoryName) {
        page.locator(".notmobile.top-menu>li>a", new Page.LocatorOptions().setHasText(categoryName))
                .click();
        return new MainCategoryPagePW();
    }

    @Override
    public ProductsPagePW selectCategoryAndSubCategory(String category, String subCategory) {
        Locator filter = page
                .locator(".notmobile.top-menu>li>a", new Page.LocatorOptions().setHasText(category)).first();
        filter.hover();
        filter
                .locator("xpath=./..")
                .locator("ul>li>a", new Locator.LocatorOptions().setHasText(subCategory))
                .click();
        return new ProductsPagePW();

    }
}
