/*
解题思路：
1. 使用前缀和表示从数组开头到当前位置的元素和。
2. 如果当前前缀和为 prefixSum，想找到和为 k 的子数组，就需要之前出现过 prefixSum - k。
3. 用 HashMap 记录每个前缀和出现的次数，遍历时先统计能组成目标和的数量，再更新当前前缀和次数。
4. 初始放入前缀和 0 出现 1 次，用来处理从下标 0 开始就满足和为 k 的子数组。
5. 遍历结束后返回统计到的子数组个数。

时间复杂度：O(n)。
空间复杂度：O(n)。
*/
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;
            count += prefixSumCount.getOrDefault(prefixSum - k, 0);
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
