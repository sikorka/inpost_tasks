package eu.inpost.gui.pages;

import eu.inpost.util.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.hamcrest.MatcherAssert.assertThat;

public class HomePage extends LoadableComponent<HomePage> {
    WebDriver driver;

    @FindBy(name = "number")
    private WebElement packageNumberInputField;

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
}
