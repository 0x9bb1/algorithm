package unknow;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public static int lengthOfSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int now = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                now = Math.max(map.get(s.charAt(i)) + 1,now);
                if (maxLength < (i - now + 1)) {
                    maxLength = i - now + 1;
                }
            } else {
                if (maxLength < (i - now + 1)) {
                    maxLength = i - now + 1;
                }
            }
            map.put(s.charAt(i),i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "abcdrr";
        String str1 = "aaaaaaaaaa";
        System.out.println(LengthOfLongestSubstring.lengthOfSubstring(str));
        System.out.println(LengthOfLongestSubstring.lengthOfSubstring(str1));
    }
}
