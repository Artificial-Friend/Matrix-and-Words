package core.basesyntax;

public class Matrix {
    private static int size;
    public static char[][] matrixOfLetters;

    public int[] method(String matrixString, String string) {
        checkIfMatrixStringCorrect(matrixString, string);
        matrixOfLetters = placeStringInMatrix(matrixString);
        return null;
    }

    private char[][] placeStringInMatrix(String string) {
        char[][] matrix = new char[size][size];
        for (int column = 0, counter = 0; column < size; column++) {
            for (int row = 0; row < size; row++) {
                matrix[column][row] = string.charAt(counter);
                counter++;
                System.out.println(matrix[column][row]);
            }
        }
        return matrix;
    }

    private void checkIfMatrixStringCorrect(String matrixString, String string) {
        double sqrt = Math.sqrt(string.length());
        if ((size = (int) sqrt) != sqrt) {
            throw new IllegalArgumentException(); //TODO
        }
        for (int i = 0; i < string.length(); i++) {
            if (!matrixString.contains(string.substring(i, i + 1))) {
                throw new IllegalArgumentException(); //TODO
            }
        }
    }
}