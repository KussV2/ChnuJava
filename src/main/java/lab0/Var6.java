package lab0;

public class Var6 {
    public int integerNumbersTask(int k) {
        assert k < 100 && k >= 10: "Argument should be less than 100 and greater than 10";
        int a = k / 10;
        int b = k % 10;
        return b * 10 + a;
    }
    public boolean doubleInequality(int a, int b, int c) {
        assert a != b && b != c: "Arguments should differ";
        return a < b && b < c;
    }
    public int checkForGreater(int a, int b){
        assert a != b: "Arguments should differ";
        if (a > b){
            return a;
        }
        else return b;
    }
    public double lengthSwitchCase(int a, double b) {
        assert a <= 5 && a >= 1: "Switch case is only available through 1 to 5";
        double bPlaceHolder = 0;
        switch (a){
            case 1:
                bPlaceHolder = b / 10;
                break;
            case 2:
                bPlaceHolder = b * 1000;
                break;
            case 3:
                bPlaceHolder = b;
                break;
            case 4:
                bPlaceHolder = b / 1000;
                break;
            case 5:
                bPlaceHolder = b / 100;
                break;
        }
        return bPlaceHolder;
    }
    public double[] candyByKilo(int a){
        assert a > 0: "You can't buy negative weight value";
        double[] candyWeight = {1.2 , 1.4, 1.6, 1.8, 2.0};
        double[] candyPricePerKilo = {0, 0, 0, 0, 0};

        for (int i = 0; i < candyWeight.length; i++){
            candyPricePerKilo[i] = candyWeight[i] * a;
        }
        return candyPricePerKilo;
    }
    public int doubleFactorial(int a){
        assert a > 0: "You can't take a factorial of a negative number";
        int res = 1;
        while (a >= 2){
            res *= a;
            a -= 2;
        }
        return res;
    }
    public int[] arrayTask(int n, int a, int b){
        assert n > 0 && a > 0 && b > 0: "This array can't be 0";
        int[] someArray = new int[n];
        someArray[0] = a;
        someArray[1] = b;

        for(int i = 2; i < n; i++){
            someArray[i] = 0;
            for(int j = 0; j < i; j++){
                someArray[i] += someArray[j];
            }
        }
        return someArray;
    }
    public int[][] matrixGeometricalProgression(int m, int n, int q, int[]arr){
        int[][] someArray = new int[m][n];

        for (int j = 0; j < m; j++){
            someArray[0][j] = arr[j];
        }
        for (int i = 1; i < m; i++){
            for (int j = 0; j < n; j++){
                someArray[i][j] = someArray[i-1][j] * q;
            }
        }
        return someArray;
    }

}
