package controls;

import config.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Widget {

    WebDriver driver;
    By locator;
    WebElement element;

    Widget() {
        this.driver = DriverBase.getDriver();
    }

    public String getAttribute(String name) {
        this.element = driver.findElement(locator);
        return element.getAttribute(name);
    }

    public By getLocator() {
        return locator;
    }
}
