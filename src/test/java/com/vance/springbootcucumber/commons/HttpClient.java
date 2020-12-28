package com.vance.springbootcucumber.commons;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class HttpClient {

    private final String SERVER_URL = "http://localhost";
    private final String AREQ_ENDPOINT = "/authentication";

    @LocalServerPort
    private int port;
    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private ObjectMapper objectMapper;


    private String authenticationEndpoint() {
        return SERVER_URL + ":" + port + AREQ_ENDPOINT;
    }

    public Map doAReq(Map aReq) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map> request = new HttpEntity<>(aReq, headers);

        return restTemplate.postForObject(authenticationEndpoint(), request, Map.class);
    }

}
