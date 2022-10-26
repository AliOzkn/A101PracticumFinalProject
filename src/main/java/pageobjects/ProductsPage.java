package pageobjects;

import Components.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends AbstractComponent {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    @FindBy(css = "ul[id='1'] li a")
    List<WebElement> products;

    public List<WebElement> getProductsList() {
        waitForWebElementsToAppear(products);
        return products;
    }

    public ProductDetailPage getProduct(int i) {
        getProductsList().get(i).click();
        return new ProductDetailPage(driver);
    }
}
