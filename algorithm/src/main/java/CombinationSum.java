package main.java;

import java.util.*;

/**
 * 递归回朔
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        if (Objects.equals(0, len)) {
            return res;
        }
        Arrays.sort(candidates);
        Deque<Integer> pre = new ArrayDeque<>();
        this.combinationSum(res, target, 0, len, candidates, pre);
        return res;
    }

    private void combinationSum(List<List<Integer>> res,
                                int residue,
                                int start,
                                int len,
                                int[] candidates,
                                Deque<Integer> pre) {
        if (Objects.equals(0, residue)) {
            List<Integer> tmp = new ArrayList<>(pre);
            Collections.sort(tmp);
            res.add(tmp);
            return;
        }

        for (int i = start; i < len && (residue - candidates[i] >= 0); i++) {
            pre.push(candidates[i]);
            this.combinationSum(
                    res,
                    residue - candidates[i],
                    i,
                    len,
                    candidates,
                    pre);
            pre.pop();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> res = combinationSum
                .combinationSum(candidates, target);
        System.out.println(res.toString());
    }
}
