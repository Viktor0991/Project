package ru.eldorado;

import io.qameta.allure.Step;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;


public class FirstTest {
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vvershanskiy\\Downloads\\chromedriver_1.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.get("https://www.eldorado.ru/");
        Assert.assertEquals(driver.getTitle(), "Эльдорадо - интернет-магазин электроники, цифровой и бытовой техники, выгодные цены, доставка по Москве и регионам.");
    }

    @Test
    public void sait() throws InterruptedException, AWTException {
        searchIphone();
        addBasket();
        addAccessory();
        checkPriceLast();
        pleaseContinue();
    }



        @AfterClass
    public static void classDown() {
        //driver.quit();
    }
    @Step("Поиск товара по значению iphonexs, и убираем всплывающее окно")
    private void searchIphone()throws InterruptedException, AWTException{
        driver.findElement(By.cssSelector("input[type = 'text'")).sendKeys("iphonexs");
        driver.findElement(By.cssSelector("input[type = 'text'")).sendKeys(Keys.ENTER);
        Thread.sleep(10000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
    }
    @Step("Добавление в корзину и переход в мою корзину")
    private void addBasket() throws InterruptedException{
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[10]/div[1]/div/div[5]/div/div[3]/div[2]/div[1]/div[2]/div[1]/noindex/a/span/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[10]/div[1]/div/div[5]/div/div[3]/div[2]/div[4]/div[2]/div[1]/noindex/a")).click();
        driver.findElement(By.xpath("/html/body/header/div[2]/div/div[2]/noindex[2]/div/a/span[2]")).click();
        Thread.sleep(2000);
    }
    @Step("Добавляем нужные аксессуары")
    private void addAccessory()throws InterruptedException{
        driver.findElement(By.xpath("//a[@class=\"servicesItem q-btn-to-cart add_accessories\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[14]/div/div/div/div[1]/form/div[4]/div/div[1]/span[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@class=\"servicesItem q-btn-to-cart add_services\"])[1]")).click();
        Thread.sleep(2000);
    }
    @Step("Проверяем не равна ли сумма 0, из за непредвиденного сбоя программы")
    private void checkPriceLast(){
        WebElement element = driver.findElement(By.xpath("(//span[@class=\"rxval\"])[last()]"));
        if (element.equals("0 р")) {
            System.out.println("Programm work incorrect!!!");
        }
    }
    @Step("Оформляем кредит и продолжаем покупку.")
    private void pleaseContinue() throws InterruptedException{
        driver.findElement(By.xpath("/html/body/div[14]/div/div/div/div[1]/form/div[5]/div[2]/div[1]/div[2]/div/div[7]/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[14]/div/div/div/div[1]/form/div[5]/div[2]/div[1]/div[2]/div/a/span")).click();
    }
}
