package services;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AdvancedDriver {
    
    public WebDriver getDriver(){

         System.setProperty("webdriver.chrome.driver",
                 "C:\\Users\\sony\\IdeaProjects\\TAF_21_1\\src\\test\\resources\\chromedriver.exe");

         return new ChromeDriver(getChromeOptions());
    }
    private ChromeOptions getChromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.setHeadless(ReadProperties.isHeadless());
        chromeOptions.addArguments("--");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--silent");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--start-maximized");

        return chromeOptions;
    }
}
