package com.triangleclassificationtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * Main class of a triangle classification application.
 */
public class Main {

    /**
     * Main method. It either reads triangle side lengths from arguments
     * or interacts with user to create triangles. Triangles then tested
     * to determine its type.
     *
     * @param args application startup arguments.
     */
    @SuppressWarnings("checkstyle:magicnumber")
    public static void main(String[] args) {

        if (args.length != 0) {
            //headless execution.
            if (args.length != 3) {
                System.out.println("Triangle should have three sides!");
                return;
            }

            Triangle triangle;
            try {
                triangle = constructTriangle(
                        new BigDecimal(args[0]),
                        new BigDecimal(args[1]),
                        new BigDecimal(args[2])
                );
            } catch (NumberFormatException e) {
                System.out.println("Wrong number format.\n");
                return;
            }

            if (triangle != null) {
                testTriangle(triangle);
            }

        } else {
            //interactive execution.
            String userResponse = "y";
            while (!"n".equals(userResponse)) {

                Triangle triangle = null;
                while (triangle == null) {
                    triangle = constructTriangleInteractive();
                }

                testTriangle(triangle);

                System.out.println("Do you want to continue? (y/n)");
                userResponse = readLine();
            }
        }
    }

    private static Triangle constructTriangleInteractive() {

        try {
            System.out.println("Enter the length of a side A:");
            BigDecimal sideA = new BigDecimal(readLine());

            System.out.println("Enter the length of a side B:");
            BigDecimal sideB = new BigDecimal(readLine());

            System.out.println("Enter the length of a side C:");
            BigDecimal sideC = new BigDecimal(readLine());

            return constructTriangle(sideA, sideB, sideC);
        } catch (NumberFormatException e) {
            System.out.println("Wrong number format\n");
            return null;
        }
    }

    private static Triangle constructTriangle(BigDecimal sideA, BigDecimal sideB, BigDecimal sideC) {
        try {
            return new Triangle(sideA, sideB, sideC);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static void testTriangle(Triangle triangle) {
        if (triangle.isEquilateral()) {
            System.out.println("\nThis triangle is equilateral.\n");
        }
        if (triangle.isIsosceles()) {
            System.out.println("\nThis triangle is isosceles.\n");
        }
        if (triangle.isScalene()) {
            System.out.println("\nThis triangle is scalene.\n");
        }
    }

    private static String readLine() {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        String inputString = null;
        try {
            inputString = bufferRead.readLine();
        } catch (IOException e) {
            System.out.println("IO exception!");
            System.exit(-1);
        }
        return inputString;
    }
}
