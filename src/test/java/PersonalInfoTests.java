import config.DriverBase;
import model.UserData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.PersonalInfoPage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class PersonalInfoTests {

        private MainPage mainPage;
        private LoginPage loginPage;
        private PersonalInfoPage personalInfoPage;

        @Before
        public void setupTest() {
            mainPage = new MainPage();
            loginPage = new LoginPage();
            personalInfoPage = new PersonalInfoPage();
        }

        @Test
        public void test1() {
            List<UserData.ContactData> contacts = new ArrayList<>();
            contacts.add(new UserData.ContactData("Facebook", "https://facebook.com/learner", false));
            contacts.add(new UserData.ContactData("VK", "https://vk.com/learner", true));
            List<UserData.ExperienceData> experience = new ArrayList<>();
            experience.add(new UserData.ExperienceData("Java", "1 год"));
            UserData userForCreate = UserData.newBuilder()
                    .setFirstName("лернер")
                    .setFirstNameLatin("learner")
                    .setLastName("лернер")
                    .setLastNameLatin("learner")
                    .setBlogName("лернер")
                    .setBirthday(LocalDate.of(2000, 1, 1))
                    .setCountry("Россия")
                    .setCity("Москва")
                    .setReadyForRelocation(true)
                    .setWorkSchedule(Arrays.asList("Полный день", "Удаленно"))
                    .setEmailPreferable(false)
                    .setPhonePreferable(true)
                    .setContacts(contacts)
                    .setGender("Мужской")
                    .setCompany("Otus")
                    .setPosition("learner")
                    .setExperience(experience)
                    .build();
            mainPage.open();
            mainPage.header.openAuthPage();
            loginPage.logIn(System.getProperty("otus.login"), System.getProperty("otus.password"));
            personalInfoPage.open();
            personalInfoPage.fillUserData(userForCreate);
            clearCookies();
            mainPage.open();
            mainPage.header.openAuthPage();
            loginPage.logIn(System.getProperty("otus.login"), System.getProperty("otus.password"));
            personalInfoPage.open();
            UserData createdUser = personalInfoPage.getUserData();
            assertThat(createdUser).isEqualToComparingFieldByFieldRecursively(userForCreate);
        }

    @After()
    public void clearCookies() {
        DriverBase.clearCookies();
    }
}
