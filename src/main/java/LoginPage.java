import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginField = By.id("login_field");
    private By passwordField = By.id("password");
    private By signInButton = By.cssSelector("input.btn.btn-primary.btn-block");
    private By heading = By.cssSelector(".auth-form-header.p-0 h1");
    private By error = By.cssSelector("#js-flash-container .container");
    private By createAccLink = By.linkText("Create an account");

    public LoginPage typeUsername(String username) {
        driver.findElement(loginField).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage clickSignIn() {
        driver.findElement(passwordField).click();
        return this;
    }

    public LoginPage loginWithInvalidData(String username, String password) {
        this.typeUsername(username);
        this.typePassword(password);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

    public String getErrorText() {
        return driver.findElement(error).getText();
    }

    public SignUpPage createAccaunt() {
        driver.findElement(createAccLink).click();
        return new SignUpPage(driver);
    }
}
