import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.cssSelector("h1.d-none.d-md-block.mt-0.mb-3.text-center.h00-mktg.lh-condensed-ultra");
    private By loginField = By.id("user_login");
    private By emailField = By.id("user_email");
    private By passwordField = By.id("user_password");
    private By signUpButton = By.id("signup_button");
    private By error = By.cssSelector(".flash.flash-error.my-3");

    public SignUpPage typeUsername(String username) {
        driver.findElement(loginField).sendKeys(username);
        return this;
    }

    public SignUpPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage register(String username, String email, String password) {
        this.typeUsername(username);
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

    public String getMainErrorText() {
        return driver.findElement(error).getText();
    }
}
