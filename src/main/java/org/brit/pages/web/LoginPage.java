package org.brit.pages.web;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage{
    public BasePage login(String name, String password){
        $("#Email").setValue(name);
        $("#Password").setValue(password).pressEnter();
        return new BasePage();
    }
}
