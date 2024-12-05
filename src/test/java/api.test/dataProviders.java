package api.test;

import api.endpoints.UserEndpoint;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviders {

    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
    public  void testPostUser(String userID, String userName, String firstName, String lastName, String userEmail, String pwd, String phone){
    User userpayload = new User();
    userpayload.getId(String.valueOf(Integer.parseInt(userID)));
    userpayload.setUsername(userName);
    userpayload.setFirstname(firstName);
    userpayload.setLastname(lastName);
    userpayload.setEmail(userEmail);
    userpayload.setPassword(pwd);
    userpayload.setPhone(phone);

    Response response = UserEndpoint.createUser(userpayload);
    Assert.assertEquals(response.getStatusCode(),200);
    }


    @Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
    public  void testDeleteUser(String userName){
        Response response = UserEndpoint.delete_User(userName);
        Assert.assertEquals(response.getStatusCode(),200);
    }

}
