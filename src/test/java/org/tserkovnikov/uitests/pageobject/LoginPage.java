package org.tserkovnikov.uitests.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.tserkovnikov.uitests.pageobject.PropertiesCollection.driver;

public class LoginPage {

    public LoginPage(WebDriver driver, String url){
        driver.get(url);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//nav[@role='presentation']//a[@href='https://www.livejournal.com/login.bml']")
    private WebElement loginButton;

    @FindBy(id = "user")
    private WebElement usernameInput;

    @FindBy(id = "lj_loginwidget_password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@ng-click='loginForm.loginUser($event)']")
    private WebElement logInButton;

    public HomePage LoginToLiveJournal(String user, String password){
        loginButton.click();
        usernameInput.sendKeys(user);
        passwordInput.sendKeys(password);
        logInButton.click();
        return new HomePage();
    }

    public boolean isWrongPasswordLabelExist(){
        int number = driver.findElements(By.xpath("//span[@class='b-loginform-field__errorMsg ng-binding']")).size();
        return (number>0);
    }

}
