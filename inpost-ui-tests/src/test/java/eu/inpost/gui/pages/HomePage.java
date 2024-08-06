package eu.inpost.gui.pages;

import eu.inpost.util.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;

public class HomePage extends LoadableComponent<HomePage> {
    WebDriver driver;

    @FindBy(name = "number")
    private WebElement packageNumberInputField;
    @FindBy(id = "onetrust-reject-all-handler")
    private WebElement rejectCookiesButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public FindParcelPage inputPackageNumberAndSubmit(String number) {
        packageNumberInputField.sendKeys(number);
        packageNumberInputField.submit();

        return new FindParcelPage(driver);
    }

    @Override
    protected void load() {
        driver.get("http://" + Environment.getGuiHost());
    }

    @Override
    protected void isLoaded() throws Error {
        String url = driver.getCurrentUrl();

        assertThat("User should land on page containing '" + Environment.getGuiHost() + "' in URL",
                url.contains(Environment.getGuiHost()));
    }

    /* This is not necessary but screenshots are better. */
    public void closeCookiesPopup() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(rejectCookiesButton));

        if (rejectCookiesButton.isDisplayed()) {
            rejectCookiesButton.click();
        }
    }
}
