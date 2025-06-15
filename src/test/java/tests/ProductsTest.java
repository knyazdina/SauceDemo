package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest{

    @Description("Проверка сортировки")
    @Test(testName = "Позитивный тест страницы с товарами", description = "Проверка сортировки")
    public void checkSort() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.productSort();
        assertEquals(productsPage.getItemName(),
                "Test.allTheThings() T-Shirt (Red)",
                "Сортировка не сработала");
    }

    @Description("Проверка добавления товара в корзину")
    @Test(testName = "Позитивный тест страницы с товарами", description = "Проверка добавления товара в корзину")
    public void checkAddToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart();
        assertEquals(productsPage.getItemName(),
                "Test.allTheThings() T-Shirt (Red)",
                "Товар не добавился в корзину");
    }
}
