package controls;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Radiobutton extends Widget {

    public static final Logger logger = LogManager.getLogger(Button.class);

    public Radiobutton(WebElement element) {
        this.element = element;
    }

    public Radiobutton(By locator) {
        this.locator = locator;
    }

    public void interact() {
        logger.debug(locator.toString());
        this.element = driver.findElement(locator);
        element.click();
    }

    public boolean isSelected() {
        this.element = driver.findElement(locator);
        WebElement invisibleInput = (WebElement)((JavascriptExecutor)driver).executeScript("return arguments[0].previousElementSibling", element);
        return invisibleInput.getAttribute("checked") == null ? false : true;
    }
}
