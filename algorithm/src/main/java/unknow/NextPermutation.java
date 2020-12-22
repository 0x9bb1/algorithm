package unknow;

/**
 * 字典序：从左至右，依次增大
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {

        int i = nums.length - 2;

        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i + 1);

        for (int j = 0; j < nums.length; j++) {
            System.out.println(nums[j]);
        }
    }

    private void reverse(int[] nums,int start) {
        int i = start;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums,int i,int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int[] nums1 = new int[]{3,2,1};
        int[] nums2 = new int[]{1,1,5};
        int[] nums3 = new int[]{1,2};
        NextPermutation nextPermutation =
                new NextPermutation();

        // nextPermutation.nextPermutation(nums);
        // nextPermutation.nextPermutation(nums1);
        // nextPermutation.nextPermutation(nums2);
        nextPermutation.nextPermutation(nums3);
    }
}
