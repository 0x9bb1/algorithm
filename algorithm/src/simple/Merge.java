package simple;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmpArray = new int[m];
        System.arraycopy(nums1, 0, tmpArray, 0, m);

        int p = 0;
        int p1 = 0;
        int p2 = 0;
        while ((p1 < m) && (p2 < n)) {
            nums1[p++] = (tmpArray[p1] < nums2[p2]) ? tmpArray[p1++] : nums2[p2++];
        }

        if (p1 < m) {
            System.arraycopy(tmpArray, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] num2 = new int[]{2, 5, 6};

        new Merge().merge(num1, 3, num2, 3);
        System.out.println(Arrays.toString(num1));
    }
}
