package home.page.object.pages;

import home.page.object.BaseFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CommentPage {
    private final By PAGE_TITLE_BY = By.xpath(".//h1[contains(@class,'article-title')]" );
    private final By COMMENTS_COUNT_BY = By.xpath(".//span[contains(@class,'type-cnt')]" );

    private BaseFunc baseFunc;

    public CommentPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        baseFunc.waitUntilVisible(PAGE_TITLE_BY);
    }

    public WebElement getArticle() {
        return baseFunc.findElements(PAGE_TITLE_BY).get(0);
    }

    public String getTitle(WebElement article){
        return article.getText();
    }

    public int getCommentsCount(){
        int articlePageCommentCount = 0;
        if (baseFunc.findElements(COMMENTS_COUNT_BY).size() > 0) {
            articlePageCommentCount = parseCommentCount(baseFunc.findElements(COMMENTS_COUNT_BY).get(0).getText());
        }
        return articlePageCommentCount;
    }

    private int parseCommentCount(String textToParse) {
        textToParse = textToParse.substring(1, textToParse.length() - 1);
        return Integer.parseInt(textToParse);
    }
}
