package ru.eldorado;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import static com.sun.jna.Platform.*;
import static org.testng.Assert.assertEquals;

public class ClassPeriod extends FirstTest {


    @BeforeClass
    public void openWebsite() {

        if (isWindows()) {
            System.out.println("Your used is Windows");
            System.setProperty("webdriver.chrome.driver", "chromedriverDesktop.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
            driver.get("https://www.eldorado.ru/");
            assertEquals(driver.getTitle(), "Эльдорадо - интернет-магазин электроники, цифровой и бытовой техники, выгодные цены, доставка по Москве и регионам.");

        } else if (isMac()) {
            System.out.println("Your used is MacOc");
            System.setProperty("webdriver.chrome.driver", "chromedriverMac");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
            driver.get("https://www.eldorado.ru/");
            assertEquals(driver.getTitle(), "Эльдорадо - интернет-магазин электроники, цифровой и бытовой техники, выгодные цены, доставка по Москве и регионам.");
        } else if (isLinux()) {
            System.out.println("Your used is Linux");
            System.setProperty("webdriver.chrome.driver", "chromedriverLinux");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
            driver.get("https://www.eldorado.ru/");
            assertEquals(driver.getTitle(), "Эльдорадо - интернет-магазин электроники, цифровой и бытовой техники, выгодные цены, доставка по Москве и регионам.");
        }

    }

    @AfterClass
    public void closeDriver() {
        driver.close();
        driver.quit();
    }
}
