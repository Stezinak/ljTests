package org.tserkovnikov.uitests.pageobject;

import org.openqa.selenium.WebDriver;

import java.util.Collections;
import java.util.Map;

public class TestContext {
    private final WebDriver driver;
    private final String username;// = "tecforceTask";
    private final String password;// = "tecTask12345";
    private final Map<String, String> titleToBody;
    private final String chromeDriverPath;

    TestContext(WebDriver driver, String username, String password, Map<String, String> titleToBody, String chromeDriverPath) {
        this.driver = driver;
        this.username = username;
        this.password = password;
        this.titleToBody = Collections.unmodifiableMap(titleToBody);
        this.chromeDriverPath = chromeDriverPath;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Map<String, String> getTitleToBody() {
        return titleToBody;
    }
}
