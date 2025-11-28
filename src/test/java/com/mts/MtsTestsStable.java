package com.mts;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class MtsTestsStable {

    private WebDriver driver;
    private final String URL = "https://www.mts.by/";

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void teardown() {
        if (driver != null) driver.quit();
    }

    private void scrollToElement(WebElement el) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
    }

    private void acceptCookiesIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(), 'Принять') or contains(text(), 'Согласен') or contains(text(), 'Agree')]")
            ));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
            System.out.println("[INFO] Попап cookies закрыт через JS-клик");
        } catch (TimeoutException ignored) {
            System.out.println("[INFO] Попап cookies не найден");
        }
    }

    private WebElement findElementFlexible(By... locators) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        for (By locator : locators) {
            try {
                return wait.until(ExpectedConditions.refreshed(
                        ExpectedConditions.visibilityOfElementLocated(locator)
                ));
            } catch (TimeoutException ignored) { }

            List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
            for (WebElement iframe : iframes) {
                driver.switchTo().frame(iframe);
                try {
                    return wait.until(ExpectedConditions.refreshed(
                            ExpectedConditions.visibilityOfElementLocated(locator)
                    ));
                } catch (TimeoutException ignored) {
                } finally {
                    driver.switchTo().defaultContent();
                }
            }
        }

        throw new NoSuchElementException("Элемент не найден ни по одному локатору");
    }

    @Test
    public void testOnlineTopupBlockVisible() {
        driver.get(URL);
        acceptCookiesIfPresent();

        WebElement block = findElementFlexible(
                By.xpath("//*[contains(text(), 'Онлайн пополнение')]"),
                By.xpath("//*[contains(text(), 'Пополнить счет')]"),
                By.xpath("//*[contains(text(),'Онлайн‑пополнение')]")
        );

        scrollToElement(block);
        Assertions.assertTrue(block.isDisplayed(), "Блок онлайн‑пополнения не виден");
    }

    @Test
    public void testPaymentLogosExist() {
        driver.get(URL);
        acceptCookiesIfPresent();

        WebElement visa = findElementFlexible(By.cssSelector("img[src*='visa']"));
        WebElement mastercard = findElementFlexible(By.cssSelector("img[src*='mastercard']"));
        WebElement belkart = findElementFlexible(By.cssSelector("img[src*='belkart']"));
        WebElement mir = findElementFlexible(By.cssSelector("img[src*='mir']"));

        scrollToElement(visa);

        Assertions.assertAll(
                () -> Assertions.assertTrue(visa.isDisplayed(), "Логотип Visa не найден"),
                () -> Assertions.assertTrue(mastercard.isDisplayed(), "Логотип Mastercard не найден"),
                () -> Assertions.assertTrue(belkart.isDisplayed(), "Логотип Belkart не найден"),
                () -> Assertions.assertTrue(mir.isDisplayed(), "Логотип Mir не найден")
        );
    }

    @Test
    public void testMoreInfoLink() {
        driver.get(URL);
        acceptCookiesIfPresent();

        WebElement link = findElementFlexible(By.partialLinkText("Подробнее"));
        scrollToElement(link);
        link.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(d -> d.getCurrentUrl().contains("help") || d.getPageSource().contains("оплата"));

        Assertions.assertTrue(driver.getCurrentUrl().contains("help") || driver.getPageSource().contains("оплата"),
                "URL после клика на «Подробнее» не содержит expected path");
    }

    @Test
    public void testTopupFormCommunicationService() {
        driver.get(URL);
        acceptCookiesIfPresent();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        if (!iframes.isEmpty()) {
            driver.switchTo().frame(iframes.get(0));
        }

        WebElement phoneInput = findElementFlexible(
                By.cssSelector("input[type='tel']"),
                By.cssSelector("input[name*='phone']")
        );
        phoneInput.clear();
        phoneInput.sendKeys("297777777");

        WebElement amountInput = findElementFlexible(
                By.cssSelector("input[name*='amount']"),
                By.cssSelector("input[type='number']")
        );
        amountInput.clear();
        amountInput.sendKeys("1");


        WebElement btn = findElementFlexible(
                By.xpath("//button[contains(text(), 'Продолжить') or contains(text(), 'Пополнить') or contains(text(), 'Оплатить')]")
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
        Assertions.assertTrue(btn.isEnabled(), "Кнопка Продолжить/Оплатить неактивна");

        driver.switchTo().defaultContent();
    }
}