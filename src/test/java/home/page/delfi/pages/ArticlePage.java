package home.page.delfi.pages;

import home.page.delfi.BaseFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArticlePage {
    private final By ARTICLE_PAGE_TITLE_BY = By.xpath(".//h1[contains(@class,'d-inline')]" );
    private static final String ARTICLE_PAGE_COMMENT_TAG = "a";
    private static final String ARTICLE_PAGE_TITLE = "article-title";
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public ArticlePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        baseFunc.waitUntilVisible(ARTICLE_PAGE_TITLE_BY);
        LOGGER.info("Waiting for article page loading");

    }

    public String getTitle(WebElement article){
        LOGGER.info("Getting article title");

        return article.getText();
    }

    public WebElement getArticle() {
        LOGGER.info("Getting article element");

        return baseFunc.findElements(By.className(ARTICLE_PAGE_TITLE)).get(0);
    }

    public int getCommentsCount(WebElement article){
        LOGGER.info("Getting number of comments");
        int articlePageCommentCount = 0;
        if (!article.findElements(By.tagName(ARTICLE_PAGE_COMMENT_TAG)).isEmpty()) {
            articlePageCommentCount = parseCommentCount(article.findElement(By.tagName(ARTICLE_PAGE_COMMENT_TAG)).getText());
        }
        return articlePageCommentCount;
    }

    private int parseCommentCount(String textToParse) {
        LOGGER.info("Remove brackets from comments");

        textToParse = textToParse.substring(1, textToParse.length() - 1);
        return Integer.parseInt(textToParse);
    }

    public CommentPage openComment(WebElement article){
        LOGGER.info("Try to open comments page");
        baseFunc.click(article.findElement(By.tagName(ARTICLE_PAGE_COMMENT_TAG)));
        return new CommentPage(baseFunc);
    }

}
