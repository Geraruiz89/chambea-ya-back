package com.example.helloworld.productos;

import java.util.List;

public interface LoginService {
    String login(String usuario, String password);
    List<String> cambia(String tokenDado, String nuevaPassword);
}
