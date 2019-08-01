package model;

import java.time.LocalDate;
import java.util.List;

public class UserData {

    private String firstName;
    private String firstNameLatin;
    private String lastName;
    private String lastNameLatin;
    private String blogName;
    private LocalDate birthday;
    private String country;
    private String city;
    private boolean isReadyForRelocation;
    private List<String> workSchedule;
    private boolean isEmailPreferable;
    private boolean isPhonePreferable;
    private List<ContactData> contacts;
    private String gender;
    private String company;
    private String position;
    private List<ExperienceData> experience;

    public UserData(String firstName, String firstNameLatin, String lastName, String lastNameLatin, String blogName, LocalDate birthday, String country, String city, boolean isReadyForRelocation, List<String> workSchedule, boolean isEmailPreferable, boolean isPhonePreferable, List<ContactData> contacts, String gender, String company, String position, List<ExperienceData> experience) {
        this.firstName = firstName;
        this.firstNameLatin = firstNameLatin;
        this.lastName = lastName;
        this.lastNameLatin = lastNameLatin;
        this.blogName = blogName;
        this.birthday = birthday;
        this.country = country;
        this.city = city;
        this.isReadyForRelocation = isReadyForRelocation;
        this.workSchedule = workSchedule;
        this.isEmailPreferable = isEmailPreferable;
        this.isPhonePreferable = isPhonePreferable;
        this.contacts = contacts;
        this.gender = gender;
        this.company = company;
        this.position = position;
        this.experience = experience;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstNameLatin() {
        return firstNameLatin;
    }

    public void setFirstNameLatin(String firstNameLatin) {
        this.firstNameLatin = firstNameLatin;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastNameLatin() {
        return lastNameLatin;
    }

    public void setLastNameLatin(String lastNameLatin) {
        this.lastNameLatin = lastNameLatin;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isReadyForRelocation() {
        return isReadyForRelocation;
    }

    public void setReadyForRelocation(boolean readyForRelocation) {
        isReadyForRelocation = readyForRelocation;
    }

    public List<ContactData> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactData> contacts) {
        this.contacts = contacts;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<String> getWorkSchedule() {
        return workSchedule;
    }

    public void setWorkSchedule(List<String> workSchedule) {
        this.workSchedule = workSchedule;
    }

    public boolean isEmailPreferable() {
        return isEmailPreferable;
    }

    public void setEmailPreferable(boolean emailPreferable) {
        isEmailPreferable = emailPreferable;
    }

    public boolean isPhonePreferable() {
        return isPhonePreferable;
    }

    public void setPhonePreferable(boolean phonePreferable) {
        isPhonePreferable = phonePreferable;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<ExperienceData> getExperience() {
        return experience;
    }

    public void setExperience(List<ExperienceData> experience) {
        this.experience = experience;
    }

    public static class ContactData {

        private String type;
        private String value;
        private boolean isPreferable;

        public ContactData(String type, String value, boolean isPreferable) {
            this.type = type;
            this.value = value;
            this.isPreferable = isPreferable;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isPreferable() {
            return isPreferable;
        }

        public void setPreferable(boolean preferable) {
            isPreferable = preferable;
        }
    }

    public static class ExperienceData {

        private String language;
        private String level;

        public ExperienceData(String language, String level) {
            this.language = language;
            this.level = level;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }
    }
}
