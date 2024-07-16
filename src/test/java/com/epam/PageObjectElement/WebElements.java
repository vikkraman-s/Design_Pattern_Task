package com.epam.PageObjectElement;

import com.epam.BuilderPatternBrowser.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebElements {
    public WebDriver driver;
    @FindBy(xpath = "//*[@id=\"first-name\"]")
    static WebElement firstName;

    @FindBy(xpath = "//*[@id=\"last-name\"]")
    static WebElement lastName;

    @FindBy(xpath = "//*[@id=\"job-title\"]")
    static WebElement jobTitle;

    @FindBy(xpath = "//*[@id=\"radio-button-1\"]")
    static WebElement highSchool;

    @FindBy(xpath = "//*[@id=\"radio-button-2\"]")
    static WebElement college;

    @FindBy(xpath = "//*[@id=\"radio-button-3\"]")
    static WebElement gradSchool;

    @FindBy(xpath = "//*[@id=\"datepicker\"]")
    static WebElement date;

    @FindBy(xpath = "/html/body/div/form/div/div[8]/a")
    static WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"checkbox-1\"]")
    static WebElement male;

    @FindBy(xpath = "//*[@id=\"checkbox-2\"]")
    static WebElement feMale;

    @FindBy(xpath = "//*[@id=\"checkbox-3\"]")
    static WebElement others;

    @FindBy(xpath = "//*[@id=\"select-menu\"]")
    static WebElement experienceMenu;

    @FindBy(xpath = "//*[@id=\"select-menu\"]/option[2]")
    static WebElement option1;

    @FindBy(xpath = "//*[@id=\"select-menu\"]/option[3]")
    static WebElement option2;

    @FindBy(xpath = "//*[@id=\"select-menu\"]/option[4]")
    static WebElement option3;


    public WebElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static void fillForm(UserData user) {
        firstName.sendKeys(user.getFirstName());
        lastName.sendKeys(user.getLastName());
        jobTitle.sendKeys(user.getJobTitle());

        String education = user.getEducation();
        if (education == null) {
            return;
        }
        if (education.equalsIgnoreCase("High School")) {
            highSchool.click();
        } else if (education.equalsIgnoreCase("College")) {
            college.click();
        } else if (education.equalsIgnoreCase("Grad School")) {
            gradSchool.click();
        }else {

        }

        String sex = user.getSex();
        if (sex == null) {
            return;
        }
        if(sex.equalsIgnoreCase("Male")){
            male.click();
        }else if(sex.equalsIgnoreCase("Female")){
            feMale.click();
        }else if(sex.equalsIgnoreCase("others")){
            others.click();
        }

        experienceMenu.click();

        String exp = user.getExperience();
        if (exp == null) {
            return;
        }
        if(exp.equalsIgnoreCase("0-1")){
            option1.click();
        }else if(exp.equalsIgnoreCase("2-4")){
            option2.click();
        }else if(exp.equalsIgnoreCase("5-9")){
            option3.click();
        }
        date.sendKeys(user.getDate());
    }

    public static void submitForm() {
        submitButton.click();
    }
}


