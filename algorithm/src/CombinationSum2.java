import java.util.*;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        if (Objects.equals(0, len)) {
            return res;
        }
        Arrays.sort(candidates);
        Deque<Integer> pre = new ArrayDeque<>();
        this.combinationSum2(res, target, 0, len, candidates, pre);
        return res;
    }

    private void combinationSum2(List<List<Integer>> res,
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
            if (i > start && Objects.equals(candidates[i], candidates[i - 1])) {
                continue;
            }
            pre.push(candidates[i]);
            this.combinationSum2(
                    res,
                    residue - candidates[i],
                    i + 1,
                    len,
                    candidates,
                    pre);
            pre.pop();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        CombinationSum2 combinationSum2 = new CombinationSum2();
        List<List<Integer>> res = combinationSum2
                .combinationSum2(candidates, target);
        System.out.println(res.toString());
    }
}
