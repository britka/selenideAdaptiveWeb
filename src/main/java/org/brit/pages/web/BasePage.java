package org.brit.pages.web;

public class BasePage {
    public MainMenu getMainMenu(){
        return new MainMenu();
    }

    public IPageMenu getPageMenu(){
        String whereToRun = System.getProperty("whereToRun");
        return whereToRun.equals("web")? new PageMenuWeb() : new PageMenuMobileWeb();
    }
}
