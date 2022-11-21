package org.brit.pages.pw;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import io.qameta.allure.Step;
import org.brit.driver.PlayWrightDriver;
import org.brit.pages.web.BasePage;

import static com.codeborne.selenide.Selenide.$;


public class LoginPagePW extends BasePagePW{
    Page page = PlayWrightDriver.getInstance().getCurrentPage();

    @Step
    public BasePagePW login(String name, String password){
        page.fill("#Email", name);
        page.fill("#Password", password);
        page.keyboard().press("Enter");
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        return new BasePagePW();
    }
}
