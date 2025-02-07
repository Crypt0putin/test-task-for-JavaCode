package api;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Story;
import static io.restassured.RestAssured.given;

public class ReqresTests {
    private final static String URL = "https://reqres.in/";

    @Test
    @Story("Проверка API Reqres")
    @DisplayName("Кейс 1. Проверка успешной регистрации")
    public void checkSuccessRegTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Register register = new Register("eve.holt@reqres.in", "pistol");
        SuccessReg successReg = given()
            .body(register)
            .when()
            .post("api/register")
            .then().log().all()
            .extract().as(SuccessReg.class);
        Assertions.assertEquals(id, successReg.getId());
        Assertions.assertEquals(token, successReg.getToken());
    }


    @Test
    @Story("Проверка API Reqres")
    @DisplayName("Кейс 1. Проверка неуспешной регистрации")
    public void checkUnSuccessRegTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecBadRequest400());
        Register register = new Register("eve.holt@reqres.in", "");
        UnSuccessReg unSuccessReg = given()
            .body(register)
            .when()
            .post("api/register")
            .then().log().all()
            .extract().as(UnSuccessReg.class);
        Assertions.assertEquals("Missing password", unSuccessReg.getError());
    }


    @Test
    @Story("Проверка API Reqres")
    @DisplayName("Кейс 2. Проверка корректности домена email адресов списка пользователей")
    public void checkEmailTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        List<UserData> users = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);    
        Assertions.assertTrue(users.stream().allMatch(x -> x.getEmail().endsWith("@reqres.in")));
    }


    @Test
    @Story("Проверка API Reqres")
    @DisplayName("Кейс 3. Проверка, успешного удаления пользователя")
    public void checkUserDeletionTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecNoContent204());
        given()
            .when()
            .delete("api/users/2")
            .then().log().all();
    }

    @Test
    @Story("Проверка API Reqres")
    @DisplayName("Кейс 4. Проверка успешного обновления данных пользователя")
    public void checkUserDataUpdateSuccessTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        LocalDateTime before = LocalDateTime.now(ZoneOffset.UTC).withNano(0);
        UserData userData = given()
            .when()
            .patch("api/users/2")
            .then().log().all()
            .extract().as(UserData.class);
        
        try {
            Thread.sleep(1000); // Ожидание 1 секунда
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    
        LocalDateTime after = LocalDateTime.now(ZoneOffset.UTC);
        LocalDateTime updatedAt = LocalDateTime.parse(userData.getUpdatedAt(), DateTimeFormatter.ISO_DATE_TIME);
        Assertions.assertTrue(!updatedAt.isBefore(before) && !updatedAt.isAfter(after),
                () -> String.format("Время обновления должно быть между %s и %s, получено %s", before, after, updatedAt));
    }
}




