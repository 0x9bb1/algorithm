package medium;

import java.util.*;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */
public class PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (null == nums || nums.length == 0) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);

        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>(len);
        boolean[] used = new boolean[len];

        this.dfs(result, nums, len, 0, path, used);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] nums, int len,
                     int depth, Deque<Integer> path, boolean[] used) {
        if (len == depth) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;

            dfs(result, nums, len, depth + 1, path, used);

            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        PermuteUnique permuteUnique = new PermuteUnique();
        int[] nums = {1, 1, 2};

        System.out.println(permuteUnique.permuteUnique(nums).toString());
    }
}
