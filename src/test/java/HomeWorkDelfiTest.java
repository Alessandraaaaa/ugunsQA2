import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HomeWorkDelfiTest {
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
    public void Test1(){
        List<WebElement> articles = driver.findElements(By.xpath(".//article"));

        for (WebElement element: articles) {
            WebElement zagolovok= element.findElement(By.xpath(".//h1[contains(@class, 'headline__title')]"));

            System.out.print(zagolovok.getText());
            List<WebElement> comments= element.findElements(By.xpath(".//a[contains(@class,'comment-count')]"));
            // != not equal; && proverit toljko pervoe dejstvie i daljwe ne pojdet,esli false  & budet proverjatj daljwe
            if ( comments != null && !comments.isEmpty() ) {
                System.out.println(", Comments: " + comments.get(0).getText());
            }
        }
    }




    @AfterEach
    private void CloseBrowser() {
        driver.quit();
    }
}
