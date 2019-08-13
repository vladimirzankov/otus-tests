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

    private UserData() {}

    public String getFirstName() {
        return firstName;
    }

    public String getFirstNameLatin() {
        return firstNameLatin;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLastNameLatin() {
        return lastNameLatin;
    }

    public String getBlogName() {
        return blogName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public boolean isReadyForRelocation() {
        return isReadyForRelocation;
    }

    public List<ContactData> getContacts() {
        return contacts;
    }

    public String getGender() {
        return gender;
    }

    public String getCompany() {
        return company;
    }

    public List<String> getWorkSchedule() {
        return workSchedule;
    }

    public boolean isEmailPreferable() {
        return isEmailPreferable;
    }

    public boolean isPhonePreferable() {
        return isPhonePreferable;
    }

    public String getPosition() {
        return position;
    }

    public List<ExperienceData> getExperience() {
        return experience;
    }

    public static Builder newBuilder() {
        return new UserData().new Builder();
    }

    public class Builder {

        private Builder() {}

        public Builder setFirstName(String firstName) {
            UserData.this.firstName = firstName;
            return this;
        }

        public Builder setFirstNameLatin(String firstNameLatin) {
            UserData.this.firstNameLatin = firstNameLatin;
            return this;
        }

        public Builder setLastName(String lastName) {
            UserData.this.lastName = lastName;
            return this;
        }

        public Builder setLastNameLatin(String lastNameLatin) {
            UserData.this.lastNameLatin = lastNameLatin;
            return this;
        }

        public Builder setBlogName(String blogName) {
            UserData.this.blogName = blogName;
            return this;
        }

        public Builder setBirthday(LocalDate birthday) {
            UserData.this.birthday = birthday;
            return this;
        }

        public Builder setCountry(String country) {
            UserData.this.country = country;
            return this;
        }

        public Builder setCity(String city) {
            UserData.this.city = city;
            return this;
        }

        public Builder setReadyForRelocation(boolean readyForRelocation) {
            UserData.this.isReadyForRelocation = readyForRelocation;
            return this;
        }

        public Builder setContacts(List<ContactData> contacts) {
            UserData.this.contacts = contacts;
            return this;
        }

        public Builder setGender(String gender) {
            UserData.this.gender = gender;
            return this;
        }

        public Builder setCompany(String company) {
            UserData.this.company = company;
            return this;
        }

        public Builder setWorkSchedule(List<String> workSchedule) {
            UserData.this.workSchedule = workSchedule;
            return this;
        }

        public Builder setEmailPreferable(boolean emailPreferable) {
            UserData.this.isEmailPreferable = emailPreferable;
            return this;
        }

        public Builder setPhonePreferable(boolean phonePreferable) {
            UserData.this.isPhonePreferable = phonePreferable;
            return this;
        }

        public Builder setPosition(String position) {
            UserData.this.position = position;
            return this;
        }

        public Builder setExperience(List<ExperienceData> experience) {
            UserData.this.experience = experience;
            return this;
        }

        public UserData build() {
            return UserData.this;
        }
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

        public String getValue() {
            return value;
        }

        public boolean isPreferable() {
            return isPreferable;
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

        public String getLanguage() {
            return language;
        }
    }
}
