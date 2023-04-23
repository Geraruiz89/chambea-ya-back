package com.example.helloworld.productos;

import com.example.helloworld.chambeaya.model.JwtBody;

public interface InvokeRemoteRestService {
    JwtBody checkJwt(String jwt);
}
