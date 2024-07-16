package com.epam.SingletonBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    private static WebDriver driver = null;
    private static BrowserFactory browserFactory = null;

    private BrowserFactory(){

    }
    public static BrowserFactory getInstanceForBrowserFactory(){
       if(browserFactory==null){
           browserFactory = new BrowserFactory();
       }
       return browserFactory;
    }
    public WebDriver getDriver(String browser){
        if(driver==null){
            switch (browser){
                case "chrome" :{
                    driver = new ChromeDriver();
                    break;
                }
                case "firefox" :{
                    driver = new FirefoxDriver();
                    break;
                }
                case "edge" :{
                    driver = new EdgeDriver();
                    break;
                }
            }
        }
        return driver;
    }
    public void quitDriver(){
        driver.quit();
        driver = null;
    }
}
