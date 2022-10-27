package org.brit.pages.web;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.brit.application.Product;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class ProductsPage extends BasePage {

    public List<Product> getProductsList() {
        List<Product> list = new ArrayList<>();
        ElementsCollection $$ = $$(".product-item");
        for (SelenideElement element : $$) {
            String name = element.$(".product-title").text();
            String price = element.$(".prices .actual-price").text();
            Double priceD = Double.parseDouble(price.substring(1).replace(",",""));
            list.add(new Product(name, priceD));
        }
        return list;
    }
}
