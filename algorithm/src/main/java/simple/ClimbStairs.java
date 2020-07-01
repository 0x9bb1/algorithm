package simple;

/**
 * 70. 爬楼梯
 * <p>
 * 动态规划
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        int n = 6;

        System.out.println(climbStairs.climbStairs(n));
    }
}
