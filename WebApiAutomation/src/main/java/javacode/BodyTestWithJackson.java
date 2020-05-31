package javacode;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static javacode.JavaCode.unmarshallGeneric;

public class BodyTestWithJackson {

    CloseableHttpClient client;
    HttpGet get;
    CloseableHttpResponse response;
    public static final String BASE_ENDPOINT = "https://api.github.com/nonexistingendpoint";

    @BeforeMethod
    public void setup() {
        client = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void closeResources() throws IOException {
        client.close();
        response.close();
    }

    @Test
    public void notFoundMessageIsCorrect() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT);

        response = client.execute(get);

        NotFound notFound = unmarshallGeneric(response, NotFound.class);

        Assert.assertEquals(notFound.getMessage(), "Not Found");

    }

}
