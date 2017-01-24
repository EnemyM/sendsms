package com.sv.sendsms.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sv.sendsms.model.ResponseEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by anton
 */

public class HttpInvoke<T> {

    private static final Logger logger = LoggerFactory.getLogger(HttpInvoke.class);

    private HttpClient client;
    private HttpPost httpPost;


    public ResponseEntity httpPost(T body, String url) throws IOException {

        client = HttpClientBuilder.create().build();
        httpPost = new HttpPost(url);

        // create json body

        String s = convertToJson(body);
        logger.info("Converted body = " + s);
        httpPost.setEntity(new StringEntity(s, ContentType.APPLICATION_JSON));

        // perform http method

        HttpResponse response = client.execute(httpPost);
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        return new ResponseEntity(response.getStatusLine().getStatusCode(), String.valueOf(result));
    }

    private String convertToJson(T object) throws JsonProcessingException {
        logger.info("Converting object = " + object);
        return new ObjectMapper().writeValueAsString(object);
    }
}
