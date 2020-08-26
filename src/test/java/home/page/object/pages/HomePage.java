package home.page.object.pages;

import home.page.object.BaseFunc;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.xpath(".//h1[contains  (@class, 'headline__title')]");
    private final By COMMENTS_COUNT = By.xpath(".//a[contains(@class, 'comment-count' )]");
    private static final By ARTICLE_PAGE_COMMENT_TAG = By.tagName("a");

    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc){
        this.baseFunc = baseFunc;

    }
    public String getTitleById(int id){

        return getArticleById(id).findElement(TITLE).getText();

    }
    public ArticlePage openArticle(int id){
        baseFunc.click(getArticleById(id).findElement(TITLE));
   //     getArticleById(id).click();
        return new ArticlePage(baseFunc);
    }

    public WebElement getArticleById(int id){
        List<WebElement> articles = baseFunc.findElements(ARTICLE);
        Assertions.assertFalse(articles.isEmpty(), "There is no articles");
        return articles.get(id);
    }

    public int getArticleCommentsCount(WebElement article){
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
