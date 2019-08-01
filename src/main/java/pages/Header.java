package pages;

import controls.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Header extends Page {

    Button authButton = new Button(By.cssSelector("button[data-modal-id=new-log-reg]"));
    By avatar = By.cssSelector("div.header2-menu div[class*=avatar]");
    Button profileButton = new Button(By.cssSelector(".header2-menu__dropdown-text_name"));

    public void openAuthPage() {
        authButton.interact();
    }

    public void openProfile() {
        new Actions(driver).moveToElement(driver.findElement(avatar)).perform();
        profileButton.interact();
    }
}
