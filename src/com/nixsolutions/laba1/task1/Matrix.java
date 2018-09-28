package com.nixsolutions.laba1.task1;

/**
 * A matrix class with fields <b> n </ b> and <b> m </ b>, b> mainMatrix </ b.
 *
 * @version 1.0
 * @autor Alexander Sinkevich
 */
public class Matrix {

    public Matrix() {
    }

    private int n, m;
    private double[][] mainMatrix;

    /**
     * Constructor - creating a new object with certain values
     *
     * @param n - length
     * @param m - width
     * @see Matrix # Matrix ()
     */
    // create M-by-N matrix of 0's
    public Matrix(int m, int n) {
        this.m = m;
        this.n = n;
        mainMatrix = new double[m][n];
    }

    public Matrix(double[][] mainMatrix) {
        this.m = mainMatrix.length;
        this.n = mainMatrix[0].length;
        this.mainMatrix = mainMatrix;
        //        M = mainMatrix.length;
        //        N = mainMatrix[0].length;
        //        this.mainMatrix = new double[M][N];
        //        for (int i = 0; i < M; i++)
        //            for (int j = 0; j < N; j++)
        //                this.mainMatrix[i][j] = mainMatrix[i][j];
    }

    /**
     * The function create and return a random M-by-N matrix with values between 0 and 1
     *
     * @return returns the matrix element
     */
    public static Matrix random(int M, int N) {
        Matrix A = new Matrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                A.mainMatrix[i][j] = Math.random();
        return A;
    }

    /**
     * The function create and return the transpose of the invoking matrix
     *
     * @return returns the matrix element
     */
    public Matrix transpose() {
        Matrix A = new Matrix(n, m);
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                A.mainMatrix[j][i] = this.mainMatrix[i][j];
        return A;
    }

    /**
     * The function return C = A * B
     *
     * @return returns the matrix element
     */
    public Matrix multiply(Matrix B) {

        Matrix A = this;
        if (A.n != B.m)
            throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(A.m, B.n);
        for (int i = 0; i < C.m; i++)
            for (int j = 0; j < C.n; j++)
                for (int k = 0; k < A.n; k++)
                    C.mainMatrix[i][j] += (A.mainMatrix[i][k]
                            * B.mainMatrix[k][j]);
        return C;

    }

    /**
     * The function return C = A + B
     *
     * @return returns the matrix element
     */
    public Matrix plus(Matrix B) {
        Matrix A = this;
        if (B.m != A.m || B.n != A.n)
            throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(m, n);
        for (int i = 0; i < mainMatrix.length; i++)
            for (int j = 0; j < mainMatrix[0].length; j++)
                C.mainMatrix[i][j] = A.mainMatrix[i][j] + B.mainMatrix[i][j];
        return C;
    }

    // print matrix to standard output
    public void show() {
        for (int i = 0; i < mainMatrix.length; i++) {
            for (int j = 0; j < mainMatrix[i].length; j++)
                System.out.printf("%9.2f ", mainMatrix[i][j]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        double[][] A = { { 33.1, 34.2, 12.3 }, { 33.4, 19.5, 10.6 },
                { 12.7, 14.8, 17.9 }, { 84.1, 24.2, 51.2 },
                { 43.3, 71.4, 21.5 } };

        double[][] B = { { 10, 11, 34, 55 }, { 33, 45, 17, 81 },
                { 45, 63, 12, 16 } };

        Matrix AB = new Matrix(A);
        Matrix AC = new Matrix(B);

        Matrix nab = AB.multiply(AC);
        nab.show();
        System.out.println("------------");
        Matrix A1 = Matrix.random(5, 4);
        Matrix A2 = Matrix.random(4, 5);

        A1.show();

        System.out.println("------------");
        A2.show();
        System.out.println("------------");
        A1.plus(A1).show();

        System.out.println("------------");
        A2.show();
        System.out.println("------------");
        A2.transpose().show();

    }

}
