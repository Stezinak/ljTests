package org.tserkovnikov.uitests.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.tserkovnikov.uitests.helpers.TestConstants;
import org.tserkovnikov.uitests.pageobject.LoginPage;
import org.tserkovnikov.uitests.pageobject.TestContext;
import org.tserkovnikov.uitests.pageobject.TestContextFactory;

import java.io.IOException;

// конечно, базовый класс должен быть в другом месте, а тесты разделены по категориям, но их очень мало, чтобы разделить по какому-то признаку
public class BaseTest {

    LoginPage loginPage;
    TestContext context;

    // забираем данные для авторизации из json файла, открываем страницу lj
    @Before
    public void setup() throws IOException {
        TestContextFactory factory = new TestContextFactory();
        this.context = factory.create();
        // мы заходим на эту страницу в каждом тесте, поэтому я вынес это действие сюда (помогает избежать дублирования)
        this.loginPage = new LoginPage(context.getDriver(), TestConstants.URL);
    }

    @After
    public void tearDown() {
        WebDriver driver = context.getDriver();
        driver.quit();
    }


}
