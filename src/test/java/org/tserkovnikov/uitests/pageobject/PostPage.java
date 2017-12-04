package org.tserkovnikov.uitests.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PostPage {
    private final WebDriver driver;

    PostPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isAddCommentButtonExist() {
        By xpath = By.xpath("//div[@id='comments']//a[text()='Добавить комментарий']");
        List<WebElement> elements = driver.findElements(xpath);
        return !elements.isEmpty();
    }

    public boolean isHashtagExist(String tagText) {
        By xpath = By.xpath("//div[@class='aentry-tags']//a[text()='" + tagText + "']");
        List<WebElement> elements = driver.findElements(xpath);
        return !elements.isEmpty();
    }
}
