package com.nixsolutions.laba1.task1;

public class Main {
    public static void main(String[] args) {
        double[][] A = {
                { 33.1, 34.2, 12.3 },
                { 33.4, 19.5, 10.6 },
                { 12.7, 14.8, 17.9 },
                { 84.1, 24.2, 51.2 },
                { 43.3, 71.4, 21.5 } };

        double[][] B = {
                { 10, 11, 34, 55 },
                { 33, 45, 17, 81 },
                { 45, 63, 12, 16 } };

        Matrix matrixA = new Matrix(A);
        Matrix matrixB = new Matrix(B);

        Matrix matrixRes = matrixA.multiply(matrixB);
        Matrix matrixRes2 = matrixA.plus(matrixA);
        matrixA.transpose().show();
        matrixRes.show();
        matrixRes2.show();

    }
}
