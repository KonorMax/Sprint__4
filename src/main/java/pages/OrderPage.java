package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static config.WebDriverConfig.WAIT_SECONDS_TIMEOUT;

// Начальная страница заказа самоката
public class OrderPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    //локатор поля Имени
    private final By fieldName = By.xpath(".//*[@placeholder='* Имя']");

    //локатор поля Фамилии
    private final By fieldSurname = By.xpath(".//*[@placeholder='* Фамилия']");

    //локатор поля Адреса
    private final By fieldAddress = By.xpath(".//*[@placeholder='* Адрес: куда привезти заказ']");

    //локатор поля Метро
    private final By fieldMetro = By.className("select-search__value");

    //локатор поля Телефона
    private final By fieldPhone = By.xpath(".//*[@placeholder='* Телефон: на него позвонит курьер']");

    //локатор кнопки Далее
    private final By nextBtn = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_SECONDS_TIMEOUT));
    }

    //метод заполнения полей заказа
    public OrderPage fillFieldFirst(String[] data) {
        driver.findElement(fieldName).isDisplayed();
        driver.findElement(fieldName).sendKeys(data[0]);
        driver.findElement(fieldSurname).sendKeys(data[1]);
        driver.findElement(fieldAddress).sendKeys(data[2]);
        driver.findElement(fieldPhone).sendKeys(data[3]);
        driver.findElement(fieldMetro).click();
        driver.findElement(By.xpath(String.format("//*[text()='%s']", data[4]))).click();
        return this;
    }
    // метод нажатия кнопки Далее
    public OrderPageRental clickNext() {
        driver.findElement(nextBtn).click();
        return new OrderPageRental(driver);
    }

}