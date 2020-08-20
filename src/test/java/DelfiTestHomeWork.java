import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DelfiTestHomeWork {
    public static final String ARTICLE_PAGE_TITLE = "article-title";
    public static final String ARTICLE_PAGE_COMMENT_TAG = "a";
    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.xpath(".//h1[contains  (@class, 'headline__title')]");
    private final By COMMENTS_COUNT = By.xpath(".//a[contains(@class, 'comment-count' )]");
    private final By ARTICLE_PAGE_TIRLE = By.xpath(".//h1[contains(@class,'d-inline')]" );
    private final By ARTTICLE_PAGE_COMMENTS = By.xpath(".//a[contains(@class, d-print-none)]");
    private final By COMMENTS_PAGE_COUNTS = By.xpath(".//span[contains (@class, type-cnt)]");
    private final By ARTICLE_PAGE_DIV = By.xpath(".//div[contains (@class, article-title)]");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    @Test
    public void articleTitleCommentsCheck() {
        LOGGER.info("This test is checking titles and comment count");
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        LOGGER.info("Openning browser");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        LOGGER.info("Opennig home page");
        driver.get("http://rus.delfi.lv");
        LOGGER.info("Getting all articles");
        List<WebElement> articles = driver.findElements(ARTICLE);
        LOGGER.info("Get second ");
        WebElement article = articles.get(1);
        LOGGER.info("Getting title");
        String homePageTitle = article.findElement(TITLE).getText();

        int homePageCommentsCount = 0;
        if (!article.findElements(COMMENTS_COUNT).isEmpty()) {
            homePageCommentsCount = parseCommentCount(article.findElement(COMMENTS_COUNT).getText());
        }

        article.findElement(TITLE).click();

        WebDriverWait   wait  = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ARTICLE_PAGE_TIRLE));

        WebElement articlePageElement = driver.findElement(By.className(ARTICLE_PAGE_TITLE));
        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TIRLE).getText();

        int articlePageCommentCount = 0;
        if (!articlePageElement.findElements(By.tagName(ARTICLE_PAGE_COMMENT_TAG)).isEmpty()) {
            articlePageCommentCount = parseCommentCount(articlePageElement.findElement(By.tagName(ARTICLE_PAGE_COMMENT_TAG)).getText());
        }

        Assertions.assertTrue(homePageTitle.startsWith(articlePageTitle), "wrong title");
        Assertions.assertEquals(homePageCommentsCount, articlePageCommentCount, "wrong comment count");

        articlePageElement.findElement(ARTTICLE_PAGE_COMMENTS).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(ARTICLE_PAGE_TIRLE));

        String commentsPageTitle = driver.findElement(ARTICLE_PAGE_TIRLE).getText();

        int commentsPageCommentsCount = Integer.parseInt(driver.findElement(COMMENTS_PAGE_COUNTS).getText());

        Assertions.assertTrue(homePageTitle.startsWith(homePageTitle), "wrong title");
        Assertions.assertEquals(homePageCommentsCount, commentsPageCommentsCount, "Wrong comment count");
    }

    private int parseCommentCount(String textToParse) {
        textToParse = textToParse.substring(1, textToParse.length() - 1);
        return Integer.parseInt(textToParse);

    }

}
