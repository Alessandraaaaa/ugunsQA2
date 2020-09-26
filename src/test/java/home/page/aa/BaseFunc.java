package home.page.aa;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseFunc {
    private WebDriver driver;
    private WebDriverWait wait;
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    public BaseFunc(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\atoro\\Downloads\\chromedriver_win32\\chromedriver.exe");
        // otkritj browser okno driver eto peremennaja dlja browser

        driver = new ChromeDriver();
        // raskritj okno na vesj ekran
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    public void openPage(String  url) {
        LOGGER.info("Trying to open page: " + url);

        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://"+ url;
        }

       driver.get(url);
    }
    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }
    public void click(WebElement element){
//        waitUntilClickable(element);
        element.click();
    }

    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilVisible(By element) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public Actions getNewAction(){
        return new Actions(driver);
    }
}
