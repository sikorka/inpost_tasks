package eu.inpost.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;


public class FindParcelPage extends LoadableComponent<FindParcelPage> {
    WebDriver driver;

    private static final String URL_PATH = "find-parcel";

    @FindBy(css = ".message-box > .-big")
    private WebElement packageStatus;

    public FindParcelPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.urlContains(URL_PATH));

        String url = driver.getCurrentUrl();

        assertThat("User should land on page containing'" + url + "' in URL",
                url.contains(URL_PATH));
    }

    public void isOfStatus(String status) {
        new WebDriverWait(driver,Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(packageStatus));

        assertThat("Package status contains '" + status + "'",
                packageStatus.getText().contains(status));
    }
}
