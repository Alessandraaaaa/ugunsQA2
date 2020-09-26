package home.page.aa.pages;

import home.page.aa.BaseFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePageA {
    public static final int LAPTOP_SUBLIST_INDEX = 1;
    private final By LAPTOP_NAV_LVL1_ITEM = By.xpath(".//a[contains  (@class, 'submenu-lvl1__link')]");
    private final By LAPTOP_NAV_LVL2_ITEM = By.xpath(".//a[contains  (@class, 'submenu-lvl2__list-item-link')]");


    private final By TITLE = By.xpath(".//h1[contains  (@class, 'headline__title')]");
    private final By COMMENTS_COUNT = By.xpath(".//a[contains(@class, 'comment-count' )]");
    private static final By ARTICLE_PAGE_COMMENT_TAG = By.tagName("a");
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private BaseFunc baseFunc;

    public HomePageA(BaseFunc baseFunc){
        LOGGER.info("open page");
        this.baseFunc = baseFunc;
    }

    public ComputerPage getComputerPage() {
        baseFunc.click(baseFunc.findElements(LAPTOP_NAV_LVL1_ITEM).get(LAPTOP_SUBLIST_INDEX));
        return new ComputerPage(baseFunc);
    }

//    public LaptopPage openLaptopPage(Actions moveToLaptopSubItemAction) {
//        moveToLaptopSubItemAction.click().build().perform();
//        return new LaptopPage(baseFunc);
//    }
//
//    private WebElement getLaptopListItem(){
//        return baseFunc.findElements(LAPTOP_NAV_LVL1_ITEM).get(LAPTOP_SUBLIST_INDEX);
//    }
//
//    private WebElement getLaptopSubListItem(WebElement element){
//        return element.findElements(LAPTOP_NAV_LVL2_ITEM).get(LAPTOP_SUBLIST_INDEX);
//    }
}
