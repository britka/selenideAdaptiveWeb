package org.brit.pages.pw;

public class BasePagePW {

    public MainMenuPW getMainMenu(){
        return new MainMenuPW();
    }

    public IPageMenuPW getPageMenu(){
        String whereToRun = System.getProperty("whereToRun", "web");
        return whereToRun.equals("web")? new PageMenuWebPW() : new PageMenuMobileWebPW();
    }
}
