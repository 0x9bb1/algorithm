import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15、三数之和
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> list = new ArrayList<>();

        if (len < 3) {
            return list;
        }

        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            // 避免重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    list.add(
                            Arrays.asList(nums[i],nums[l],nums[r])
                    );
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        ThreeSum sum = new ThreeSum();

        List<List<Integer>> list = sum.threeSum(nums);

        list.stream()
                .forEach(System.out::println);
    }
}
