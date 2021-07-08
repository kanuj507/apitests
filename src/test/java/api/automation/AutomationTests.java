package api.automation;

import com.api.util.Constants;
import com.api.util.TestBase;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;

public class AutomationTests extends TestBase {

    @Test
    public void VerifyGetApi() throws SQLException {

        Response response = restUtil.getByUrl(baseURI + Constants.POSTS);
        response.then().assertThat().statusCode(HttpStatus.SC_OK);
        response.then().assertThat().body("size()", equalTo(100));

        }

    @Test
    public void VerifySingleGetApi() throws SQLException {

        Response response = restUtil.getByUrl(baseURI + String.format(Constants.SINGLE_POSTS, 1));
        response.then().assertThat().statusCode(HttpStatus.SC_OK);
        response.then().assertThat().body("id", equalTo(1));
        response.then().assertThat().body("userId", equalTo(1));
    }

    @Test
    public void VerifyInvalidGetApi() throws SQLException {

        Response response = restUtil.getByUrl(baseURI + Constants.INVALID_POSTS);
        response.then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND);

    }

    @Test
    public void VerifyPostApi() throws SQLException {

        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("title", "foo");
        requestMap.put("body", "bar");
        requestMap.put("userId", 1);
        Response response = restUtil.postByUrl(baseURI + Constants.POSTS, requestMap);
        response.then().assertThat().statusCode(HttpStatus.SC_CREATED);
        response.then().assertThat().body("id", equalTo(101));

        // response = restUtil.getByUrl("https://jsonplaceholder.typicode.com" + "/posts/" + 101);
        // response.then().assertThat().statusCode(200);

    }

    @Test
    public void VerifyPutApi() throws SQLException {

        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("title", "abc");
        requestMap.put("body", "xyz");
        requestMap.put("userId", 1);
        requestMap.put("id", 1);
        Response response = restUtil.putByUrl(baseURI + String.format(Constants.SINGLE_POSTS, 1), requestMap);
        response.then().assertThat().statusCode(HttpStatus.SC_OK);
        response.then().assertThat().body("id", equalTo(1));
 //     Get seems to returning the old value the Put is not presisting in the jsonplaceholder DB        
//        response = restUtil.getByUrl("https://jsonplaceholder.typicode.com" + "/posts/" + 1);
//        response.then().assertThat().statusCode(200);
//        response.then().assertThat().body("title", equalTo("abc"));
    }

    @Test
    public void VerifyDeleteApi() throws SQLException {

        Response response = restUtil.deleteByUrl(baseURI + String.format(Constants.SINGLE_POSTS, 1));
        response.then().assertThat().statusCode(HttpStatus.SC_OK);

    }
}
