import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.FindBy;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

//    By signInButton = By.linkText(" Sign In ");
    By signInButton = By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/a[1]");
    By signUpButton = By.linkText("Sign Up");
    By loginField = By.id("user[login]");
    By emailField = By.id("user[email]");
    By passwordField = By.id("user[password]");
    By signUpForGithubButton = By.cssSelector(".btn-mktg.btn-primary-mktg.btn-large-mktg.f4.btn-block.my-3.js-add-experiment-labels-to-ga-click");

    public LoginPage clickSignIn() {
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUp() {
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpForGithubButton() {
        driver.findElement(signUpForGithubButton).click();
        return new SignUpPage(driver);
    }

    public MainPage typeLogin(String login) {
        driver.findElement(loginField).sendKeys(login);
        return this;
    }

    public MainPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public MainPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage register(String login, String email, String password) {
        this.typeLogin(login);
        this.typeEmail(email);
        this.typePassword(password);
        this.clickSignUpForGithubButton();
        return new SignUpPage(driver);
    }

}
