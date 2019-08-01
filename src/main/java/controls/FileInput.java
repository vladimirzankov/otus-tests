package controls;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;

public class FileInput extends Widget {

    public static final Logger logger = LogManager.getLogger(FileInput.class);

    public FileInput(WebElement element) {
        this.element = element;
    }

    public FileInput(By locator) {
        this.locator = locator;
    }

    public void interact(String path) {
        logger.debug(locator.toString());
        this.element = driver.findElement(locator);
        File file = new File(path);
        element.sendKeys(file.getAbsolutePath());
    }
}
