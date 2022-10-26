package pageobjects;

import Components.AbstractComponent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.Set;

public class ProductDetailPage extends AbstractComponent {
    WebDriver driver;
    JavascriptExecutor js;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    @FindBy(css = "#addToCart")
    WebElement addToCartFromFirstSeller;
    @FindBy(css = ".checkoutui-Modal-2iZXl")
    WebElement closeWindowSymbol;
    @FindBy(xpath = "//div[@class='other-sellers']")
    WebElement otherSellers;
    @FindBy(xpath = "(//div[@class='marketplace-list']//tbody//tr//td[3]//div[1])[1]")
    WebElement addToCartFromSecondSeller;
    @FindBy(id = "shoppingCart")
    WebElement cart;
    @FindBy(css = ".title-wrapper #product-name")
    WebElement productName;

    public void addFirstProductToCart() throws InterruptedException {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        addToCartFromFirstSeller.click();
        Thread.sleep(3000);
        if (closeWindowSymbol.isDisplayed()){
            closeWindowSymbol.click();
            js.executeScript("arguments[0].scrollIntoView();", otherSellers);
        } else{
            js.executeScript("arguments[0].scrollIntoView();", otherSellers);
        }
    }
    public void addSecondProductToCart() throws InterruptedException {
        if (addToCartFromSecondSeller.isDisplayed()) {
            addToCartFromSecondSeller.click();
            Thread.sleep(3000);
            if (closeWindowSymbol.isDisplayed()) {
                closeWindowSymbol.click();
                js.executeScript("arguments[0].scrollIntoView();", cart);
            } else {
                js.executeScript("arguments[0].scrollIntoView();", cart);
            }
        }
    }

    public CartPage goToCartPage() {
        waitForWebElementToAppear(cart);
        cart.click();
        return new CartPage(driver);
    }

    public String getProductName() {
        waitForWebElementToAppear(productName);
        return productName.getText();

    }
}
