package api;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class Specifications {
    public static io.restassured.specification.RequestSpecification requestSpec(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification responseSpecOK200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static ResponseSpecification responseSpecNoContent204() {
        return new ResponseSpecBuilder()
                .expectStatusCode(204)
                .build();
    }

    public static ResponseSpecification responseSpecBadRequest400() {
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .build();
    }

    public static void installSpecification(io.restassured.specification.RequestSpecification request, ResponseSpecification response) {
        io.restassured.RestAssured.requestSpecification = request;
        io.restassured.RestAssured.responseSpecification = response;
    }
}
