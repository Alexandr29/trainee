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
    public Matrix(int m, int n) {
        this.m = m;
        this.n = n;
        mainMatrix = new double[m][n];
    }

    /**
     * @param mainMatrix
     */
    public Matrix(double[][] mainMatrix) {
        this.m = mainMatrix.length;
        this.n = mainMatrix[0].length;
        this.mainMatrix = mainMatrix;
    }

    /**
     * The function create and return the transpose of the invoking matrix
     *
     * @return returns the matrix element
     */
    public Matrix transpose() {
        Matrix matrix = new Matrix(n, m);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix.mainMatrix[j][i] = this.mainMatrix[i][j];
            }
        }
        return matrix;
    }

    /**
     * The function return C = A * B
     *
     * @return returns the matrix element
     */
    public Matrix multiply(Matrix matrixB) {
        Matrix matrixA = this;
        if (matrixA.n != matrixB.m) {
            throw new RuntimeException("Illegal matrix dimensions.");
        }
        Matrix matrixRes = new Matrix(matrixA.m, matrixB.n);
        for (int i = 0; i < matrixRes.m; i++) {
            for (int j = 0; j < matrixRes.n; j++) {
                for (int k = 0; k < matrixA.n; k++) {
                    matrixRes.mainMatrix[i][j] += (matrixA.mainMatrix[i][k]
                            * matrixB.mainMatrix[k][j]);
                }
            }
        }
        return matrixRes;
    }

    /**
     * The function return C = A + B
     *
     * @return returns the matrix element
     */
    public Matrix plus(Matrix matrixB) {
        Matrix matrixA = this;
        if (matrixB.m != matrixA.m || matrixB.n != matrixA.n) {
            throw new RuntimeException("Illegal matrix dimensions.");
        }
        Matrix matrixRes = new Matrix(m, n);
        for (int i = 0; i < mainMatrix.length; i++) {
            for (int j = 0; j < mainMatrix[0].length; j++) {
                matrixRes.mainMatrix[i][j] =
                        matrixA.mainMatrix[i][j] + matrixB.mainMatrix[i][j];
            }
        }
        return matrixRes;
    }

    /**
     * show Matrix
     *
     * @return void
     */
    public void show() {
        for (int i = 0; i < mainMatrix.length; i++) {
            for (int j = 0; j < mainMatrix[i].length; j++) {
                System.out.printf("%9.2f ", mainMatrix[i][j]);
            }
            System.out.println();
        }
    }
}
