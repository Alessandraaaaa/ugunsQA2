package home.page.delfi.pages;

import home.page.delfi.BaseFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.xpath(".//h1[contains  (@class, 'headline__title')]");
    private final By COMMENTS_COUNT = By.xpath(".//a[contains(@class, 'comment-count' )]");
    private static final By ARTICLE_PAGE_COMMENT_TAG = By.tagName("a");
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc){
        LOGGER.info("open page");

        this.baseFunc = baseFunc;

    }
    public String getTitleById(int id){
        LOGGER.info("get title");

        return getArticleById(id).findElement(TITLE).getText();

    }
    public ArticlePage openArticle(int id){
        LOGGER.info("open article");
        baseFunc.click(getArticleById(id).findElement(TITLE));
        return new ArticlePage(baseFunc);
    }

    public WebElement getArticleById(int id){
        LOGGER.info("find article element");
        List<WebElement> articles = baseFunc.findElements(ARTICLE);
        Assertions.assertFalse(articles.isEmpty(), "There is no articles");
        return articles.get(id);
    }

    public int getArticleCommentsCount(WebElement article){
        LOGGER.info("getting number of comments");
        int articlePageCommentCount = 0;
        if (!article.findElements(COMMENTS_COUNT).isEmpty()) {
            articlePageCommentCount = parseCommentCount(article.findElement(COMMENTS_COUNT).getText());
        }
        return articlePageCommentCount;
    }

    private int parseCommentCount(String textToParse) {
        textToParse = textToParse.substring(1, textToParse.length() - 1);
        return Integer.parseInt(textToParse);
    }

}
