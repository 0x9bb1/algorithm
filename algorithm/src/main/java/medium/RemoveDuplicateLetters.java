package main.java.medium;

/**
 * 316. 去除重复字母
 */
public class RemoveDuplicateLetters {

    public static String removeDuplicateLetters(String s) {
        boolean[] vis = new boolean[26];
        int[] nums = new int[26];

        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char cr = s.charAt(i);
            if (!vis[cr - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > cr) {
                    if (nums[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }

                vis[cr - 'a'] = true;
                sb.append(cr);
            }
            nums[cr - 'a'] -= 1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "bcabc";
        System.out.println(removeDuplicateLetters(s));
    }
}
