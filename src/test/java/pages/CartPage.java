package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private static final By CHECKOUT = By.xpath("//*[@id='checkout']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Нажатие на кнопку checkout")
    public void checkout() {
        driver.findElement(CHECKOUT).click();
    }
}
