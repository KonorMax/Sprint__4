import extentions.WebDriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import java.util.ArrayList;
import java.util.List;

public class MainPageTests {
    private WebDriver driver;

    @Before
    public void setup() {
        driver = WebDriverFactory.get();
    }

    @Test
    public void MainPageQuestionTest() {
        //список с ответами
        final List<String> answers = new ArrayList<>() {{
            add("Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
            add("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто " +
                    "сделать несколько заказов — один за другим.");
            add("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени " +
                    "аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в " +
                    "20:30, суточная аренда закончится 9 мая в 20:30.");
            add("Только начиная с завтрашнего дня. Но скоро станем расторопнее.");
            add("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.");
            add("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься" +
                    " без передышек и во сне. Зарядка не понадобится.");
            add("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");
            add("Да, обязательно. Всем самокатов! И Москве, и Московской области.");
        }};

        //открываем главную страницу
        MainPage mainPage = new MainPage(driver);
        mainPage.closeCookies();

        //кликаем по каждому пункту вопроса и сверяем с заготовленными ответами
        for(int i = 0; i< mainPage.getQuestionSize(); i++){
            String questionAnswerVisible = mainPage.clickOnQuestionByIndex(i).getVisibleAnswer();
            Assert.assertEquals(answers.get(i), questionAnswerVisible);
        }
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
