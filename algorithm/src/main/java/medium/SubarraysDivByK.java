package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 974. 和可被 K 整除的子数组
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 *
 * @author zhangnix
 */
public class SubarraysDivByK {

    public int subarraysDivByK(int[] A, int K) {
        int count = 0;
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);

        int sum = 0;
        for (int value : A) {
            sum += value;
            // ?
            int modulus = (sum % K + K) % K;

            int same = record.getOrDefault(modulus, 0);
            count += same;
            record.put(modulus, ++same);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {4, 5, 0, -2, -3, 1};
        int K = 5;

        System.out.println(new SubarraysDivByK().subarraysDivByK(A, K));
    }
}
