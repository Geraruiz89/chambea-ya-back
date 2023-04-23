package com.example.helloworld;

import org.junit.jupiter.api.Test;
import com.example.helloworld.utilerias.Digestion;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SonarGooseTest {
    @Test
    void contextLoads() {
        Digestion dig = new Digestion();
        int res = dig.errorParaDeteccionDeSonar(3, 7);
        assertEquals(10, res);
    }
}

