package api_test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//import org.testng.Assert;
//import org.testng.annotations.Test;

import api_data_objects.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api_base_classes.InternalBase;
import api_base_classes.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

public class api_firstTest {

        TestBase testBase;
        String serviceURL;
        String apiURL;
        String url;
        ObjectMapper mapper = new ObjectMapper();
        InternalBase internalBase = new InternalBase();

        @Test
        public void testSamplePostRequest() throws IOException {
            PostSampleResponse postResponseFinal;
            PostSampleRequest postSampleRequest = new PostSampleRequest("morpheus", "leader");
            Response postSampleResponse = structuredPostRequestResponse(postSampleRequest);
            postResponseFinal = mapper.readValue(postSampleResponse.getBody().asInputStream(), PostSampleResponse.class);

            System.out.println("==1 output:- " + postSampleResponse.getStatusCode());
            System.out.println("==2 output:- " + postResponseFinal.getName());
            System.out.println("==3 output:- " + postResponseFinal.getId());
            System.out.println("==4 output:- " + postResponseFinal.getJob());
            System.out.println("==5 output:- " + postResponseFinal.getCreatedAt());
            Assert.assertEquals(postSampleResponse.getStatusCode(), 201);
            Assert.assertEquals(postResponseFinal.getName(), "morpheus");
            Assert.assertEquals(postResponseFinal.getJob(), "leader");

        }

    private Response structuredPostRequestResponse(PostSampleRequest postSampleRequest) throws JsonProcessingException {
            InternalBase internalBase = new InternalBase();
            String sampleRequestJSON = mapper.writeValueAsString(postSampleRequest);
            RequestSpecification given = RestAssured.given();
            given.header("Content-Type", "application/json");
            given.header("Accept", "application/json");
            given.body(sampleRequestJSON);
            Response createResponse = given.post(internalBase.url);
            return createResponse;
        }
}
