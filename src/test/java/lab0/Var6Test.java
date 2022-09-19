package lab0;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Var6Test {

    @Test(dataProvider = "integerProvider")
    public void integerProviderTest(int p1, int p3) {
        assertEquals(new Var6().integerNumbersTask(p1), p3);
    }
    @DataProvider
    public Object[][] integerProvider() {
        return new Object[][] {{58, 85}, {10, 1}, {99, 99}};
    }

    @Test(dataProvider = "negativeIntegerProvider", expectedExceptions = AssertionError.class)
    public void negativeIntegerTest(int a) {
        new Var6().integerNumbersTask(a);
    }
    @DataProvider
    public Object[][] negativeIntegerProvider() {
        return new Object[][] {{9}, {100}, {-2} };
    }


    @Test(dataProvider = "booleanProvider")
    public void booleanProviderTest(int a, int b, int c, boolean res) {
        assertEquals(new Var6().doubleInequality(a, b, c), res);
    }
    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][] {{1, 2, 3 , true}, {3, 10, 30 , true}, {100, 11111, 1, false }};
    }

    @Test(dataProvider = "negativeBooleanProvider", expectedExceptions = AssertionError.class)
    public void negativeBooleanTest(int a, int b, int c) {
        new Var6().doubleInequality(a, b, c);
    }
    @DataProvider
    public Object[][] negativeBooleanProvider() {
        return new Object[][] {{0, 0, 0}};
    }


    @Test(dataProvider = "ifProvider")
    public void ifProviderTest(int a, int b, int res) {
        assertEquals(new Var6().checkForGreater(a, b), res);
    }
    @DataProvider
    public Object[][] ifProvider() {
        return new Object[][] {{1, 2, 2}, {3, 10, 10}, {100, 1, 100}};
    }

    @Test(dataProvider = "negativeIfProvider", expectedExceptions = AssertionError.class)
    public void negativeIfTest(int a, int b) {
        new Var6().checkForGreater(a, b);
    }
    @DataProvider
    public Object[][] negativeIfProvider() {
        return new Object[][] {{0, 0}};
    }


    @Test(dataProvider = "caseProvider")
    public void caseProviderTest(int a, double b, double res) {
        assertEquals(new Var6().lengthSwitchCase(a, b), res);
    }
    @DataProvider
    public Object[][] caseProvider() {
        return new Object[][] {{1, 2, 0.2}, {3, 10, 10}, {2, 2000, 2000000}};
    }

    @Test(dataProvider = "negativeCaseProvider", expectedExceptions = AssertionError.class)
    public void negativeCaseTest(int a, int b) {
        new Var6().lengthSwitchCase(a, b);
    }
    @DataProvider
    public Object[][] negativeCaseProvider() {
        return new Object[][] {{9, -9}, {0, 5}};
    }


    @Test(dataProvider = "forProvider")
    public void forProviderTest(int a, double[] b) {
        assertEquals(new Var6().candyByKilo(a), b);
    }
    @DataProvider
    public Object[][] forProvider() {
        return new Object[][] {{2, new double[]{2.4, 2.8, 3.2, 3.6, 4.0}}};
    }

    @Test(dataProvider = "negativeForProvider", expectedExceptions = AssertionError.class)
    public void negativeForTest(int a) {
        new Var6().candyByKilo(a);
    }
    @DataProvider
    public Object[][] negativeForProvider() {
        return new Object[][] {{-1}, {0}};
    }


    @Test(dataProvider = "whileProvider")
    public void whileProviderTest(int a, double res) {
        assertEquals(new Var6().doubleFactorial(a), res);
    }
    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][] {{4, 8}, {9, 945}, {7, 105} };
    }

    @Test(dataProvider = "negativeWhileProvider", expectedExceptions = AssertionError.class)
    public void negativeWhileTest(int a) {
        new Var6().doubleFactorial(a);
    }
    @DataProvider
    public Object[][] negativeWhileProvider() {
        return new Object[][] {{-1}, {0}};
    }


    @Test(dataProvider = "arrayProvider")
    public void arrayProviderTest(int n, int a, int b, int[] res) {
        assertEquals(new Var6().arrayTask(n, a, b), res);
    }
    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][] {{4, 1, 2, new int[]{1, 2, 3, 6}}};
    }

    @Test(dataProvider = "negativeArrayProvider", expectedExceptions = AssertionError.class)
    public void negativeArrayTest(int n, int a, int b) {
        new Var6().arrayTask(n, a, b);
    }
    @DataProvider
    public Object[][] negativeArrayProvider() {
        return new Object[][] {{0, 1, -10}, {5, 2, 0}};
    }


    @Test(dataProvider = "matrixProvider")
    public void matrixProviderTest(int m, int n, int q, int[] arr, int[][] res) {
        assertEquals(new Var6().matrixGeometricalProgression(m, n, q, arr), res);
    }
    @DataProvider
    public Object[][] matrixProvider() {
        return new Object[][] {{3, 3, 2, new int[]{1, 2, 3}, new int[][]{{1, 2, 3},{2, 4, 6},{4, 8, 12}}}};
    }
}
