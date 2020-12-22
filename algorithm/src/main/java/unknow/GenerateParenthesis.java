package unknow;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 回溯
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        generate("", res, n, n);
        return res;
    }

    private static void generate(String tmp, List<String> res,
                                 int left, int right) {
        if (left == 0 && right == 0) {
            res.add(tmp);
            return;
        }

        // 此处不能使用i--
        if (left > 0) {
            System.out.println("left:" + left + ",right:" + right);
            generate(tmp + "(", res, left - 1, right);
        }
        if (left < right) {
            generate(tmp + ")", res, left, right - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis obj = new GenerateParenthesis();
        List<String> res = obj.generateParenthesis(3);

        Optional.ofNullable(res)
                .ifPresent(System.out::println);
    }
}
