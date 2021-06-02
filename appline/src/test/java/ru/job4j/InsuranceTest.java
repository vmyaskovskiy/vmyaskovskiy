package ru.job4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;

public class InsuranceTest {
    WebDriver driver;
    String baseUrl;

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        baseUrl = "https://www.rgs.ru/";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    @Test
    public void testAutotest () {
       driver.findElement(By.id("card-2675-20266")).click();
       driver.findElement(By.id("card-2675-20266")).click();
       String str = driver.findElement(By.xpath("/html/body/div[3]/div[3]/h1")).getText();
        System.out.println(str);
        assertEquals("Автомобиль: купить полис онлайн",
                driver.findElement(By.xpath("/html/body/div[3]/div[3]/h1")).getText());

    }
    @After
    public void afterTest() {
        driver.quit();
    }

}
