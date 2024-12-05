package api.test;

import api.endpoints.UserEndpoint;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class userTest {

    Faker faker;
    User userPayload;

    @BeforeClass
    public void setupData(){
        faker = new Faker();
        userPayload = new User();
        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstname(faker.name().firstName());
        userPayload.setLastname(faker.name().lastName());
        userPayload.setEmail(faker.internet().emailAddress());
        userPayload.setPassword(faker.internet().password(5,10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());
    }

    @Test
    public void testPostUser(){
        Response response = UserEndpoint.createUser(userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test
    public void testRetrieveUser(){
        Response response = UserEndpoint.read_User(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test
    public void testUpdateUser(){
        userPayload.setUsername(faker.name().username());
        Response response = UserEndpoint.update_User(userPayload,this.userPayload.getUsername());
        response.then().log().all();
        System.out.println(this.userPayload.getUsername());
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test
    public void testDeleteUser(){
        Response response = UserEndpoint.delete_User(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

}
