package medium;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1162. 地图分析
 * <p>
 * BFS，遍历图
 */
public class MaxDistance {

    public int maxDistance(int[][] grid) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> queue = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;

        // 将所有陆地入列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        boolean hasOcean = false;
        int[] point = null;
        while (!queue.isEmpty()) {
            point = queue.poll();
            int x = point[0];
            int y = point[1];

            for (int i = 0; i < 4; i++) {
                int newX = dx[i] + x;
                int newY = dy[i] + y;

                if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 0) {
                    continue;
                }

                // 直接在原数组上修改，存储的value就是距离
                grid[newX][newY] = grid[x][y] + 1;
                hasOcean = true;
                queue.offer(new int[]{newX, newY});
            }
        }

        // 没有陆地或者海洋，返回-1
        if (point == null || !hasOcean) {
            return -1;
        }

        // 返回最后一次遍历到海洋的距离
        return grid[point[0]][point[1]] - 1;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        MaxDistance maxDistance = new MaxDistance();

        System.out.println(maxDistance.maxDistance(grid));
    }
}
