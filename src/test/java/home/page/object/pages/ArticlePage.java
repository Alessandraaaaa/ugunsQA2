package home.page.object.pages;

import home.page.object.BaseFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ArticlePage {
    private final By ARTICLE_PAGE_TITLE_BY = By.xpath(".//h1[contains(@class,'d-inline')]" );
    private static final String ARTICLE_PAGE_COMMENT_TAG = "a";
    private static final String ARTICLE_PAGE_TITLE = "article-title";
    private BaseFunc baseFunc;

    public ArticlePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        baseFunc.waitUntilVisible(ARTICLE_PAGE_TITLE_BY);
    }

    public String getTitle(WebElement article){
        return article.getText();
    }

    public WebElement getArticle() {
        return baseFunc.findElements(By.className(ARTICLE_PAGE_TITLE)).get(0);
    }

    public int getCommentsCount(WebElement article){
        int articlePageCommentCount = 0;
        if (!article.findElements(By.tagName(ARTICLE_PAGE_COMMENT_TAG)).isEmpty()) {
            articlePageCommentCount = parseCommentCount(article.findElement(By.tagName(ARTICLE_PAGE_COMMENT_TAG)).getText());
        }
        return articlePageCommentCount;
    }

    private int parseCommentCount(String textToParse) {
        textToParse = textToParse.substring(1, textToParse.length() - 1);
        return Integer.parseInt(textToParse);
    }

    public CommentPage openComment(WebElement article){
        article.click();
        return new CommentPage(baseFunc);
    }

}
