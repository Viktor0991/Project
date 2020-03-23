package ru.eldorado;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class FirstTest {
   protected WebDriver driver;

    @Test
    public void mainMethodTest() throws InterruptedException, AWTException {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        searchIphone();
        addBasket();
        addAccessory();
        checkPriceLast();
        pleaseContinue();

    }

    @Step("Поиск товара по значению iphonexs, и убираем всплывающее окно")
    private void searchIphone() throws InterruptedException, AWTException {
        driver.findElement(By.cssSelector("input[type = 'text'")).sendKeys("iphonexs");
        driver.findElement(By.cssSelector("input[type = 'text'")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
    }
    @Step("Добавление в корзину и переход в мою корзину")
    private void addBasket() throws InterruptedException{
        driver.findElement(By.xpath("/html/body/div[11]/div[1]/div/div[5]/div/div[3]/div[2]/div[1]/div[2]/div[1]/noindex/a/span/span")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[11]/div[1]/div/div[5]/div/div[3]/div[2]/div[6]/div[2]/div[1]/noindex/a/span/span")).click();
        driver.findElement(By.xpath("/html/body/header/div[2]/div/div[2]/noindex[2]/div/a/span[2]")).click();
    }
    @Step("Добавляем нужные аксессуары")
    private void addAccessory() {
        driver.findElement(By.xpath("//a[@class=\"servicesItem q-btn-to-cart add_accessories\"]")).click();
        driver.findElement(By.xpath("/html/body/div[14]/div/div/div/div[1]/form/div[4]/div/div[1]/span[2]")).click();
        driver.findElement(By.xpath("(//a[@class=\"servicesItem q-btn-to-cart add_services\"])[1]")).click();
    }
    @Step("Проверяем не равна ли сумма 0, из за непредвиденного сбоя программы")
    private void checkPriceLast(){
        WebElement element = driver.findElement(By.xpath("(//span[@class=\"rxval\"])[last()]"));
        if (element.equals("0 р")) {
            System.out.println("Programm work incorrect!!!");
        }
    }
    @Step("Оформляем кредит и продолжаем покупку.")
    private void pleaseContinue() {
        driver.findElement(By.xpath("/html/body/div[14]/div/div/div/div[1]/form/div[5]/div[2]/div[1]/div[2]/div/div[7]/span")).click();
        driver.findElement(By.xpath("/html/body/div[14]/div/div/div/div[1]/form/div[5]/div[2]/div[1]/div[2]/div/a/span")).click();
    }
}