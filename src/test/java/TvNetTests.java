
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TvNetTests {
    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENTS_COUNT = By.xpath(".//span[@itemprop = 'url']");
    private final By ARTICLE_PAGE_TIRLE = By.xpath(".//h1[@itemprop ='headline name']");
    private final By ARTTICLE_PAGE_COMMENTS = By.xpath(".//a[contains(@class, 'item--comments' )]");
    private final By COMMENTS_PAGE_COUNTS = By.xpath(".//span[contains(@class, 'article-comments')]");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());


    @Test
    public void articleTitleCommentsCheck() {
        LOGGER.info("This test is checking titles and comment count");
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        // otkritj browser okno driver eto peremennaja dlja browser
        LOGGER.info("Openning browser");
        WebDriver driver = new ChromeDriver();
        // raskritj okno na vesj ekran
        driver.manage().window().maximize();
        LOGGER.info("Opennig home page");
        driver.get("http://tvnet.lv");

        //find articles
        LOGGER.info("Getting all articles");
        List<WebElement> articles = driver.findElements(ARTICLE);

        // find 3rd article
        LOGGER.info("Get 3rd one");
        WebElement article = articles.get(2);


        //find title
        LOGGER.info("Getting title");
        String homePageTitle = article.findElement(TITLE).getText();

        // find comments count
        int homePageCommentsCount = 0;
        if (!article.findElements(COMMENTS_COUNT).isEmpty()) {
            homePageCommentsCount = parseCommentCount(article.findElement(COMMENTS_COUNT).getText());


        }


        //click on it
        article.findElement(TITLE).click();

        // wait for title
        WebDriverWait   wait  = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ARTICLE_PAGE_TIRLE));


        //find title
        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TIRLE).getText();

        // find comments count
        int articlePageCommentCount = Integer.parseInt(driver.findElement(ARTTICLE_PAGE_COMMENTS).getText());

        //check
        Assertions.assertTrue(homePageTitle.startsWith(articlePageTitle), "wrong title");
        Assertions.assertEquals(homePageCommentsCount, articlePageCommentCount, "wrong comment count");

        // open comments page
        driver.findElement(ARTTICLE_PAGE_COMMENTS).click();
        //wait for title
        wait.until(ExpectedConditions.visibilityOfElementLocated(ARTICLE_PAGE_TIRLE));

        //find title
        String commentsPageTitle = driver.findElement(ARTICLE_PAGE_TIRLE).getText();

        //find comments count
        int commentsPageCommentsCount = Integer.parseInt(driver.findElement(COMMENTS_PAGE_COUNTS).getText());


        //check
        Assertions.assertTrue(homePageTitle.startsWith(homePageTitle), "wrong title");
        Assertions.assertEquals(homePageCommentsCount, commentsPageCommentsCount, "Wrong comment count");


    }

    private int parseCommentCount(String textToParse) {
        //otbrositj skobki substring . pervij parametr vsegda 1 ,a poslednij nadovzjatj dlinnu vsej stroiki i -1 simbol
        textToParse = textToParse.substring(1, textToParse.length() - 1);
        // peredelatj v integer
        return Integer.parseInt(textToParse);

    }
}
