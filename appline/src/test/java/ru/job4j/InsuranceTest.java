package ru.job4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;

public class InsuranceTest {
    WebDriver driver;
    String baseUrl;

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        baseUrl = "http://www.sberbank.ru/ru/person";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    @Test
    public void testAutotest() {
       // закрываем всплывающее окно предупреждение про куки
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        WebElement closeBtn = driver.findElement(By.xpath("//*[text()='Закрыть']"));
        wait.until(ExpectedConditions.visibilityOf(closeBtn)).click();

        //2.       Нажать на – Страхование
       driver.findElement(By.xpath("//*[@id=\"main-page\"]/div[1]/div/div[4]/nav/div/ul/li[9]/a[1]")).click();
       //3.       Нажать на – Перейти в каталог
      // driver.findElement(By.xpath("//*[@id=\"main-page\"]/div[1]/div/div[4]/nav/div/ul/li[9]/div/div[1]/ul/li[9]/a")).click();
        //3 Нажать на Путешествия
        driver.findElement(By.xpath("//A[@class='kitt-top-menu__link kitt-top-menu__link_second'][text()='Путешествия']")).click();


       //4.       Нажать на - Страхование путешественников
       //driver.findElement(By.xpath("//*[contains(text(),'Страхование для путешественников')]")).click();
       //5.       Проверить наличие на странице заголовка – Страхование путешественников
       assertEquals("Страхование путешественников",
                driver.findElement(By.xpath("//*[contains(text(),'Страхование путешественников')]")).getText());
        //6.       Нажать на – Оформить Онлайн
        driver.findElement(By.xpath("//*[contains(text(),'Оформить онлайн')]")).click();


        //7.       На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная
        // по умолчанию выбрана системой
        //8.       Нажать Оформить
        WebElement sendBtn = driver.findElement(By.xpath("//*[@class='btn btn-primary btn-large'][text()='Оформить']"));
        wait.until(ExpectedConditions.visibilityOf(sendBtn)).click();

        WebElement title = driver.findElement(By.xpath("//*[contains(text(),'! Полис покрывает риски, связанные с лечением коронавируса «COVID-19»')]"));
        wait.until(ExpectedConditions.visibilityOf(title));
        assertEquals("! Полис покрывает риски, связанные с лечением коронавируса «COVID-19»",
                title.getText());

        // 9.       На вкладке Оформление заполнить поля:
        //Фамилию и Имя, Дату рождения застрахованных
        //Данные страхователя: Фамилия, Имя, Отчество, Дата рождения, Пол
        // Паспортные данные
        fillField(By.xpath("//INPUT[@id='surname_vzr_ins_0']"), "Иванов"); //Фамилию
        fillField(By.xpath("//INPUT[@id='name_vzr_ins_0']"), "Иван"); //Имя
        fillField(By.xpath("//INPUT[@id='person_lastName']"), "Петров"); //Данные страхователя: Фамилия
        fillField(By.xpath("//INPUT[@id='person_firstName']"), "Петр"); //Данные страхователя: Имя
        fillField(By.xpath("//INPUT[@id='person_middleName']"), "Петрович"); //Данные страхователя: Отчество

         //Данные страхователя: Пол
        //driver.findElement(By.xpath("//LABEL[@class='btn ng-valid active ng-touched ng-dirty'][text()='Мужской']")).click();
        // Паспортные данные
        fillField(By.xpath("//INPUT[@id='passportSeries']"), "1111"); //серия
        fillField(By.xpath("//INPUT[@id='passportNumber']"), "222222"); //номер
        fillField(By.xpath("//INPUT[@id='documentIssue']"), "ОВД Лианозово"); //кем выдан

        fillField(By.xpath("//INPUT[@id='birthDate_vzr_ins_0']"), "02.06.1977"); //Дату рождения застрахованных 02.06.2021
        fillField(By.xpath("//INPUT[@id='person_birthDate']"), "03.06.2003"); //Данные страхователя: Дата рождения
        fillField(By.xpath("//INPUT[@id='documentDate']"), "03.06.2018"); //дата выдачи

        //проверим заполнение полей
        assertEquals("Иванов", driver.findElement(By.xpath("//INPUT[@id='surname_vzr_ins_0']")).getAttribute("value"));
        assertEquals("Иван", driver.findElement(By.xpath("//INPUT[@id='name_vzr_ins_0']")).getAttribute("value"));
        assertEquals("02.06.1977", driver.findElement(By.xpath("//INPUT[@id='birthDate_vzr_ins_0']")).getAttribute("value"));

        assertEquals("1111", driver.findElement(By.xpath("//INPUT[@id='passportSeries']")).getAttribute("value"));
        assertEquals("222222", driver.findElement(By.xpath("//INPUT[@id='passportNumber']")).getAttribute("value"));
        assertEquals("03.06.2018", driver.findElement(By.xpath("//INPUT[@id='documentDate']")).getAttribute("value"));
        assertEquals("ОВД Лианозово", driver.findElement(By.xpath("//INPUT[@id='documentIssue']")).getAttribute("value"));


        driver.findElement(By.xpath("//*[contains(@class,'btn-primary')]")).click();

        String strAlert = driver.findElement(By.xpath("(//SPAN[@class='invalid-validate form-control__message'][text()='Поле не заполнено.'])[1]")).getText();
        System.out.println(strAlert);

        assertEquals("Поле не заполнено.", driver.findElement(By.xpath("(//SPAN[@class='invalid-validate form-control__message'][text()='Поле не заполнено.'])[1]")).getText());
    }

    public void  fillField(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    @After
    public void afterTest() {
        driver.quit();
    }

}
