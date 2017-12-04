package org.tserkovnikov.uitests.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(PropertiesCollection.driver, this);
    }

    @FindBy(xpath = "//nav[@role='presentation']//ul[@class='s-do']//span[contains(text(),'Написать в блог')]")
    private WebElement writeToBlogButton;

    public NewPostPage openWriteToBlogPage() {
        writeToBlogButton.click();
        return new NewPostPage();
    }

    // простой способ проверить, загрузилась ли страница.
    // Если мы успешно авторизовались, то должна появиться эта кнопка.
    public boolean isHomePageLoaded()
    {
        return writeToBlogButton.isDisplayed();
    }

}