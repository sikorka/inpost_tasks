package eu.inpost.gui;

import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

@Log4j2
@UtilityClass
public class WebDriverFactory {

    public static WebDriver createWebDriver() throws MalformedURLException {
        String grid = System.getProperty("grid"); //grid can be a standalone remote browser or grid URL
        String browser = System.getProperty("browser", "firefox");

        //remote run
        if (grid != null) {
            URL gridURL = null;
            try {
                gridURL = URI.create(grid).toURL();
            } catch (MalformedURLException e) {
                String msg = "Bad URL: '" + grid + "'!";

                log.error(msg);
                throw new MalformedURLException(msg);
            }

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("se:screenResolution", "2920x2080"); //TODO doesn't seem to be taking effect

            return new RemoteWebDriver(gridURL, capabilities);
        }

        //local run
        switch (browser) {
            case "firefox": return new FirefoxDriver();
            case "chrome": return new ChromeDriver();
            case "edge": return new EdgeDriver();
            default: {
                String msg = "Unsupported webdriver : '" + browser + "'";

                log.error(msg);
                throw new IllegalArgumentException(msg);
            }
        }
    }
}
