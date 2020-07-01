package medium;

import java.util.Objects;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，
 * 返回 num1 和 num2 的乘积，
 * 它们的乘积也表示为字符串形式。
 */
public class Multiply {
    private static final String ZERO = "0";

    private static final char CHAR_ZERO = '0';

    public String multiply(String num1, String num2) {
        if (Objects.equals(ZERO, num1) || Objects.equals(ZERO, num2)) {
            return ZERO;
        }

        int[] arr1 = this.tran2Array(num1);
        int[] arr2 = this.tran2Array(num2);

        int len = arr1.length + arr2.length + 1;
        int[] result = new int[len];
        int tmp = 0;
        int m = 0;
        int extra = 0;
        for (int j = arr2.length - 1; j >= 0; j--) {
            for (int i = arr1.length - 1; i >= 0; i--) {
                tmp = arr1[i] * arr2[j];
                m = (arr1.length - 1 - i) + (arr2.length - 1 - j);
                result[m] += tmp;
                while (result[m] >= 10) {
                    extra = result[m] / 10;
                    result[m] %= 10;
                    m++;
                    result[m] += extra;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = result.length - 1;
        while (i >= 0 && Objects.equals(0, result[i])) {
            i--;
        }
        for (; i >= 0; i--) {
            sb.append(result[i]);
        }
        return sb.toString();
    }

    private int[] tran2Array(String s) {
        if (Objects.isNull(s)) {
            return new int[0];
        }

        int[] arr = new int[s.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.charAt(i) - CHAR_ZERO;
        }
        return arr;
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        String n1 = "123";
        String n2 = "456";
        String res = multiply.multiply(n1, n2);
        System.out.println(res);
        System.out.println(123 * 456);
    }
}
