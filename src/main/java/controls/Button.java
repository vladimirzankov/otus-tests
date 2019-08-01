package controls;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class Button extends Widget {

    public static final Logger logger = LogManager.getLogger(Button.class);

    public Button(WebElement element) {
        this.element = element;
    }

    public Button(By locator) {
        this.locator = locator;
    }

    public void interact() {
        logger.debug(locator.toString());
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(locator));
        element = driver.findElement(locator);
        element.click();
        /*int i = 0;
        while(true) {
            try {
                element.click();
                break;
            }
            catch(ElementClickInterceptedException e) {
                if(i < 10) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    continue;
                }
                else {
                    throw e;
                }
            }
        }*/
    }

    public String getText() {
        element = driver.findElement(locator);
        return element.getText();
    }

    public <V> void interactAndWait(Function<? super WebDriver, V> function) {
        interact();
        new WebDriverWait(driver, 10).until(function);

    }
}
