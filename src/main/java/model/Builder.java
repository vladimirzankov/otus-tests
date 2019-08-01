package model;

import java.time.LocalDate;
import java.util.List;

public class Builder {
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
    private List<UserData.ContactData> contacts;
    private String gender;
    private String company;
    private String position;
    private List<UserData.ExperienceData> experience;

    public Builder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Builder setFirstNameLatin(String firstNameLatin) {
        this.firstNameLatin = firstNameLatin;
        return this;
    }

    public Builder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Builder setLastNameLatin(String lastNameLatin) {
        this.lastNameLatin = lastNameLatin;
        return this;
    }

    public Builder setBlogName(String blogName) {
        this.blogName = blogName;
        return this;
    }

    public Builder setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public Builder setCountry(String country) {
        this.country = country;
        return this;
    }

    public Builder setCity(String city) {
        this.city = city;
        return this;
    }

    public Builder setIsReadyForRelocation(boolean isReadyForRelocation) {
        this.isReadyForRelocation = isReadyForRelocation;
        return this;
    }

    public Builder setWorkSchedule(List<String> workSchedule) {
        this.workSchedule = workSchedule;
        return this;
    }

    public Builder setIsEmailPreferable(boolean isEmailPreferable) {
        this.isEmailPreferable = isEmailPreferable;
        return this;
    }

    public Builder setIsPhonePreferable(boolean isPhonePreferable) {
        this.isPhonePreferable = isPhonePreferable;
        return this;
    }

    public Builder setContacts(List<UserData.ContactData> contacts) {
        this.contacts = contacts;
        return this;
    }

    public Builder setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public Builder setCompany(String company) {
        this.company = company;
        return this;
    }

    public Builder setPosition(String position) {
        this.position = position;
        return this;
    }

    public Builder setExperience(List<UserData.ExperienceData> experience) {
        this.experience = experience;
        return this;
    }

    public UserData createUserData() {
        return new UserData(firstName, firstNameLatin, lastName, lastNameLatin, blogName, birthday, country, city, isReadyForRelocation, workSchedule, isEmailPreferable, isPhonePreferable, contacts, gender, company, position, experience);
    }
}