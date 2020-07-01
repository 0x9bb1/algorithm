package simple;

import java.util.Arrays;
import java.util.Objects;

/**
 * 快排
 *
 * @author zhangnix
 */
public class QuickSort {

    public void quickSort(int[] arr) {
        if (Objects.isNull(arr) || arr.length == 0) {
            return;
        }

        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int i = left;
        int j = right - 1;
        while (i <= j) {
            if (arr[i] <= arr[right]) {
                i++;
            } else {
                this.swap(arr, i, j);
                j--;
            }
        }
        this.swap(arr, i, right);

        this.quickSort(arr, left, i - 1);
        this.quickSort(arr, i + 1, right);
    }

    private void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = {3, 1, 8, 54, 2};

        quickSort.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}