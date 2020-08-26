package home.page.object.tests;

import home.page.object.BaseFunc;
import home.page.object.pages.ArticlePage;
import home.page.object.pages.CommentPage;
import home.page.object.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class PageObjectTest {
    @Test
    public void pageObjectTest() {
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openPage("delfi.lv");

        HomePage homePage = new HomePage(baseFunc);
        String homePageTitle  = homePage.getTitleById(1);

        int homePageCommentsCount = homePage.getArticleCommentsCount(homePage.getArticleById(1));
        ArticlePage articlePage = homePage.openArticle(1);

        WebElement article = articlePage.getArticle();
        String articleTitle = articlePage.getTitle(article);
        int articleCommentsCount = articlePage.getCommentsCount(article);

        Assertions.assertTrue(homePageTitle.startsWith(articleTitle), "wrong title");
        Assertions.assertEquals(homePageCommentsCount, articleCommentsCount, "wrong comment count");

        CommentPage commentPage = articlePage.openComment(article);
        WebElement commentPageArticle = commentPage.getArticle();
        String commentPageTitle = commentPage.getTitle(commentPageArticle);
        int commentPageCommentsCount = commentPage.getCommentsCount();

        Assertions.assertTrue(commentPageTitle.startsWith(homePageTitle), "wrong title");
        Assertions.assertEquals(homePageCommentsCount, commentPageCommentsCount, "Wrong comment count");
    }
}
