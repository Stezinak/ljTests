package org.tserkovnikov.uitests.pageobject;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// инициализируем работу - прописываем путь к chromedriver, выставляем таймер неявного ожидания объектов
// и загрузки страницы, разворачиваем браузер на весь экран
public class TestContextFactory {
    public TestContext create() {
        String authPath = "src/test/resources/auth.json";
        JSONParser parser = new JSONParser();
        String username;
        String password;
        try {
            Object obj = parser.parse(new FileReader(authPath));
            JSONObject jsonObject = (JSONObject) obj;
            username = (String) jsonObject.get("username");
            password = (String) jsonObject.get("password");
        } catch (IOException | ParseException e) {
            throw new IllegalStateException("Не удалось настроить тест", e);
        }

        String postsPath = "src/test/resources/posts.json";
        Map<String, String> titleToBody;
        try {
            titleToBody = new ObjectMapper().readValue(new File(postsPath), new TypeReference<Map<String, String>>() {
            });
        } catch (IOException e) {
            throw new IllegalStateException("Не удалось настроить тест", e);
        }

        System.setProperty("webdriver.chrome.driver", "libs/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return new TestContext(driver, username, password, titleToBody);
    }
}
