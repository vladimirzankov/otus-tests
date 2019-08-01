package pages;

import controls.Button;
import controls.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import static config.DriverBase.getDriver;

public class LoginPage extends Page {

    TextField emailField = new TextField(By.cssSelector("form.new-log-reg__form input[name=email]"));
    TextField passwordField = new TextField(By.cssSelector("form.new-log-reg__form input[name=password]"));
    Button submitButton = new Button(By.cssSelector("form.new-log-reg__form button[type=submit]"));

    public void logIn(String email, String password) {
        emailField.interact(email);
        passwordField.interact(password);
        submitButton.interact();
        new WebDriverWait(getDriver(), 4).until(d -> d.findElements(submitButton.getLocator()).size() == 0 );
    }
}
