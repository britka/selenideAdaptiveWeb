package org.brit.pages.pw;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.brit.application.Product;
import org.brit.driver.PlayWrightDriver;

import java.util.ArrayList;
import java.util.List;

public class ProductsPagePW extends BasePagePW {

    Page page = PlayWrightDriver.getInstance().getCurrentPage();

    public List<Product> getProductsList() {
        List<Product> list = new ArrayList<>();

        List<ElementHandle> elementHandles = page.locator(".product-item").elementHandles();

        for (ElementHandle elementHandle : elementHandles) {
            String name = elementHandle.querySelector(".product-title").textContent();
            String price = elementHandle.querySelector(".prices .actual-price").textContent();
            Double priceD = Double.parseDouble(price.substring(1).replace(",", ""));
            list.add(new Product(name, priceD));
        }
        return list;
    }


    public ProductsPagePW addProductToCart(String productName) {
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        Locator locator = page.locator(".product-item .product-title a", new Page.LocatorOptions().setHasText(productName))
                .locator("xpath=./../..")
                .locator(".button-2.product-box-add-to-cart-button");
        locator.click();
        page.locator(".bar-notification.success").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        page.locator(".bar-notification.success span").click();
        return this;
    }
}
