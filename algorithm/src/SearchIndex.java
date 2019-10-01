import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 二分查找法
 * 参考官方示例
 */
public class SearchIndex {

    public int[] searchRange(int[] nums, int target) {
        int[] defaultRange = {-1, -1};

        int leftIndex = this.extremeInsertionIndex(nums, target, true);

        if (leftIndex == nums.length || nums[leftIndex] != target) {
            return defaultRange;
        }

        defaultRange[0] = leftIndex;
        defaultRange[1] =
                this.extremeInsertionIndex(nums, target, false) - 1;
        return defaultRange;
    }

    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int low = 0;
        int high = nums.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target || (left && nums[mid] == target)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        SearchIndex searchIndex = new SearchIndex();
        int[] res = searchIndex.searchRange(nums, 8);
        int[] res1 = searchIndex.searchRange(nums, 6);
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(res1));
    }
}
