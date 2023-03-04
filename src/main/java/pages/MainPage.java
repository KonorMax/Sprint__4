package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static config.WebDriverConfig.WAIT_SECONDS_TIMEOUT;

// Главная страница
public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // локатор кнопки принятия куки-файлов
    private final By cookieButton = By.id("rcc-confirm-button");

    // локатор кнопки Заказать вверху страницы
    private final By orderTopButton = By.className("Button_Button__ra12g");

    // локатор кнопки Заказать внизу страницы
    private final By orderDownButton = By.className("Home_FinishButton__1_cWm");

    // локаторы всех вопросов
    private final By questionButtons = By.xpath("//*[@class='accordion__heading']");

    private final By visibleAnswer = By.xpath("//*[@class='accordion__panel' and not(@hidden)]");


    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_SECONDS_TIMEOUT));
    }

    // метод получения количество вопросов
    public int getQuestionSize() {
        return driver.findElements(questionButtons).size();
    }

    //метод ждем пока элемент будет кликабельным
    public MainPage clickOnQuestionByIndex(int index) {
        wait.until(ExpectedConditions.elementToBeClickable(questionButtons));
        driver.findElements(questionButtons).get(index).click();
        return this;
    }

    //метод ждем пока ответ станет видим на странице
    public String getVisibleAnswer() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(visibleAnswer));
        return driver.findElement(visibleAnswer).getText();
    }

    //метод ждем пока ответ станет видим на странице
    public MainPage closeCookies() {
        if (driver.findElement(cookieButton).isDisplayed())
            driver.findElement(cookieButton).click();
        return this;
    }
    //метод нажимания на верхнею кнопку Заказать
    public OrderPage clickOrderTopButton(){
        driver.findElement(orderTopButton).click();
        return new OrderPage(driver);
    }
    //метод нажимания нижнюю кнопку Заказать
    public OrderPage clickOrderDownButton(){
        wait.until(ExpectedConditions.elementToBeClickable(orderDownButton));
        driver.findElement(orderDownButton).click();
        return new OrderPage(driver);
    }

}

