package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserEndpoint {

    public static Response createUser(User payload){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.post_URL);
        return response;
    }

    public static Response read_User(String userName){
        Response response = given()
                .pathParams("username", userName)
                .when()
                .get(Routes.get_URL);
        return response;
    }

    public static Response update_User(User payload, String userName){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParams("username", userName)
                .body(payload)
                .when()
                .put(Routes.update_URL);
        return response;
    }

    public static Response delete_User(String userName){
        Response response = given()
                .pathParams("username", userName)
                .when()
                .delete(Routes.delete_URL);
        return response;
    }
}
