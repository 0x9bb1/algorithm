package unknow;

public class MyPow {

    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / pow(x,n);
        } else {
            return pow(x,n);
        }
    }

    private double pow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        if (n == 1) {
            return x;
        }

        double val = pow(x, n / 2);

        if (n % 2 == 0) {
            return val * val;
        } else {
            return val * val * x;
        }
    }

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        System.out.println(
                myPow.myPow(3,4)
        );
    }
}
