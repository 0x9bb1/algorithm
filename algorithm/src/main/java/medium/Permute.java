package medium;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 使用回朔法
 * 1、路径：也就是已经做出的选择。
 * 2、选择列表：也就是你当前可以做的选择。
 * 3、结束条件：也就是到达决策树底层，无法再做选择的条件。
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        if (null == nums || nums.length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        this.backTrack(result, track, nums);
        return result;
    }

    private void backTrack(List<List<Integer>> result, LinkedList<Integer> track, int[] nums) {
        if (track.size() == nums.length) {
            result.add(new LinkedList<>(track));
        }

        for (int num : nums) {
            if (track.contains(num)) {
                continue;
            }
            track.add(num);
            this.backTrack(result, track, nums);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        int[] nums = {1, 2, 3};
        long before = System.nanoTime();
        System.out.println(permute.permute(nums));
        System.out.println("耗时：" + (System.nanoTime() - before));
    }
}
