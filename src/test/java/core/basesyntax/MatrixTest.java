package core.basesyntax;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MatrixTest {
    private static final String DUMMY_STRING_VALUE = "Hello world";
    private static final String FOUR_LETTERS = "JAVA";
    private static final String NINE_LETTERS = "NINELETER";
    private static final String SIXTEEN_LETTERS = "SIXTEENLETTERSYA";
    private static Matrix matrix;

    @BeforeAll
    static void beforeAll() {
        matrix = new Matrix();
    }

    @Test
    public void inputPowerOfTwo_Correct() {
        matrix.method(FOUR_LETTERS, FOUR_LETTERS);
        assertEquals(0, Math.sqrt(Matrix.matrixOfLetters.length % 1));
        matrix.method(NINE_LETTERS, NINE_LETTERS);
        assertEquals(0, Math.sqrt(Matrix.matrixOfLetters.length % 1));
        matrix.method(SIXTEEN_LETTERS, SIXTEEN_LETTERS);
        assertEquals(0, Math.sqrt(Matrix.matrixOfLetters.length % 1));
    }

    @Test
    public void inputNotPowerOfTwo_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> matrix.method("ONE", "KING"));
        assertThrows(IllegalArgumentException.class, () -> matrix.method("EIGHT---", "KING"));
        assertThrows(IllegalArgumentException.class,
                () -> matrix.method("SEVENTEEN--------", "KING"));
    }

    @Test
    public void nonLetterCharInWord_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> matrix.method(DUMMY_STRING_VALUE, "1408"));
        assertThrows(IllegalArgumentException.class, () -> matrix.method(DUMMY_STRING_VALUE, "-"));
        assertThrows(IllegalArgumentException.class, () -> matrix.method(DUMMY_STRING_VALUE, "K1NG"));
    }

    @Test
    public void matrixDoesNotContainString_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> matrix.method(FOUR_LETTERS, "KING"));
        assertThrows(IllegalArgumentException.class, () -> matrix.method(FOUR_LETTERS, "MATE"));
        assertThrows(IllegalArgumentException.class, () -> matrix.method(NINE_LETTERS, "NONELETER"));
    }

    @Test
    public void checkMatrixForLetter_Correct() {

    }

    @Test
    void someTest() {

        assertEquals(new int[][]{{1, 2}, {1, 3}, {0, 3}, {0, 2}},
                matrix.method("QLGNAEKIRLRNGEAE", "KING"));
        matrix.method("RPEIVaEaCXCAYhTzcqpesBOfd", "peach");
    }
}
