package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {


    @Description("Проверка кнопки Checkout")
    @Test(testName = "Позитивный тест корзины",
            description = "Проверка кнопки Checkout")
    public void checkCheckoutButton() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.productSort();
        productsPage.addToCart();
        cartPage.checkout();
        assertEquals(checkoutPage.getTitle(),
                "Checkout: Your Information",
                "Кнопка Checkout не работает");
    }
}
