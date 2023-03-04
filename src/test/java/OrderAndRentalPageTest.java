import extentions.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import static org.junit.Assert.assertTrue;


public class OrderAndRentalPageTest {
    private WebDriver driver;
    private String[][] testData;

    @Before
    public void setup() {
        driver = WebDriverFactory.get();

        testData = new String[][] {
                {"Иван", "Иванов", "Пенза", "88005553535", "Сокол", "30.01.2023",
                        "Привет как дела?", "двое суток", "black"},
                {"Петр", "ФПетров", "Курск", "89876543210", "Фили", "28.01.2025",
                        "Что так долго?", "трое суток", "grey"}};
    }

    @Test
    public void testOrderTopButton() {
        boolean isSuccessful = new MainPage(driver).clickOrderTopButton()
                .fillFieldFirst(testData[0])
                .clickNext()
                .fillFieldSecond(testData[0])
                .confirmThatOrderPageLoadIsSuccessful();
        assertTrue("УПС", isSuccessful);
    }

    @Test
    public void testOrderDownButton(){
        boolean isSuccessful = new MainPage(driver).closeCookies()
                .clickOrderDownButton()
                .fillFieldFirst(testData[1])
                .clickNext()
                .fillFieldSecond(testData[1])
                .confirmThatOrderPageLoadIsSuccessful();
        assertTrue("УПС", isSuccessful);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
