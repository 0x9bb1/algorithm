import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        if (len < 4) {
            return result;
        }

        Arrays.sort(nums);

        int i;
        int j;
        int l;
        int r;
        int tmp;

        for (i = 0; i < len - 3; i++) {
            for (j = i + 1; j < len - 2; j++) {
                l = j + 1;
                r = len - 1;
                tmp = target - nums[i] - nums[j];
                while (l < r) {
                    if (nums[l] + nums[r] > tmp) {
                        r--;
                        continue;
                    }
                    if (tmp == nums[l] + nums[r]) {
                        List<Integer> item = Arrays.asList(
                                nums[i],
                                nums[j],
                                nums[l],
                                nums[r]
                        );
                        result.add(item);
                    }
                    l++;
                    while (nums[l] == nums[l - 1] &&
                            l < r) {
                        l++;
                    }
                }
                while (nums[j] == nums[j + 1] &&
                        j < len - 2) {
                    j++;
                }
            }
            while (nums[i] == nums[i + 1] &&
                    i < len - 3) {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result;
        FourSum fourSum = new FourSum();
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;

        result = fourSum.fourSum(nums,target);

        result.forEach(System.out::println);
    }
}
