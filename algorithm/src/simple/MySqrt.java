package simple;

/**
 * 69. x 的平方根
 * <p>
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 牛顿法
 */
public class MySqrt {

    public int mySqrt(int x) {
        if (x == 0) {
            return x;
        }

        return (int) mySqrt(x, x);

    }

    private double mySqrt(double x, int s) {
        // x * x - a = 0
        // f`(x) = 2x
        double result = (x + s / x) / 2;
        if (x == result) {
            return result;
        } else {
            return mySqrt(result, s);
        }
    }

    public static void main(String[] args) {
        int x = 8;
        MySqrt mySqrt = new MySqrt();

        System.out.println(mySqrt.mySqrt(x));
    }
}
