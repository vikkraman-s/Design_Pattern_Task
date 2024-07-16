package com.epam.SingletonBrowser;

import com.epam.BuilderPatternBrowser.UserData;
import com.epam.PageObjectElement.PageObjectFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.epam.PageObjectElement.WebElements.fillForm;
import static com.epam.PageObjectElement.WebElements.submitForm;

public class Formy {
    public static WebDriver driver;
    @BeforeTest
    public static void start(){
        driver = BrowserFactory.getInstanceForBrowserFactory().getDriver("chrome");
        driver.get("https://formy-project.herokuapp.com/form");
        driver.manage().window().maximize();

    }
    @Test
    public void checkForm(){
        UserData user = new UserData.UserDataBuilder()
                .setFirstName("vikram")
                .setLastName("s")
                .setEducation("College")
                .setSex("Male")
                .setExperience("2-4")
                .setDate("7/12/2024")
                .setJobTitle("Tester")
                .build();
        PageObjectFactory factory =new PageObjectFactory(driver);

        fillForm(user);
        submitForm();

    }
    @AfterTest
    public static void close(){
        BrowserFactory.getInstanceForBrowserFactory().quitDriver();
    }
}
