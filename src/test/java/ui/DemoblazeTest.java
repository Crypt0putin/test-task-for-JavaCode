package ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;

import io.qameta.allure.Story;




public class DemoblazeTest extends BaseTest {

    public  final static String URL = "https://www.demoblaze.com/";


    @Test
    @Story("Проверка сайта demoblaze")
    @DisplayName("Кейс 1. E2E тест оформления заказа")
    public void e2eTest() throws InterruptedException {
        Selenide.open(URL);
        MainPage mainPage = new MainPage();
        mainPage.signUpClick();

        Faker faker = new Faker();
        String username = faker.name().lastName();
        String password = faker.internet().password();
        String country = faker.country().name();
        String city = faker.address().city();
        String creditCard = faker.finance().creditCard();
        int month = faker.number().numberBetween(01, 12);
        int year = faker.number().numberBetween(2023, 2025);

        mainPage.enterSignUpUsername(username);
        mainPage.enterSignUpPassword(password);
        mainPage.modalSignUpButton();

        mainPage.logInClick();
        mainPage.logInClick();
        mainPage.enterLogInUsername(username);
        mainPage.enterLogInPassword(password);
        mainPage.modalLogInButtonClick();

        mainPage.phonesCategoryClick();
        mainPage.nexusPhoneItemClick();
        mainPage.addToCartButtonClick();
        BaseTest.closeAlert();
        Selenide.back();

        Selenide.open(URL);
        mainPage.laptopsCategoryClick();
        mainPage.macbookItemClick();
        mainPage.addToCartButtonClick();
        BaseTest.closeAlert();
        Selenide.back();

        mainPage.monitorsCategoryClick();
        mainPage.asusMonitorItemClick();
        mainPage.addToCartButtonClick();
        BaseTest.closeAlert();
        Selenide.back();

        mainPage.cartClick();
        mainPage.placeOrderButtonClick();
        mainPage.enterPlaceOrderName(username);
        mainPage.enterPlaceOrderCountry(country);
        mainPage.enterPlaceOrderCity(city);
        mainPage.enterPlaceOrderCardNumber(creditCard);
        mainPage.enterPlaceOrderMonthInput(month);
        mainPage.enterPlaceOrderYearInput(year);
        mainPage.purchaseButtonClick();

        compareDate();
        Assertions.assertTrue(currentDate.isEqual(parsedDate), "Даты не совпадают!");
        closeAlert();
    }   
}

