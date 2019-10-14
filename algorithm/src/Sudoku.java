import java.util.HashMap;
import java.util.Objects;

/**
 * 36. 有效的数独
 */
public class Sudoku {

    public boolean isValidSudoku(char[][] board) {
        // init data
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (!Objects.equals('.', num)) {
                    int n = num;
                    int boxIndex = (i / 3) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i]
                            .getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j]
                            .getOrDefault(n, 0) + 1);
                    boxes[boxIndex].put(n, boxes[boxIndex]
                            .getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 ||
                            columns[j].get(n) > 1 ||
                            boxes[boxIndex].get(n) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
