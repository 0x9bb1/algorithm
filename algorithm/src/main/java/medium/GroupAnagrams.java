package medium;

import java.util.*;

/**
 * leet-code 49. 字母异位词分组
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        Arrays.stream(strs)
                .forEach(s -> {
                    char[] chars = s.toCharArray();
                    Arrays.sort(chars);

                    String key = new String(chars);
                    if (map.containsKey(key)) {
                        map.get(key).add(s);
                    } else {
                        List<String> val = new ArrayList<>();
                        val.add(s);
                        map.put(key, val);
                    }
                });

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
