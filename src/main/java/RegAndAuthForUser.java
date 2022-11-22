import io.qameta.allure.Step;
import io.restassured.response.Response;
import model.CreateTheUserRequest;
import model.UserAuthRequest;

import static io.restassured.RestAssured.given;

public class RegAndAuthForUser {
    String baseUri = "http://stellarburgers.nomoreparties.site/api/";

    @Step("Регистрация пользователя")
    public Response regNewUser(CreateTheUserRequest createTheUserRequest) {
        Response response =given()
                .header("Content-type", "application/json")
                .baseUri(baseUri)
                .body(createTheUserRequest)
                .post("auth/register");
        response.then();
        return  response;
    }

    @Step("Авторизация пользователя")
    public Response authUser(UserAuthRequest userAuthRequest) {
        Response response =  given()
                .header("Content-type", "application/json")
                .baseUri(baseUri)
                .body(userAuthRequest)
                .post("auth/login");
        response.then();
        return  response;
    }

    @Step("Получение access token успешно зарегистрированного пользователя")
    public String getAccessToken(UserAuthRequest userAuthRequest) {
        return authUser(userAuthRequest)
                .then()
                .extract()
                .path("accessToken");
    }

    @Step("Запрос на удаление пользователя")
    public Response removeForUser(String accessToken) {
        Response response = given()
                .header("Authorization", accessToken)
                .baseUri(baseUri)
                .when()
                .delete("auth/user");
        return response;
    }
}
