package home.page.aa.pages;

import home.page.aa.BaseFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LaptopPage {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public LaptopPage(BaseFunc baseFunc){
        LOGGER.info("open page");
        this.baseFunc = baseFunc;
    }
}
