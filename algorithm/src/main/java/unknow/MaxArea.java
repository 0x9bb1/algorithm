package unknow;

/**
 * 动态规划，基本的表达式: area = min(height[i], height[j]) * (j - i)
 * 使用两个指针，值小的指针向内移动，这样就减小了搜索空间
 * 因为面积取决于指针的距离与值小的值乘积，如果值大的值向内移动，距离一定减小，
 * 而求面积的另外一个乘数一定小于等于值小的值，因此面积一定减小，
 * 而我们要求最大的面积，因此值大的指针不动，而值小的指针向内移动遍历
 */
public class MaxArea {

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int result = 0;

        if (height.length <= 1) {
            return 0;
        }

        while (i < j) {
            int h = Math.min(height[i],height[j]);
            result = Math.max(result,h * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height1 = {1,1};
        MaxArea maxArea = new MaxArea();
        System.out.println(
                maxArea.maxArea(height)
        );
        System.out.println(
                maxArea.maxArea(height1)
        );
    }
}
