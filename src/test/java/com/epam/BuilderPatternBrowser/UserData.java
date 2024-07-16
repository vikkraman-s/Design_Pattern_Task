package com.epam.BuilderPatternBrowser;

public class UserData {
    private String firstName;
    private String lastName;
    private String jobTitle;
    private String education;
    private String sex;
    private String experience;
    private String date;

    private UserData(UserDataBuilder builder){
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.jobTitle=builder.jobTitle;
        this.education=builder.education;
        this.sex=builder.sex;
        this.experience=builder.experience;
        this.date=builder.date;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getEducation() {
        return education;
    }

    public String getSex() {
        return sex;
    }

    public String getExperience() {
        return experience;
    }

    public String getDate() {
        return date;
    }

    public static class UserDataBuilder{
        private String firstName;
        private String lastName;
        private String jobTitle;
        private String education;
        private String sex;
        private String experience;
        private String date;

        public UserDataBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserDataBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserDataBuilder setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }

        public UserDataBuilder setEducation(String education) {
            this.education = education;
            return this;
        }

        public UserDataBuilder setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public UserDataBuilder setExperience(String experience) {
            this.experience = experience;
            return this;
        }

        public UserDataBuilder setDate(String date) {
            this.date = date;
            return this;
        }

        public UserData build(){
            return  new UserData(this);
        }
    }
}
