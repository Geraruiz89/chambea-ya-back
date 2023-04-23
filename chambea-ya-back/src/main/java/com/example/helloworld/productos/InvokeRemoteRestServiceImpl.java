package com.example.helloworld.productos;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.helloworld.chambeaya.model.JwtBody;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Primary
@Service("invokeRestService")
@JsonIgnoreProperties(ignoreUnknown = true)

public class InvokeRemoteRestServiceImpl implements InvokeRemoteRestService {
    private RestTemplate restTemplate;
    
    public InvokeRemoteRestServiceImpl(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }
    
    @Override
    public JwtBody checkJwt(String jwt) {
        String url = "https://access.qbits.mx/api/verify-jwt/" + jwt;
        return restTemplate.getForObject(url, JwtBody.class);
    }
}
