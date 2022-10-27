package org.brit.pages.pw;

import com.codeborne.selenide.Condition;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.brit.driver.PlayWrightDriver;
import org.brit.pages.web.MainCategoryPage;
import org.brit.pages.web.ProductsPage;

import static com.codeborne.selenide.Selenide.$$;

public class MainCategoryPagePW extends BasePagePW {
    Page page = PlayWrightDriver.getInstance().getCurrentPage();

    public ProductsPagePW selectSubCategory(String name) {
        page
                .locator(".sub-category-item>h2>a")
                .filter(new Locator.FilterOptions().setHasText(name))
                .click();
        return new ProductsPagePW();
    }
}
