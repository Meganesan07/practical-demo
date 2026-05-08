package com.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class tempconvertTest {
    @Test
    public void testcelsiustoFahrenheit() {
        assertEquals(32.0, tempconvert.celsiustoFahrenheit(0), 0.01);
    }
    @Test
    public void testFahrenheittocelsius() {
        assertEquals(0.0, tempconvert.Fahrenheittocelsius(32), 0.01);
    }
    @Test
    public void testcelsiustoKelvin() {
        assertEquals(273.15, tempconvert.celsiustoKelvin(0), 0.01);
    }
    @Test
    public void testKelvintocelsius() {
        assertEquals(0.0, tempconvert.Kelvintocelsius(273.15), 0.01);
    }
}

