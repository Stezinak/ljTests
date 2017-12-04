package tests;

import org.junit.Assert;
import org.junit.Test;
import pageObject.HomePage;
import pageObject.PropertiesCollection;

public class AuthorizationTests extends BaseClass {


    @Test
    public void authorizationPositive(){
        //заходим на страницу, вводим значения, загруженные из json
        HomePage homepage = loginPage.LoginToLiveJournal(PropertiesCollection.username, PropertiesCollection.password);
        //проверяем, загрузилась ли домашняя страница
        Assert.assertTrue(homepage.isHomePageLoaded());
    }

    @Test
    public void authorizationNegative(){
        loginPage.LoginToLiveJournal(PropertiesCollection.username, "wrongpassword");
        Assert.assertTrue(loginPage.isWrongPasswordLabelExist());
    }

}
