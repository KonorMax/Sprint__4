package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static config.WebDriverConfig.WAIT_SECONDS_TIMEOUT;

// Вторая страница заказа самоката
public class OrderPageRental {

    private final WebDriver driver;

    // локатор кнопки выбора дня доставки
    private final By fieldChoiceDay = By.xpath("//*[@placeholder='* Когда привезти самокат']");

    // локатор кнопки выбора дня доставки
    private final By fieldRentalPeriod = By.className("Dropdown-root");

    // локатор кнопки выбора комментарий
    private final By fieldCommentForCourier = By.xpath(".//*[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");

    // локатор кнопки Заказа
    private final By orderBtn = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // локатор формы окончания заказа
    private final By formConfirm = By.className( "Order_Modal__YZ-d3");

    public OrderPageRental(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_SECONDS_TIMEOUT));
    }
    // метод заполнения формы вторая страница
    public OrderPageRental fillFieldSecond(String[] testData){
        driver.findElement(fieldChoiceDay).sendKeys(testData[5] + Keys.ENTER);
        driver.findElement(fieldRentalPeriod).click();
        driver.findElement(By.xpath(String.format("//div[text()='%s']", testData[7]))).click();
        driver.findElement(By.xpath(String.format("//label[@for='%s']", testData[8]))).click();
        driver.findElement(fieldCommentForCourier).sendKeys(testData[6]);
        driver.findElement(orderBtn).click();
        return this;
    }

    // метод проверки видимости формы, которая появляется при финальном подверждении заказа
    public boolean confirmThatOrderPageLoadIsSuccessful(){
        return  driver.findElement(formConfirm).isDisplayed();
    }
}

