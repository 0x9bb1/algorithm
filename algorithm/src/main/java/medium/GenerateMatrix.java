package medium;

import java.util.Arrays;

/**
 * @author zhangnix
 * @date created 2020/12/22
 *
 * 59. 螺旋矩阵 II
 */
public class GenerateMatrix {

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int l = 0;
        int r = n - 1;
        int t = 0;
        int b = n - 1;
        int num = 1;
        int tar = n * n;

        while (num <= tar) {
            for (int i = l; i <= r; i++) {
                result[t][i] = num++;
            }
            t++;

            for (int i = t; i <= b; i++) {
                result[i][r] = num++;
            }
            r--;

            for (int i = r; i >= l; i--) {
                result[b][i] = num++;
            }
            b--;

            for (int i = b; i >= t; i--) {
                result[i][l] = num++;
            }
            l++;
        }

        return result;
    }

    public static void main(String[] args) {
        GenerateMatrix gen = new GenerateMatrix();
        int n = 3;

        System.out.println(Arrays.deepToString(gen.generateMatrix(n)));
    }
}
