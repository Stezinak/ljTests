package org.tserkovnikov.uitests.tests;

import org.junit.Assert;
import org.junit.Test;
import org.tserkovnikov.uitests.pageobject.HomePage;

public class AuthorizationTest extends BaseTest {

    @Test
    public void authorizationPositive() {
        //заходим на страницу, вводим значения, загруженные из json
        HomePage homepage = loginPage.loginToLiveJournal(context.getUsername(), context.getPassword());
        //проверяем, загрузилась ли домашняя страница
        Assert.assertTrue(homepage.isHomePageLoaded());
    }

    @Test
    public void authorizationNegative() {
        loginPage.loginToLiveJournal(context.getUsername(), "wrongpassword");
        Assert.assertTrue(loginPage.isWrongPasswordLabelExist());
    }
}
