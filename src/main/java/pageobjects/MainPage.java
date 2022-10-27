package pageobjects;

import Components.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractComponent {
    WebDriver driver;
    public final String account = "Hesabım";

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(css = "#myAccount")
    WebElement myAccount;
    @FindBy(xpath = "//a[@title='Hesabım']//span[1]")
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
        waitForWebElementToAppear(myAccountText);
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
}
