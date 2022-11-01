package pageobjects;

import Components.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractComponent {
    WebDriver driver;
    public final String account = "HESABIM";

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(css = "#myAccount")
    WebElement myAccount;
    @FindBy(css = "[data-test-id='account'] .sf-OldMyAccount-d0xCHLV38UCH5cD9mOXq")
    WebElement myAccountText;
    @FindBy(xpath = "//ul//li//a[@id='login']")
    WebElement firstLoginBtn;
    @FindBy(css = "input#txtUserName")
    WebElement mail;
    @FindBy(id = "btnLogin")
    WebElement secondLoginBtn;
    @FindBy(css = "input#txtPassword")
    WebElement pass;
    @FindBy(id = "btnEmailSelect")
    WebElement thirdLoginBtn;
    @FindBy(css = "#onetrust-accept-btn-handler:nth-of-type(2)")
    WebElement acceptCookies;
    @FindBy(css = "[aria-controls='react-autowhatever-1']")
    WebElement searchBox;
    @FindBy(css = ".SearchBoxOld-cHxjyU99nxdIaAbGyX7F")
    WebElement searchBtn;
    @FindBy(id = "shoppingCart")
    WebElement cart;


    public void login(String email, String password) {
        myAccount.click();
        waitForWebElementToAppear(firstLoginBtn);
        firstLoginBtn.click();
        waitForWebElementToAppear(mail);
        mail.sendKeys(email);
        secondLoginBtn.click();
        waitForWebElementToAppear(pass);
        pass.sendKeys(password);
        thirdLoginBtn.click();

    }

    public String getAccountText() {
        waitForWebElementToAppear(myAccount);
        return myAccountText.getText().toUpperCase();
    }

    public ProductsPage acceptCookies() {
        waitForWebElementToAppear(acceptCookies);
        acceptCookies.click();
        return new ProductsPage(driver);
    }

    public void searchProduct(String productName) {
        waitForWebElementToAppear(searchBox);
        searchBox.sendKeys(productName);
        searchBtn.click();
    }
    public CartPage goToCart(){
        waitForWebElementToAppear(cart);
        cart.click();
        return new CartPage(driver);
    }
}
