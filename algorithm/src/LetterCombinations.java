import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * dfs
 * 等于深度遍历树
 */
public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
       if (digits == null || digits.length() == 0) {
           return new ArrayList<>();
       }

        Map<Character, String[]> map = new HashMap<>();
        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"g", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        dfs(digits, 0 , map, res, sb);
        return res;

    }

    private void dfs(String digits, int step,
                     Map<Character, String[]> map,
                     List<String> res,
                     StringBuilder sb) {
        if (digits.length() == step) {
            res.add(sb.toString());
            return;
        }

        char c = digits.charAt(step);
        String[] tmp = map.get(c);
        for (int i = 0; i < tmp.length; i++) {
            sb.append(tmp[i]);
            dfs(digits,step + 1, map, res, sb);
            // 这里是为了回退
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        LetterCombinations combinations =
                new LetterCombinations();

        List<String> res = combinations
                .letterCombinations(digits);

        res.forEach(
                System.out::println
        );
    }
}
