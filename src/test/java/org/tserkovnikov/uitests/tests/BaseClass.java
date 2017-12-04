package org.tserkovnikov.uitests.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.tserkovnikov.uitests.pageobject.LoginPage;
import org.tserkovnikov.uitests.pageobject.PropertiesCollection;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.tserkovnikov.uitests.pageobject.PropertiesCollection.driver;

// конечно, базовый класс должен быть в другом месте, а тесты разделены по категориям, но их очень мало, чтобы разделить по какому-то признаку
public class BaseClass {

    public static LoginPage loginPage;

    // инициализируем работу - прописываем путь к chromedriver, выставляем таймер неявного ожидания объектов и загрузки страницы, разворачиваем браузер на весь экран
    // забираем данные для авторизации из json файла, открываем страницу lj
    @Before
    public void setup() throws IOException {
        System.setProperty("webdriver.chrome.driver", "libs/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        PropertiesCollection.parseJsonDataLoginPassword();
        loginPage = new LoginPage(driver, "https://www.livejournal.com"); // мы заходим на эту страницу в каждом тесте, поэтому я вынес это действие сюда (помогает избежать дублирования)
    }

    @After
    public void tearDown(){
        driver.quit();
    }


}
