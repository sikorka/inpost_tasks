package eu.inpost.gui;

import eu.inpost.gui.pages.FindParcelPage;
import eu.inpost.gui.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import lombok.extern.log4j.Log4j2;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Log4j2
public class SearchSteps {

    private final WebDriver driver = WebDriverFactory.createWebDriver();

    HomePage homePage = new HomePage(driver);
    FindParcelPage findParcelPage = new FindParcelPage(driver);

    @Given("InPost website is open")
    public void inpostWebsiteIsOpen() {
        homePage.get();
    }

    @When("I search for package {string}")
    public void iSearchForPackage(String packageNumber) {
        findParcelPage = homePage.inputPackageNumberAndSubmit(packageNumber);
    }

    @Then("status should be {string}")
    public void statusShouldBe(String packageStatus) {
        findParcelPage.get();
        findParcelPage.isOfStatus(packageStatus);
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }

    @AfterStep()
    public void takeScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
    }
}
