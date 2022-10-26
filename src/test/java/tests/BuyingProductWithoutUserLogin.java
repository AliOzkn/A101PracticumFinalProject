package tests;

import TestComponents.BaseTest;
import TestComponents.DriverSetup;
import org.testng.annotations.Test;
import pageobjects.CartPage;
import pageobjects.ProductDetailPage;
import pageobjects.ProductsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;


public class BuyingProductWithoutUserLogin extends BaseTest {

    @Test
    public void checkProductNameWithoutUserLogin() throws InterruptedException {
        ProductsPage productsPage = mainPage.acceptCookies();
        mainPage.searchProduct(DriverSetup.properties.getProperty("productName"));
        ProductDetailPage productDetailPage = productsPage.getProduct(0);
        productDetailPage.addFirstProductToCart();
        String expectedText = productDetailPage.getProductName();
        productDetailPage.addSecondProductToCart();
        CartPage cartPage = productDetailPage.goToCartPage();
        assertEquals(cartPage.getProductName(), expectedText);
    }

    @Test
    void checkSellersNamesWithoutUserLogin() throws InterruptedException {
        ProductsPage productsPage = mainPage.acceptCookies();
        mainPage.searchProduct(DriverSetup.properties.getProperty("productName"));
        ProductDetailPage productDetailPage = productsPage.getProduct(0);
        productDetailPage.addFirstProductToCart();
        productDetailPage.addSecondProductToCart();
        CartPage cartPage = productDetailPage.goToCartPage();
        assertFalse(cartPage.getFirstSellerName().equals(cartPage.getSecondSellerName()));
    }
}
