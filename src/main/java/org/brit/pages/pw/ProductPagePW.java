package org.brit.pages.pw;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import io.qameta.allure.Step;
import org.brit.driver.PlayWrightDriver;

import java.io.File;

public class ProductPagePW extends BasePagePW {
    Page page = PlayWrightDriver.getInstance().getCurrentPage();

    @Step
    public File downloadSample() {
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        Download download = page.waitForDownload(() -> {
            page.locator(".download-sample-button").click();
        });
        return download.path().toFile();
    }
}
