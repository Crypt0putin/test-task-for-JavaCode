package ui;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.SelenideElement;

public class MainPage {
    private final SelenideElement signUpButton = $(By.xpath("//a[@id='signin2']"));
    private final SelenideElement loginButton = $(By.xpath("//*[@id=\"login2\"]"));

    private final SelenideElement signUpUsernameField = $(By.xpath("//*[@id=\"sign-username\"]"));
    private final SelenideElement signUpPasswordField = $(By.xpath("//*[@id=\"sign-password\"]"));
    private final SelenideElement loginUsernameField = $(By.xpath("//*[@id=\"loginusername\"]"));
    private final SelenideElement loginPasswordField = $(By.xpath("//*[@id=\"loginpassword\"]"));

    private final SelenideElement modalSignUpButton = $(By.xpath("//button[@onclick='register()']"));
    private final SelenideElement modalLogInButton = $(By.xpath("//button[@onclick='logIn()']"));

    private final SelenideElement phonesCategory = $(By.xpath("//a[@onclick=\"byCat('phone')\"]"));
    private final SelenideElement laptopsCategory = $(By.xpath("//a[@onclick=\"byCat('notebook')\"]"));
    private final SelenideElement monitorsCategory = $(By.xpath("//a[@onclick=\"byCat('monitor')\"]"));

    private final SelenideElement nexusPhoneItem = $(By.xpath("//a[@href='prod.html?idp_=3']"));
    private final SelenideElement macbookItem = $(By.xpath("//a[@href='prod.html?idp_=11']"));
    private final SelenideElement asusMonitorItem = $(By.xpath("//a[@href='prod.html?idp_=14']"));

    private final SelenideElement cart = $(By.xpath("//a[@id='cartur']"));
    private final SelenideElement addToCartButton = $(By.xpath("//a[contains(@onclick, 'addToCart(')]"));
    private final SelenideElement placeOrderButton = $(By.xpath("//button[@data-target='#orderModal']"));

    private final SelenideElement placeOrderNameInput = $(By.xpath("//input[@id='name']"));
    private final SelenideElement placeOrderCountryInput = $(By.xpath("//input[@id='country']"));
    private final SelenideElement placeOrderCityInput = $(By.xpath("//input[@id='city']"));
    private final SelenideElement placeOrderCardNumberInput = $(By.xpath("//input[@id='card']"));
    private final SelenideElement placeOrderMonthInput = $(By.xpath("//input[@id='month']"));
    private final SelenideElement placeOrderYearInput = $(By.xpath("//input[@id='year']"));
    private final SelenideElement purchaseButton = $(By.xpath("//button[@onclick='purchaseOrder()']"));


    
    public void signUpClick() {
        signUpButton.click();
    }

    public void logInClick() {
        loginButton.click();
    }

    public void modalSignUpButton() {
        modalSignUpButton.click();
    }

    public void modalLogInButtonClick() {
        modalLogInButton.click();
    }
    

    public void enterSignUpUsername(String username) {
        signUpUsernameField.setValue(username);
    }
    
    public void enterSignUpPassword(String password) {
        signUpPasswordField.setValue(password);
    }

    public void enterLogInUsername(String username) {
        loginUsernameField.setValue(username);
    }
    
    public void enterLogInPassword(String password) {
        loginPasswordField.setValue(password);
    }

    public void phonesCategoryClick() {
        phonesCategory.click();
    }

    public void laptopsCategoryClick() {
        laptopsCategory.click();
    }

    public void monitorsCategoryClick() {
        monitorsCategory.click();
    }

    public void nexusPhoneItemClick() {
        nexusPhoneItem.click();
    }

    public void macbookItemClick() {
        macbookItem.click();
    }

    public void asusMonitorItemClick() {
        asusMonitorItem.click();
    }

    public void addToCartButtonClick() {
        addToCartButton.click();
    }

    public void cartClick() {
        cart.click();
    }

    public void placeOrderButtonClick() {
        placeOrderButton.click();
    }

    public void purchaseButtonClick() {
        purchaseButton.click();
    }

    public void enterPlaceOrderName(String username) {
        placeOrderNameInput.setValue(username);
    }

    public void enterPlaceOrderCountry(String country) {
        placeOrderCountryInput.setValue(country);
    }

    public void enterPlaceOrderCity(String city) {
        placeOrderCityInput.setValue(city);
    }

    public void enterPlaceOrderCardNumber(String cardNumber) {
        placeOrderCardNumberInput.setValue(cardNumber);
    }

    public void enterPlaceOrderMonthInput(int month) {
        placeOrderMonthInput.setValue(String.valueOf(month));
    }
    
    public void enterPlaceOrderYearInput(int year) {
        placeOrderYearInput.setValue(String.valueOf(year));
    }
}
