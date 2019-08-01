package controls;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TextField extends Widget {

    public static final Logger logger = LogManager.getLogger(TextField.class);

    public TextField(WebElement element) {
        this.element = element;
    }

    public TextField(By locator) {
        this.locator = locator;
    }

    public void interact(String text) {
        logger.debug(locator.toString());
        this.element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }
}
