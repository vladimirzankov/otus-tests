package pages;

public class MainPage extends Page {

    public Header header;

    public void open() {
        driver.get("https://otus.ru");
        header = new Header();
    }
}
