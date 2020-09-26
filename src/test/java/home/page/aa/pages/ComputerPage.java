package home.page.aa.pages;

import home.page.aa.BaseFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ComputerPage {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public ComputerPage(BaseFunc baseFunc){
        LOGGER.info("open page");
        this.baseFunc = baseFunc;
    }
}
