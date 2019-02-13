/**
 * @author zhangxin
 */
public class MaxSubsequenceSum {
    /**
     * 53. 最大子序和
     * 动态规划
     * @return
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int value = 0;

        for (int i = 0; i < nums.length; i++) {
            if (value <= 0) {
                value = nums[i];
            } else {
                value += nums[i];
            }

            if (value > maxSum) {
                maxSum = value;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] nums1 = new int[]{1};

        int result = new MaxSubsequenceSum().maxSubArray(nums);
        System.out.println(result);

        int result1 = new MaxSubsequenceSum().maxSubArray(nums1);
        System.out.println(result1);
    }
}
