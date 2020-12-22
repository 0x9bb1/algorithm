package unknow;

import java.util.Arrays;

class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if (len < 3) {
            return target;
        }

        Arrays.sort(nums);

        int closestSums = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len - 2; i++) {
            int l = i + 1;
            int r = len - 1;

            while (l < r) {
                int threeSums = nums[i] + nums[l] + nums[r];
                // Math.abs求绝对值
                if (Math.abs(threeSums - target)
                        < Math.abs(closestSums - target)) {
                    closestSums = threeSums;
                }

                if (threeSums > target) {
                    r--;
                } else if (threeSums < target) {
                    l++;
                } else {
                    return target;
                }
            }
        }
        return closestSums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        int[] nums1 = new int[]{-1,2};
        int target = 1;
        ThreeSumClosest closest = new ThreeSumClosest();

        System.out.println(
                closest.threeSumClosest(nums,target)
        );
        System.out.println(
                closest.threeSumClosest(nums1,target)
        );
    }
}