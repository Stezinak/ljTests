package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pageObject.PropertiesCollection.driver;

public class PostPage {
    public PostPage(){
        PageFactory.initElements(PropertiesCollection.driver, this);
    }

    @FindBy(xpath = "//div[@id='comments']//a[text()='Добавить комментарий']")
    private WebElement addCommentButton;

    public boolean isAddCommentButtonExist(){
        int number = driver.findElements(By.xpath("//div[@id='comments']//a[text()='Добавить комментарий']")).size();
        return (number>0);
    }

    public boolean isHashtagExist(String tagText){
        int number = driver.findElements(By.xpath("//div[@class='aentry-tags']//a[text()='" + tagText + "']")).size();
        return (number>0);
    }
}
