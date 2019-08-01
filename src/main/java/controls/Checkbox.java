package controls;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.PersonalInfoPage;

public class Checkbox extends Widget {

    public static final Logger logger = LogManager.getLogger(Checkbox.class);

    public Checkbox(WebElement element) {
        this.element = element;
    }

    public Checkbox(By locator) {
        this.locator = locator;
    }

    public void interact(boolean needToBeSelected) {
        logger.debug(locator.toString());
        this.element = driver.findElement(locator);
        boolean isSelected = isSelected();
        if(isSelected ^ needToBeSelected) element.click();
    }

    public boolean isSelected() {
        this.element = driver.findElement(locator);
        WebElement invisibleInput = (WebElement)((JavascriptExecutor)driver).executeScript("return arguments[0].previousElementSibling", element);
        return invisibleInput.getAttribute("checked") == null ? false : true;

    }
}
