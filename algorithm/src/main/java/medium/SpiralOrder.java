package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 */
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (null == matrix || matrix.length == 0) {
            return result;
        }
        final int M = matrix.length;
        final int N = matrix[0].length;
        // 当前位置
        int r = 0;
        int c = 0;
        // 记录该点是否被访问过
        boolean[][] accessed = new boolean[M][N];
        // 增加1的步长
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        // 前进方向
        int di = 0;

        for (int i = 0; i < M * N; i++) {
            result.add(matrix[r][c]);
            accessed[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];

            if (0 <= cr && cr < M && 0 <= cc && cc < N && !accessed[cr][cc]) {
                r = cr;
                c = cc;
            } else {
                // 旋转
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        // [1,2,3,6,9,8,7,4,5]
        System.out.println(spiralOrder.spiralOrder(matrix));
    }
}
