package simple;

import java.util.Arrays;

/**
 * 面试题29. 顺时针打印矩阵
 *
 * @{link https://leetcode-cn.com/problems/spiral-matrix/}
 */
public class SpiralOrder {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] order = new int[rows * columns];
        int left = 0;
        int right = columns - 1;
        int top = 0;
        int bottom = rows - 1;
        int index = 0;
        while (left <= right && top <= bottom) {
            // 左 --> 右
            for (int column = left; column <= right; column++) {
                order[index++] = matrix[top][column];
            }

            // 上 --> 下
            for (int row = top + 1; row <= bottom; row++) {
                order[index++] = matrix[row][right];
            }

            if (left < right && top < bottom) {
                // 右 --> 左
                for (int column = right - 1; column > left; column--) {
                    order[index++] = matrix[bottom][column];
                }

                // 下 --> 上
                for (int row = bottom; row > top; row--) {
                    order[index++] = matrix[row][left];
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }

        return order;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        SpiralOrder spiralOrder = new SpiralOrder();
        System.out.println(Arrays.toString(spiralOrder.spiralOrder(matrix)));
    }
}
