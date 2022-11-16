package tests.api;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class HttpClientTest {
    @Test
    public void sinpleApiTest() throws IOException {
        String restURL = "https://reques.in/";

        //create Object and pass the url
        HttpUriRequest request = new HttpGet(restURL);

        //send the request
        HttpResponse httpResponse = HttpClientBuilder
                .create()
                .build()
                .execute(request);
        System.out.println(request.toString());

        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }
}
