package pageobjects;

import Components.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CartPage extends AbstractComponent {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "(//div[@class='merchantBoxWrapper_10ife']//ul//div[@class='product_name_3Lh3t']//a)[1]")
    WebElement productName;
    @FindBy(xpath = "(//span[@class='merchantLink_2Ii8s']//a)[1]")
    WebElement firstSellerName;
    @FindBy(xpath = "(//span[@class='merchantLink_2Ii8s']//a)[2]")
    WebElement secondSellerName;

    public String getProductName() {
        waitForWebElementToAppear(productName);
        return productName.getText();
    }
    public String getFirstSellerName(){
        waitForWebElementToAppear(firstSellerName);
        return firstSellerName.getText();
    }
    public String getSecondSellerName(){
        waitForWebElementToAppear(secondSellerName);
        return secondSellerName.getText();
    }

}
