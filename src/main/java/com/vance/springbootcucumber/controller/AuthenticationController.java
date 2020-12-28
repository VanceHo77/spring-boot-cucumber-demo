package com.vance.springbootcucumber.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vance.springbootcucumber.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/authentication")
public final class AuthenticationController {

    private AuthenticationService authenticationService;

    private final ObjectMapper objectMapper;

    @PostMapping
    public String frictionless(@RequestBody String aReqJsonStr) throws IOException {
        Map aReq = objectMapper.readValue(aReqJsonStr, LinkedHashMap.class);

        Map aRes = authenticationService.doAuthentication(aReq);

        return objectMapper.writeValueAsString(aRes);
    }
}
