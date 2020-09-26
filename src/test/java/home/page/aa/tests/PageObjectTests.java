package home.page.aa.tests;


import home.page.aa.BaseFunc;

import home.page.aa.pages.ComputerPage;
import home.page.aa.pages.HomePageA;
import home.page.aa.pages.LaptopPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class PageObjectTests {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Test
    public void pageObjectTest() {
        LOGGER.info("This test will check article title on Home, Article and Comment pages");

        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openPage("1a.lv");

        HomePageA homePage = new HomePageA(baseFunc);
        ComputerPage laptopPage = homePage.getComputerPage();

    }
}
