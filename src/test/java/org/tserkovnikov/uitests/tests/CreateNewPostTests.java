package org.tserkovnikov.uitests.tests;

import org.tserkovnikov.uitests.helpers.GenerateData;
import org.junit.Assert;
import org.junit.Test;
import org.tserkovnikov.uitests.pageobject.HomePage;
import org.tserkovnikov.uitests.pageobject.NewPostPage;
import org.tserkovnikov.uitests.pageobject.PostPage;
import org.tserkovnikov.uitests.pageobject.PropertiesCollection;

import java.io.IOException;

public class CreateNewPostTests extends BaseClass{
    @Test
    public void createPostPositive() throws InterruptedException, IOException {
        // получаем данные для авторизации
        PropertiesCollection.parsePosts();

        HomePage homepage = loginPage.LoginToLiveJournal(PropertiesCollection.username, PropertiesCollection.password);
        NewPostPage newPostPage = homepage.openWriteToBlogPage();
        newPostPage.writePost(GenerateData.getRandomTitle(), PropertiesCollection.result.get("title 1"));
        PostPage postPage = newPostPage.savePost();
        Assert.assertTrue(postPage.isAddCommentButtonExist());
    }

    @Test
    public void createPostPositiveNoTitle() throws InterruptedException, IOException {
        PropertiesCollection.parsePosts();

        HomePage homepage = loginPage.LoginToLiveJournal(PropertiesCollection.username, PropertiesCollection.password);
        NewPostPage newPostPage = homepage.openWriteToBlogPage();
        newPostPage.writePost("", PropertiesCollection.result.get("title 2"));
        PostPage postPage = newPostPage.savePost();
        Assert.assertTrue(postPage.isAddCommentButtonExist());
    }

    @Test
    public void createPostNegativeNoBody() throws InterruptedException, IOException {
        PropertiesCollection.parsePosts();

        HomePage homepage = loginPage.LoginToLiveJournal(PropertiesCollection.username, PropertiesCollection.password);
        NewPostPage newPostPage = homepage.openWriteToBlogPage();
        newPostPage.writePost(GenerateData.getRandomTitle(), "");
        PostPage postPage = newPostPage.savePost();
        Assert.assertFalse(postPage.isAddCommentButtonExist());
    }

    @Test
    public void createPostWithHashtag() throws InterruptedException, IOException {
        String hashtag = "testHashTag";
        PropertiesCollection.parsePosts();

        HomePage homepage = loginPage.LoginToLiveJournal(PropertiesCollection.username, PropertiesCollection.password);
        NewPostPage newPostPage = homepage.openWriteToBlogPage();
        newPostPage.writePost(GenerateData.getRandomTitle(), PropertiesCollection.result.get("title 1"));
        newPostPage.addHashtag(hashtag);
        PostPage postPage = newPostPage.savePost();
        postPage.isHashtagExist(hashtag);
        Assert.assertTrue(postPage.isAddCommentButtonExist());
    }

        
}
