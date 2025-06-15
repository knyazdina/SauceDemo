package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {


    @Description("Проверка регистрации с валидными данными")
    @Test(testName = "Позитивный тест формы покупателя",
            description = "Проверка регистрации с валидными данными")
    public void checkInputsWithPositiveCred() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart();
        cartPage.checkout();
        checkoutPage.setInputValues("Dina","Knyazeva","123456");
        assertEquals(checkoutPage.getTitle(),
                "Checkout: Overview",
                "Форма заполнилась корректно");
    }

    @Epic("Заполнение информации о покупателе")
    @Feature("Форма покупателя")
    @Story("Ввод пустого имени в форме")
    @Description("Проверка регистрации с пустым полем для имени")
    @Severity(SeverityLevel.MINOR)
    @Owner("Dina Knyazeva")
    @TmsLink("SD-01")
    @Issue("SD-BUG-01")
    @Link(name = "Документация", url = "https://github.com/knyazdina/SauceDemo")
    @Flaky
    @Test (testName = "Негативный тест формы покупателя",
            description = "Проверка регистрации с пустым полем для имени")
    public void checkInputsWithEmptyFirstName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart();
        cartPage.checkout();
        checkoutPage.setInputValues("","Knyazeva","123456");
        assertEquals(checkoutPage.getErrorMessage(),
                "Error: First Name is required",
                "Сообщение об ошибке не появилось");
    }


    @Description("Проверка регистрации с пустым полем для фамилии")
    @Test(testName = "Негативный тест формы покупателя",
            description = "Проверка регистрации с пустым полем для фамилии")
    public void checkInputsWithEmptyLastName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart();
        cartPage.checkout();
        checkoutPage.setInputValues("Dina","","123456");
        assertEquals(checkoutPage.getErrorMessage(),
                "Error: Last Name is required",
                "Сообщение об ошибке не появилось");
    }


    @Description("Проверка регистрации с пустым полем Zip Code")
    @Test(testName = "Негативный тест формы покупателя",
            description = "Проверка регистрации с пустым полем Zip Code")
    public void checkInputsWithEmptyZipCode() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart();
        cartPage.checkout();
        checkoutPage.setInputValues("Dina","Knyazeva","");
        assertEquals(checkoutPage.getErrorMessage(),
                "Error: Postal Code is required",
                "Сообщение об ошибке не появилось");
    }
}
