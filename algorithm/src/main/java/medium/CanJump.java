package medium;

/**
 * 55. 跳跃游戏
 * 贪心
 *
 * @author adam zhang
 * @date created 2020/07/08
 */
public class CanJump {

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int rightMost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        int[] nums2 = new int[]{3, 2, 1, 0, 4};

        System.out.println(canJump(nums));
        System.out.println(canJump(nums2));
    }
}
