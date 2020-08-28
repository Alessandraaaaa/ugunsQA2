import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class DelfiTest {
    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.xpath(".//h1[contains  (@class, 'headline__title')]");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class,'d-inline')]");


    private WebDriver driver;
    // driver teperj na urovne klassa. peremennaja

    @BeforeEach
    public void preconditions() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        // otkritj browser okno driver eto peremennaja dlja browser
        driver = new ChromeDriver();
        // raskritj okno na vesj ekran
        driver.manage().window().maximize();
        driver.get("http://rus.delfi.lv");

    }

    @Test
    public void firstDelfiTest() {

        //  vozvrawaet vse zagolovki
        List<WebElement> texts = driver.findElements(By.xpath(".//h1[contains(@class, 'headline__title')]"));
        for (int i = 0; i < texts.size(); i++) {
            System.out.println((i + 1) + ":" + texts.get(i).getText());


        }
    }

    @Test
    public void workingWithLists() {
        //sozdaem pustoj spisok
        List<String> studentNames = new ArrayList<String>();
        //proverjaem pustoj li spisok. true

        System.out.println(studentNames.isEmpty());

        // zapolnjaem spisok
        studentNames.add("Zoja");
        studentNames.add("Petja");
        studentNames.add("Vovan");
        // proverjae pustoj li spisok false

        System.out.println(studentNames.isEmpty());
        System.out.println(studentNames.size());
        System.out.println(studentNames.get(1)); // vidast iz spiska pod nomerom 2


    }

    @Test
    public void titleTest() {
        final String TITLE_TO_FIND = "Северная Корея заявила о возможном первом случае случае заражения Covid-19 ";
        //get all articles
        List<WebElement> articles = driver.findElements(ARTICLE);

        // find given article by text
        boolean isFound = false;
        for (WebElement article : articles) {
            if (article.findElement(TITLE).getText().equals(TITLE_TO_FIND)) {
                article.findElement(TITLE).click();
                isFound = true;
                break;
            }
        }
        Assertions.assertTrue(isFound,"Article is found");

        //find article title
        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();

        //check it
        Assertions.assertEquals(TITLE_TO_FIND, articlePageTitle, "Title are not equal!");
    }


    @AfterEach
    private void CloseBrowser() {
        driver.quit();
    }

}
