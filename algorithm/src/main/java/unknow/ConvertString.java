package unknow;

import java.util.ArrayList;
import java.util.List;

/**
 * Z字型变换
 */
public class ConvertString {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            // 向上移动到最上面的行或向下移动到最下面的行时，当前方向才会发生改变
            if (curRow == 0 || curRow == numRows - 1){
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String string = "LEETCODEISHIRING";
        int num = 3;
        System.out.println(
                new ConvertString().convert(string,num));
    }
}
