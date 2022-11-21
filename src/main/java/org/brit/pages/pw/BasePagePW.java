package org.brit.pages.pw;

import io.qameta.allure.Step;

public class BasePagePW {

    public MainMenuPW getMainMenu(){
        return new MainMenuPW();
    }

    @Step
    public IPageMenuPW getPageMenu(){
        String whereToRun = System.getProperty("whereToRun", "web");
        return whereToRun.equals("web")? new PageMenuWebPW() : new PageMenuMobileWebPW();
    }
}
