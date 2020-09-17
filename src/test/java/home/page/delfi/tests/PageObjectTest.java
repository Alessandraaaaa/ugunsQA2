package home.page.delfi.tests;

import home.page.delfi.BaseFunc;
import home.page.delfi.pages.ArticlePage;
import home.page.delfi.pages.CommentPage;
import home.page.delfi.pages.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class PageObjectTest {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    @Test
    public void pageObjectTest() {
        LOGGER.info("This test will check article title on Home, Article and Comment pages");
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openPage("http://rus.delfi.lv");

        HomePage homePage = new HomePage(baseFunc);
        String homePageTitle  = homePage.getTitleById(1);

        int homePageCommentsCount = homePage.getArticleCommentsCount(homePage.getArticleById(1));
        ArticlePage articlePage = homePage.openArticle(1);

        WebElement article = articlePage.getArticle();
        String articleTitle = articlePage.getTitle(article);
        int articleCommentsCount = articlePage.getCommentsCount(article);

        Assertions.assertTrue(articleTitle.startsWith(homePageTitle), "wrong title");
        Assertions.assertEquals(homePageCommentsCount, articleCommentsCount, "wrong comment count");

        CommentPage commentPage = articlePage.openComment(article);
        WebElement commentPageArticle = commentPage.getArticle();
        String commentPageTitle = commentPage.getTitle(commentPageArticle);
        int commentPageCommentsCount = commentPage.getCommentsCount();

        Assertions.assertTrue(commentPageTitle.startsWith(homePageTitle), "wrong title");
        Assertions.assertEquals(homePageCommentsCount, commentPageCommentsCount, "Wrong comment count");
    }
}
