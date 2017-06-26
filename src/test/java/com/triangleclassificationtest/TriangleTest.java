package com.triangleclassificationtest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class TriangleTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void TriangleLessThanZeroSides() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Side lengths could not be equal or less than zero!");
        new Triangle(BigDecimal.ONE.negate(), BigDecimal.ONE, BigDecimal.ONE);
    }

    @Test
    public void TriangleInequalityViolation() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Inequality theorem violated!");
        new Triangle(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.TEN);
    }

    @Test
    public void isEquilateral() throws Exception {
        assertTrue(new Triangle(BigDecimal.TEN, BigDecimal.TEN, BigDecimal.TEN).isEquilateral());
        assertFalse(new Triangle(BigDecimal.valueOf(3L), BigDecimal.valueOf(6L), BigDecimal.valueOf(8L)).isEquilateral());
    }

    @Test
    public void isIsosceles() throws Exception {
        assertTrue(new Triangle(BigDecimal.TEN, BigDecimal.ONE, BigDecimal.TEN).isIsosceles());
        assertFalse(new Triangle(BigDecimal.valueOf(3L), BigDecimal.valueOf(6L), BigDecimal.valueOf(8L)).isIsosceles());
    }

    @Test
    public void isScalene() throws Exception {
        assertTrue(new Triangle(BigDecimal.valueOf(3L), BigDecimal.valueOf(6L), BigDecimal.valueOf(8L)).isScalene());
        assertFalse(new Triangle(BigDecimal.TEN, BigDecimal.TEN, BigDecimal.TEN).isScalene());
    }
}
