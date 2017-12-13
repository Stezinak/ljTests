package org.tserkovnikov.uitests.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver, String url) {
        this.driver = driver;
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

    public HomePage loginToLiveJournal(String user, String password) {
        loginButton.click();
        usernameInput.sendKeys(user);
        passwordInput.click();
        passwordInput.sendKeys(password);
        logInButton.click();
        return new HomePage(driver);
    }

    public boolean isWrongPasswordLabelExist() {
        By xpath = By.xpath("//span[@class='b-loginform-field__errorMsg ng-binding']");
        List<WebElement> elements = driver.findElements(xpath);
        return !elements.isEmpty();
    }

    public void checkLanguageAndSetToRussian(){
        By mainButtonXpath = By.xpath("//a[text()='Main']");
        List<WebElement> elements = driver.findElements(mainButtonXpath);

        if (!elements.isEmpty()) {
            // меняем язык lj на русский
            Actions action = new Actions(driver);
            By englishMenuXpath = By.xpath("//a[@href='https://www.livejournal.com/manage/settings/?cat=display']");
            WebElement englishMenu = driver.findElement(englishMenuXpath );
            action.moveToElement(englishMenu);
            mainButtonXpath = By.xpath("//a[text()='Русский (ru)']");
            WebElement russianOption = driver.findElement(mainButtonXpath);
            action.click(russianOption);
            action.perform();
        }
        //
    }
}
