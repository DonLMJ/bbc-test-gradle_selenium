package pages;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;

public class TestSteps {
    private WebDriver driver;
    static String TestString;

    @Before
    public void setUp() {

        // ChromeDriver path on development machine, which is Windows
        String OS = System.getProperty("os.name");
        if (OS.startsWith("Mac")) {
            System.setProperty("webdriver.chrome.driver",
                    Paths.get("src/test/resources/chromedriver/chromedriver").toString());

        }

        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        if (driver!=null) {
            driver.close();
            driver.quit();
        }
    }

    @Given("I am a standard logged in user")
    public void BBCSignIn() {
        driver.navigate().to("https://account.bbc.com/signin");

        //Creating object of home page
        //POM
        SignIn signIn = new SignIn(driver);
        signIn.fillEmail("lamaj.aldo+1@gmail.com");
        signIn.fillPwd("Testbbc1");
        signIn.Submit();
    }

    @When("I visit BBC news")
    public void visitBbcNews() {
        driver.navigate().to("https://www.bbc.co.uk/news");
    }

    @And("I open the first commentable news")
    public void openfirstCommentablesNews() {
        driver.findElement(By.cssSelector("a.gs-o-bullet.gs-o-bullet-.gs-c-comment-count.nw-o-link-split__anchor.nw-c-comment")).click();

    }

    @Then("I can see input field for commenting")
    public void applicationShowsThatCommentsAreEnabled() {
        //String actualMessage = driver.findElement(By.cssSelector(".ssrcss-floim3-StylediFrame"));
        List<WebElement> iframeElements = driver.findElements(By.cssSelector(".ssrcss-floim3-StylediFrame"));
        System.out.println("Total number of iframes are " + iframeElements.size());
        driver.switchTo().frame(0);
        //driver.findElement(By.cssSelector("form.comments__input"));
        WebElement frameBody= driver.findElement(By.tagName("body"));
        WebElement frameDiv = frameBody.findElement(By.cssSelector("div.comments__header.comments--border.comments--shadow"));
        WebElement frameContainer = frameDiv.findElement(By.cssSelector("div.comments__user-interactions-container"));

    }

    @Then("I can see signIn prompt")
    public void applicationShowsThatCommentsAreNOTEnabled() {
        //String actualMessage = driver.findElement(By.cssSelector(".ssrcss-floim3-StylediFrame"));
        List<WebElement> iframeElements = driver.findElements(By.cssSelector(".ssrcss-floim3-StylediFrame"));
        System.out.println("Total number of iframes are " + iframeElements.size());
        driver.switchTo().frame(0);
        //driver.findElement(By.cssSelector("form.comments__input"));
        WebElement frameBody= driver.findElement(By.tagName("body"));
        WebElement frameDiv = frameBody.findElement(By.cssSelector("div.comments__header.comments--border.comments--shadow"));
        WebElement frameContainer = frameDiv.findElement(By.cssSelector("div.comments__user-interactions-container"));

    }


}
