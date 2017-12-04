package org.tserkovnikov.uitests.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewPostPage {
    private final WebDriver driver;

    NewPostPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='editorWrapper']//div[@class='DraftEditor-root']//div[@class='public-DraftEditor-content']")
    private WebElement postBody;

    @FindBy(xpath = "//textarea[@placeholder='Заголовок']")
    private WebElement postHead;

    @FindBy(xpath = "//span[contains(text(),'Настроить и опубликовать')]")
    private WebElement setupAndPublishButton;

    @FindBy(xpath = "//button[@type='button']//span[contains(text(), 'Опубликовать')]")
    private WebElement publishButton;

    @FindBy(xpath = "//input[@class='_y6 _vx']")
    private WebElement tagInputField;

    public void writePost(String head, String body) {
        postHead.sendKeys(head);
        postBody.sendKeys(body);
    }

    public PostPage savePost() throws InterruptedException {
        setupAndPublishButton.click();
        publishButton.click();
        return new PostPage(driver);
    }

    public void addHashtag(String tag) {
        tagInputField.sendKeys(tag);
    }


}
