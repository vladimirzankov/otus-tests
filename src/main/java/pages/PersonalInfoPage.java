package pages;

import controls.*;
import model.Builder;
import model.UserData;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonalInfoPage extends Page{

    TextField firstName = new TextField(By.cssSelector("input#id_fname"));
    TextField firstNameLatin = new TextField(By.cssSelector("input#id_fname_latin"));
    TextField lastName = new TextField(By.cssSelector("input#id_lname"));
    TextField lastNameLatin = new TextField(By.cssSelector("input#id_lname_latin"));
    TextField blogName = new TextField(By.cssSelector("input#id_blog_name"));
    TextField birthday = new TextField(By.cssSelector("input[name=date_of_birth]"));
    FileInput uploadAvatar = new FileInput(By.cssSelector("div.settings-photo input[type=file]"));
    Button confirmAvatarButton = new Button(By.cssSelector("button.js-choose-crop"));
    Button countrySelect = new Button(By.cssSelector("input[name=country] + div"));
    Button citySelect = new Button(By.cssSelector("input[name=city] + div"));
    Checkbox isEmailPreferableCheckbox = new Checkbox(By.cssSelector("input#id_is_email_preferable + span"));
    Checkbox isPhonePreferableCheckbox = new Checkbox(By.cssSelector("input#id_is_phone_preferable + span"));
    Button addContactButton = new Button(By.xpath("//div[p[text()='Контактная информация']]//button[text()='Добавить']"));
    By deleteContactButtonsLocator = By.xpath("//div[contains(@class, 'container__row') and contains(@class, 'js-formset-row')]/div/div/button[text()='Удалить']");
    By genderSelectLocator = By.cssSelector("select#id_gender");
    TextField company = new TextField(By.cssSelector("input#id_company"));
    TextField position = new TextField(By.cssSelector("input#id_work"));
    Button addExperienceButton = new Button(By.xpath("//div[h3[text()='Опыт разработки']]//a[@title='Добавить']"));
    By deleteExperienceButtonLocator = By.cssSelector("div.experience-row__remove");
    Button saveButton = new Button(By.cssSelector("button[title=Сохранить]"));
    Button saveAndContinueButton = new Button(By.cssSelector("button[title='Сохранить и продолжить']"));
    Button saveAndExitButton = new Button(By.cssSelector("button[title='Сохранить и заполнить позже']"));

    public void open() {
        driver.get("https://otus.ru/lk/biography/personal/");
    }

    public Button countryButton(String country) {
        return new Button(By.cssSelector(String.format("div[class*=select-scroll_country] > button[title=%s]", country)));
    }

    public Button cityButton(String city) {
        return new Button(By.cssSelector(String.format("div[class*=select-scroll_city] > button[title=%s]", city)));
    }

    public Radiobutton readyForRelocateRadiobutton(boolean isReady) {
        return new Radiobutton (By.cssSelector(String.format("input[name=ready_to_relocate][value=%s] + span", StringUtils.capitalize(String.valueOf(isReady)))));
    }

    public Checkbox workSchedule(String workSchedule) {
        return new Checkbox(By.cssSelector(String.format("input[name=work_schedule][title='%s'] + span", workSchedule)));
    }

    public Button contactTypeSelect(int i) {
        return new Button(By.cssSelector(String.format("input[name=contact-%s-service] + div", String.valueOf(i))));
    }

    public Button contactTypeButton(String contactType) {
        return new Button(By.cssSelector(String.format("div:not([class*='hide']) > div > button[data-empty='Способ связи'] ~ button[title=%s]", contactType)));
    }

    public TextField contactValue(int i) {
        return new TextField(By.cssSelector(String.format("input[name=contact-%s-value]", String.valueOf(i))));
    }

    public Checkbox isContactPreferable(int i) {
        return new Checkbox(By.cssSelector(String.format("input#id_contact-%s-preferable + span", String.valueOf(i))));
    }

    public By experienceLanguage(int i) {
        return By.cssSelector(String.format("#id_experience-%s-experience", String.valueOf(i)));
    }

    public By experienceLevel (int i) {
        return By.cssSelector(String.format("#id_experience-%s-level", String.valueOf(i)));
    }

    public void selecWorkSchedule(List<String> workSchedule) {
        for(String s: workSchedule)
            workSchedule(s).interact(true);
    }

    public void deleteContactsWithIndexGreaterThat(int firstContactForDelete) {
        List<WebElement> deleteButtons = driver.findElements(deleteContactButtonsLocator);
        for(int i = firstContactForDelete; i < deleteButtons.size(); i++){
            deleteButtons.get(i).click();
        }
    }

    public void deleteExperienceWithIndexGreaterThat(int firstLanguageForDelete) {
        List<WebElement> deleteButtons = driver.findElements(deleteExperienceButtonLocator);
        for(int i = firstLanguageForDelete; i < deleteButtons.size(); i++){
            deleteButtons.get(i).click();
        }
    }

    public int getContactsCount() {
        return driver.findElements(By.cssSelector("[id^=id_contact-][id$=id]")).size();
    }

    public int getLanguagesCount() {
        return driver.findElements(By.cssSelector("[id^=id_experience-][id$=experience]")).size();
    }

    public void fillUserData(UserData user) {
        firstName.interact(user.getFirstName());
        firstNameLatin.interact(user.getFirstNameLatin());
        lastName.interact(user.getLastName());
        lastNameLatin.interact(user.getLastNameLatin());
        blogName.interact(user.getBlogName());
        birthday.interact(user.getBirthday().toString());
        uploadAvatar.interact("image.jpg");
        confirmAvatarButton.interactAndWait(d -> ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body.overflow-hidden-body"))));
        countrySelect.interact();
        countryButton(user.getCountry()).interact();
        citySelect.interact();
        cityButton(user.getCity()).interact();
        readyForRelocateRadiobutton(user.isReadyForRelocation()).interact();
        selecWorkSchedule(user.getWorkSchedule());
        isEmailPreferableCheckbox.interact(user.isEmailPreferable());
        isPhonePreferableCheckbox.interact(user.isPhonePreferable());
        UserData.ContactData currentContact;
        for(int i = 0; i < user.getContacts().size(); i++) {
            currentContact = user.getContacts().get(i);
            try {
                contactTypeSelect(i).interact();
            }
            catch(NotFoundException e) {
                addContactButton.interact();
            }
            contactTypeButton(currentContact.getType()).interact();
            contactValue(i).interact(currentContact.getValue());
            isContactPreferable(i).interact(currentContact.isPreferable());
        }
        deleteContactsWithIndexGreaterThat(user.getContacts().size());
        new Select(driver.findElement(genderSelectLocator)).selectByVisibleText(user.getGender());
        company.interact(user.getCompany());
        position.interact(user.getPosition());
        for(int i = 0; i < user.getExperience().size(); i++) {
            if(driver.findElements(experienceLanguage(i)).size() == 0) {
                addExperienceButton.interact();
            }
            new Select(driver.findElement(experienceLanguage(i))).selectByVisibleText(user.getExperience().get(i).getLanguage());
            new Select(driver.findElement(experienceLevel(i))).selectByVisibleText(user.getExperience().get(i).getLevel());
        }
        deleteExperienceWithIndexGreaterThat(user.getExperience().size());
        saveButton.interact();
    }

    public List<String> getWorkSchedule() {
        List<String> workSchedule = new ArrayList<>();
        workSchedule.add("Полный день"); workSchedule.add("Гибкий график"); workSchedule.add("Удаленно");
        for(Iterator<String> iterator = workSchedule.iterator(); iterator.hasNext();) {
            String value = iterator.next();
            if(!(workSchedule(value).isSelected())) {
                iterator.remove();
            }
        }
        return workSchedule;
    }

    public UserData getUserData() {
        List<UserData.ContactData> contacts = new ArrayList<>();
        for(int i = 0; i < getContactsCount(); i++) {
            String type = contactTypeSelect(i).getText();
            String value = contactValue(i).getAttribute("value");
            boolean isPreferable = isContactPreferable(i).isSelected();
            contacts.add(new UserData.ContactData(type, value, isPreferable));
        }
        List<UserData.ExperienceData> experience = new ArrayList<>();
        for(int i = 0; i < getLanguagesCount(); i++) {
            String language = new Select(driver.findElement(experienceLanguage(i))).getFirstSelectedOption().getText();
            String level = new Select(driver.findElement(experienceLevel(i))).getFirstSelectedOption().getText();
            experience.add(new UserData.ExperienceData(language, level));
        }
        UserData user = new Builder()
                .setFirstName(firstName.getAttribute("value"))
                .setFirstNameLatin(firstNameLatin.getAttribute("value"))
                .setLastName(lastName.getAttribute("value"))
                .setLastNameLatin(lastNameLatin.getAttribute("value"))
                .setBlogName(blogName.getAttribute("value"))
                .setBirthday(LocalDate.parse(birthday.getAttribute("value"), DateTimeFormatter.ofPattern("dd.MM.yyyy")))
                .setCountry(countrySelect.getText())
                .setCity(citySelect.getText())
                .setIsReadyForRelocation(readyForRelocateRadiobutton(true).isSelected())
                .setWorkSchedule(getWorkSchedule())
                .setIsEmailPreferable(isEmailPreferableCheckbox.isSelected())
                .setIsPhonePreferable(isPhonePreferableCheckbox.isSelected())
                .setContacts(contacts)
                .setGender(new Select(driver.findElement(genderSelectLocator)).getFirstSelectedOption().getText())
                .setCompany(company.getAttribute("value"))
                .setPosition(position.getAttribute("value"))
                .setExperience(experience)
                .createUserData();
        return user;
    }
}
