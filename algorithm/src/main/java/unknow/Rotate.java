package unknow;

/**
 * 48、旋转图像
 */
public class Rotate {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        if (n <= 1) {
            return;
        }

        //旋转次数
        int count = n * n / 4;

        int x = 0;
        int y = 0;
        int z = 0;

        int x1, y1, x2, y2;

        for (int i = 0; i < count; i++) {
            if (z >= (n - 1) - 2 * x) {
                x += 1;
                z = 0;
            }
            y = z + x;
            z += 1;

            x1 = x;
            y1 = y;

            for (int j = 0; j < 3; j++) {
                x2 = n - 1 - y1;
                y2 = x1;

                matrix[x1][y1] = matrix[x1][y1] ^ matrix[x2][y2];
                matrix[x2][y2] = matrix[x1][y1] ^ matrix[x2][y2];
                matrix[x1][y1] = matrix[x1][y1] ^ matrix[x2][y2];

                x1 = x2;
                y1 = y2;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        Rotate rotate = new Rotate();
        rotate.rotate(matrix);
    }
}
