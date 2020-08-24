package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {

    public static RequestSpecification requestSpecification;

    public RequestSpecification requestSpecification() throws IOException {
        if (requestSpecification == null) {
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));

            requestSpecification = new RequestSpecBuilder()
                    .setBaseUri(getGlobalValue("baseUrl"))
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON)
                    .build();

            return requestSpecification;
        }
        return requestSpecification;
    }

    public String getGlobalValue(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("..\\rest\\src\\main\\resources\\global.properties");

        properties.load(fis);

        return properties.getProperty(key);
    }

    public String getJsonPath(Response response, String key) {
        String s = response.asString();
        JsonPath jsonPath = new JsonPath(s);
        return jsonPath.get(key).toString();
    }
}
