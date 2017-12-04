package org.tserkovnikov.uitests.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.tserkovnikov.uitests.pageobject.PropertiesCollection.driver;

public class PostPage {
    public PostPage() {
        PageFactory.initElements(PropertiesCollection.driver, this);
    }

    @FindBy(xpath = "//div[@id='comments']//a[text()='Добавить комментарий']")
    private WebElement addCommentButton;

    public boolean isAddCommentButtonExist() {
        By xpath = By.xpath("//div[@id='comments']//a[text()='Добавить комментарий']");
        List<WebElement> elements = driver.findElements(xpath);
        int number = elements.size();
        return (number > 0);
    }

    public boolean isHashtagExist(String tagText) {
        By xpath = By.xpath("//div[@class='aentry-tags']//a[text()='" + tagText + "']");
        List<WebElement> elements = driver.findElements(xpath);
        int number = elements.size();
        return (number > 0);
    }
}
