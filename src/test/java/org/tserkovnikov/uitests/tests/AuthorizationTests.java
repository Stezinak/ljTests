package org.tserkovnikov.uitests.tests;

import org.junit.Assert;
import org.junit.Test;
import org.tserkovnikov.uitests.pageobject.HomePage;
import org.tserkovnikov.uitests.pageobject.PropertiesCollection;

public class AuthorizationTests extends BaseClass {


    @Test
    public void authorizationPositive() {
        //заходим на страницу, вводим значения, загруженные из json
        HomePage homepage = loginPage.loginToLiveJournal(PropertiesCollection.username, PropertiesCollection.password);
        //проверяем, загрузилась ли домашняя страница
        Assert.assertTrue(homepage.isHomePageLoaded());
    }

    @Test
    public void authorizationNegative() {
        loginPage.loginToLiveJournal(PropertiesCollection.username, "wrongpassword");
        Assert.assertTrue(loginPage.isWrongPasswordLabelExist());
    }

}
