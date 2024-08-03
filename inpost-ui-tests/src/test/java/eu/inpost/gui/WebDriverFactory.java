package eu.inpost.gui;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@UtilityClass
public class WebDriverFactory {

    public static WebDriver createWebDriver() {
        String webdriver = System.getProperty("browser", "firefox");

        switch(webdriver) {
            case "firefox":
                return new FirefoxDriver();
            case "chrome":
                return new ChromeDriver();
            default:
                throw new IllegalArgumentException("Unsupported webdriver: " + webdriver);
        }
    }
}
