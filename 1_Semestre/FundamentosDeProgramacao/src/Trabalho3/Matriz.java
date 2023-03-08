import java.util.Random;

public class Matriz {

    private int lineAmount = 3;
    private int columnAmount = 3;
    private int lowerBound = 0;
    private int upperBound = 9;
    private int[][] matrix;
    private int[] matrixValues;

    public Matriz() {
        setMatrix(lineAmount, columnAmount, lowerBound, upperBound);
        setMatrixValues(matrix, lineAmount, columnAmount);
    }

    public Matriz(int lineAmount, int columnAmount) {
        this.lineAmount = lineAmount;
        this.columnAmount = columnAmount;
        setMatrix(lineAmount, columnAmount, lowerBound, upperBound);
        setMatrixValues(matrix, lineAmount, columnAmount);
    }

    public Matriz(int lineAmount, int columnAmount, int lowerBound, int upperBound) {
        this.lineAmount = lineAmount;
        this.columnAmount = columnAmount;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        setMatrix(lineAmount, columnAmount, lowerBound, upperBound);
        setMatrixValues(matrix, lineAmount, columnAmount);
    }

    public int[] getMatrixValues() {
        return this.matrixValues;
    }

    public void setMatrixValues(int[][] matrix, int lineAmount, int columnAmount) {
        int k = 0;
        this.matrixValues = new int[lineAmount * columnAmount];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                this.matrixValues[k] = matrix[i][j];
                k++;
            }
        }
    }

    public int[][] getMatrix() {
        return this.matrix;
    }

    public void setMatrix(int lineAmount, int columnAmount, int lowerBound, int upperBound) {
        this.matrix = new int[lineAmount][columnAmount];

        for (int i = 0; i < lineAmount; i++) {
            for (int j = 0; j < columnAmount; j++) {
                this.matrix[i][j] = getRandom(lowerBound, upperBound);
            }
        }
    }

    public int getRandom(int lowerBound, int upperBound) {
        Random r = new Random();
        return r.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }

    public int getLineAmount() {
        return this.lineAmount;
    }

    public void setLineAmount(int lineAmount) {
        this.lineAmount = lineAmount;
    }

    public int getColumnAmount() {
        return this.columnAmount;
    }

    public void setColumnAmount(int columnAmount) {
        this.columnAmount = columnAmount;
    }

    public int getLowerBound() {
        return this.lowerBound;
    }

    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    public int getUpperBound() {
        return this.upperBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }
}