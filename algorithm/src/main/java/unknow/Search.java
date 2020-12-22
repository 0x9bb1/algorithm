package unknow;

/**
 * 二分法
 */
public class Search {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            if (nums[start] == target) {
                return start;
            }

            if (nums[end] == target) {
                return end;
            }

            int middle = (start + end) / 2;
            if (nums[middle] == target) {
                return middle;
            }

            if (nums[start] > nums[middle]) {
                if (nums[start] > target && nums[middle] < target) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            } else {
                if (nums[start] < target && nums[middle] > target) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
        }

        return  -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int[] nums1 = new int[]{4,5,6,7,0,1,2};
        int target = 4;
        int target1 = 3;
        int target2 = 0;
        Search search = new Search();
        System.out.println(search.search(nums,target));
        System.out.println(search.search(nums,target1));
        System.out.println(search.search(nums1,target2));
    }
}
