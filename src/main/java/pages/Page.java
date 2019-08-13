package pages;

import config.DriverBase;
import org.openqa.selenium.WebDriver;

public class Page {

    WebDriver driver;

    public Page() {
        this.driver = DriverBase.getDriver();
    }
}
