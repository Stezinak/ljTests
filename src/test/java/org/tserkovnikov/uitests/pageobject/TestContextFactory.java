package org.tserkovnikov.uitests.pageobject;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.tserkovnikov.uitests.helpers.TestConstants;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// инициализируем работу - прописываем путь к chromedriver, выставляем таймер неявного ожидания объектов
// и загрузки страницы, разворачиваем браузер на весь экран
public class TestContextFactory {
    public TestContext create() {
        Map<String, String> authData = getAuthData();
        String username = authData.get("username");
        String password = authData.get("password");
        Map<String, String> titleToBody = getTitleToBody();
        WebDriver driver = setupWebdriver();
        String chromedriverPath = getChromeDriverPath();
        return new TestContext(driver, username, password, titleToBody, chromedriverPath);
    }

    private Map<String, String> getTitleToBody() {
        Map<String, String> titleToBody;
        try {
            titleToBody = new ObjectMapper().readValue(new File(TestConstants.POSTSPATH), new TypeReference<Map<String, String>>() {
            });
        } catch (IOException e) {
            throw new IllegalStateException("Не удалось настроить тест", e);
        }
        return titleToBody;
    }

    private Map<String, String> getAuthData() {
        Map<String, String> authData;
        try {
            authData = new ObjectMapper().readValue(new File(TestConstants.AUTH_PATH), new TypeReference<Map<String, String>>() {
            });
        } catch (IOException e) {
            throw new IllegalStateException("Не удалось настроить тест", e);
        }
        return authData;
    }

    private WebDriver setupWebdriver() {
        System.setProperty(TestConstants.REGISTRYVALUE, getChromeDriverPath());
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    private String getChromeDriverPath() {
        String osVersion = System.getProperty("os.name").toLowerCase();
        if (osVersion.contains("win")) return "libs/chromedriver.exe";
        if (osVersion.contains("nix")) return "libs/chromedriver_unix";
        return null;
    }
}
