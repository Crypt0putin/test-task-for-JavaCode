package ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.switchTo;

import io.github.bonigarcia.wdm.WebDriverManager;


abstract public class BaseTest {
    public LocalDate currentDate;
    public LocalDate parsedDate;
    public void setUp() {
        WebDriverManager.chromedriver();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.holdBrowserOpen = true;
        
    }

    @BeforeEach
    public void setUpDriver() {
        setUp();
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    public static void closeAlert() throws InterruptedException {
        switchTo().alert().accept();
        actions().sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);
        actions().sendKeys(Keys.ESCAPE).perform();
        Thread.sleep(1000);
        Selenide.back();
    }

    public void compareDate() {
        String dateText = Selenide.$(By.xpath("p.lead.text-muted")).getText();
        String extractedDate = dateText.split("Date: ")[1].trim();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate parsedDate = LocalDate.parse(extractedDate, formatter);
        LocalDate currentDate = LocalDate.now();
    }
}