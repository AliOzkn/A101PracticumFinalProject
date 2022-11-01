package tests;

import TestComponents.BaseTest;
import TestComponents.DriverSetup;
import org.testng.annotations.Test;
import pageobjects.CartPage;
import pageobjects.ProductDetailPage;
import pageobjects.ProductsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class BuyingProductWithUserLogin extends BaseTest {

    @Test
    void checkUserLogin() {
        mainPage.login(DriverSetup.properties.getProperty("email"), DriverSetup.properties.getProperty("password"));
        assertEquals(mainPage.getAccountText(), mainPage.account.toUpperCase());
    }

    @Test(dependsOnMethods = "checkUserLogin")
    void checkProductNameWithUserLogin() throws InterruptedException {
        mainPage.login(DriverSetup.properties.getProperty("email"), DriverSetup.properties.getProperty("password"));
        ProductsPage productsPage = mainPage.acceptCookies();
        mainPage.searchProduct(DriverSetup.properties.getProperty("productName"));
        ProductDetailPage productDetailPage = productsPage.getProduct(0);
        productDetailPage.addFirstProductToCart();
        String expectedText = productDetailPage.getProductName();
        productDetailPage.addSecondProductToCart();
        CartPage cartPage = productDetailPage.goToCartPage();
        assertEquals(cartPage.getProductName(), expectedText);
    }

    @Test(dependsOnMethods = "checkProductNameWithUserLogin")
    void checkSellersNamesWithUserLogin() {
        mainPage.login(DriverSetup.properties.getProperty("email"), DriverSetup.properties.getProperty("password"));
        CartPage cartPage =  mainPage.goToCart();
        assertFalse(cartPage.getFirstSellerName().equals(cartPage.getSecondSellerName()));
    }

}
