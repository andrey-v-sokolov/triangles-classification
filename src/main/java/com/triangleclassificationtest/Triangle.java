package com.triangleclassificationtest;

import java.math.BigDecimal;

/**
 * Triangle class represents a triangle by its side lengths.
 */
public class Triangle {

    private BigDecimal sideA, sideB, sideC;

    /**
     * Create new triangle. Throws exception if triangle could not be formed.
     *
     * @param sideA Side A length
     * @param sideB Side B length
     * @param sideC Side C length
     * @throws IllegalArgumentException Thrown when either at least one side length equal or less than zero,
     *                                  or triangle inequality theorem violated
     */
    public Triangle(BigDecimal sideA, BigDecimal sideB, BigDecimal sideC) throws IllegalArgumentException {

        if (sideA.compareTo(BigDecimal.ZERO) <= 0
                || sideB.compareTo(BigDecimal.ZERO) <= 0
                || sideC.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Side lengths could not be equal or less than zero!");
        }

        //Triangle inequality theorem.
        if (sideA.add(sideB).compareTo(sideC) <= 0
                || sideB.add(sideC).compareTo(sideA) <= 0
                || sideC.add(sideA).compareTo(sideB) <= 0) {
            throw new IllegalArgumentException("Inequality theorem violated! Provided sides could not form a triangle!");
        }

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    /**
     * Test if triangle is equilateral.
     *
     * @return whether triangle equilateral
     */
    public Boolean isEquilateral() {
        return sideA.equals(sideB) && sideA.equals(sideC);
    }

    /**
     * Test if triangle is isosceles.
     *
     * @return whether triangle isosceles
     */
    public Boolean isIsosceles() {
        return (sideA.equals(sideB) && !sideA.equals(sideC))
                || (sideA.equals(sideC) && !sideA.equals(sideB))
                || (sideB.equals(sideC) && !sideB.equals(sideA));
    }

    /**
     * Test if triangle is scalene.
     *
     * @return whether triangle scalene
     */
    public Boolean isScalene() {
        return !sideA.equals(sideB)
                && !sideA.equals(sideC)
                && !sideB.equals(sideC);
    }

    public BigDecimal getSideA() {
        return sideA;
    }

    public BigDecimal getSideB() {
        return sideB;
    }

    public BigDecimal getSideC() {
        return sideC;
    }
}
