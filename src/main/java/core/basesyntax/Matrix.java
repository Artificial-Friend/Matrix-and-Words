package core.basesyntax;

public class Matrix {
    private static int size;
    public static char[][] matrixOfLetters;

    public int[][] method(String charSequence, String string) {
        checkIfMatrixOfCharsCorrect(charSequence, string);
        return solution(stringToCharMatrix(charSequence), string);
    }

    private char[][] stringToCharMatrix(String string) {
        char[][] matrix = new char[size + 2][size + 2];
        for (int column = 1, counter = 0; column <= size; column++) {
            for (int row = 1; row <= size; row++) {
                matrix[column][row] = string.charAt(counter);
                counter++;
                System.out.println(matrix[column][row]);
            }
        }
        return matrix;
    }

    private void checkIfMatrixOfCharsCorrect(String charSequence, String string) {
        double sqrt = Math.sqrt(charSequence.length());
        if ((size = (int) sqrt) != sqrt) {
            throw new IllegalArgumentException("Chars length is not N^2");
        }
        for (int i = 0; i < string.length(); i++) {
            if (!charSequence.contains(string.substring(i, i + 1))) {
                throw new IllegalArgumentException("Charsequence and string differs at " + i);
            }
        }
    }

    private int[][] solution(char[][] matrix, String string) {
        int[][] answer = new int[string.length()][2];
        answer[0] = getFirstCell(matrix, string.charAt(0));
        for (int i = 1; i < answer.length; i++) {
            answer[i] = getNextCell(matrix, string.charAt(i), answer[i - 1][0] + 1, answer[i - 1][1] + 1);
        }
        return answer;
    }

    private int[] getFirstCell(char[][] matrix, char character) {
        for (int column = 1; column <= size; column++) {
            for (int row = 1; row <= size; row++) {
                if (matrix[column][row] == character) {
                    matrix[column][row] = Character.MIN_VALUE;
                    return new int[] {column - 1, row - 1};
                }
            }
        }
        throw new RuntimeException("ERROR: programmer will be punished.");
    }

    //TODO Wrong matrix calculation. collision absolute with relative
    private int[] getNextCell(char[][] matrix, char character, int column, int row) {
        if (matrix[column - 1][row] == character) {
            matrix[column - 1][row] = Character.MIN_VALUE;
            return new int[]{column - 2, row - 1};
        }
        if (matrix[column + 1][row] == character) {
            matrix[column + 1][row] = Character.MIN_VALUE;
            return new int[]{column, row - 1};
        }
        if (matrix[column][row - 1] == character) {
            matrix[column][row - 1] = Character.MIN_VALUE;
            return new int[]{column - 1, row - 2};
        }
        if (matrix[column][row + 1] == character) {
            matrix[column][row + 1] = Character.MIN_VALUE;
            return new int[]{column - 1, row};
        }
        throw new IllegalArgumentException("It seems that your characters are not connected");
    }
}
