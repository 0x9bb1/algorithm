public class Divide {

    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE
                && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative;
        //用异或来计算是否符号相异
        negative = (dividend ^ divisor) < 0;
        long t = Math.abs(Long.valueOf(dividend));
        long d = Math.abs(Long.valueOf(divisor));
        int result = 0;
        for (int i = 31; i >= 0;i--) {
            if ((t >> i) >= d) {
                result += 1 << i;
                t -= d << i;
            }
        }
        return negative ? -result : result;
    }

    public static void main(String[] args) {
        Divide divide = new Divide();
        System.out.println(
                divide.divide(10,3)
        );
        System.out.println(
                divide.divide(7,-3)
        );
        System.out.println(
                divide.divide(2147483647
                        ,2)
        );
    }
}
