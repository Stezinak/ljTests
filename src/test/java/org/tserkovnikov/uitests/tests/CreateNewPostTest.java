package org.tserkovnikov.uitests.tests;

import org.junit.Assert;
import org.junit.Test;
import org.tserkovnikov.uitests.helpers.GenerateData;
import org.tserkovnikov.uitests.pageobject.HomePage;
import org.tserkovnikov.uitests.pageobject.NewPostPage;
import org.tserkovnikov.uitests.pageobject.PostPage;

import java.io.IOException;
import java.util.Map;

public class CreateNewPostTest extends BaseTest {
    @Test
    public void createPostPositive() throws InterruptedException, IOException {
        HomePage homepage = loginPage.loginToLiveJournal(context.getUsername(), context.getPassword());
        NewPostPage newPostPage = homepage.openWriteToBlogPage();
        Map<String, String> titleToBody = context.getTitleToBody();
        String title = GenerateData.getRandomTitle();
        String body = titleToBody.get("title 1");
        newPostPage.writePost(title, body);
        PostPage postPage = newPostPage.savePost();
        Assert.assertTrue(postPage.isAddCommentButtonExist());
        Assert.assertTrue(postPage.doesPageContainsTitle(title));
        Assert.assertTrue(postPage.doesPageContainsBody(body));
    }

    @Test
    public void createPostPositiveNoTitle() throws InterruptedException, IOException {
        HomePage homepage = loginPage.loginToLiveJournal(context.getUsername(), context.getPassword());
        NewPostPage newPostPage = homepage.openWriteToBlogPage();
        Map<String, String> titleToBody = context.getTitleToBody();
        String body = titleToBody.get("title 2");
        newPostPage.writePost("", body);
        PostPage postPage = newPostPage.savePost();
        Assert.assertTrue(postPage.isAddCommentButtonExist());
        Assert.assertTrue(postPage.doesPageContainsBody(body));
    }

    @Test
    public void createPostNegativeNoBody() throws InterruptedException, IOException {
        HomePage homepage = loginPage.loginToLiveJournal(context.getUsername(), context.getPassword());
        NewPostPage newPostPage = homepage.openWriteToBlogPage();
        newPostPage.writePost(GenerateData.getRandomTitle(), "");
        PostPage postPage = newPostPage.savePost();
        Assert.assertFalse(postPage.isAddCommentButtonExist());
    }

    @Test
    public void createPostWithHashtag() throws InterruptedException, IOException {
        String hashtag = "testhashtag";
        HomePage homepage = loginPage.loginToLiveJournal(context.getUsername(), context.getPassword());
        NewPostPage newPostPage = homepage.openWriteToBlogPage();
        Map<String, String> titleToBody = context.getTitleToBody();
        String title = GenerateData.getRandomTitle();
        String body = titleToBody.get("title 1");
        newPostPage.writePost(title, body);
        newPostPage.addHashtag(hashtag);
        PostPage postPage = newPostPage.savePost();
        Assert.assertTrue(postPage.isHashtagExist(hashtag));
        Assert.assertTrue(postPage.isAddCommentButtonExist());
        Assert.assertTrue(postPage.doesPageContainsTitle(title));
        Assert.assertTrue(postPage.doesPageContainsBody(body));
    }
}
