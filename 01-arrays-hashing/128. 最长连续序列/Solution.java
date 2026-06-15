/*
解题思路：
1. 先把所有数字放入 HashSet，利用其 O(1) 的查找效率判断某个数字是否存在。
2. 只有当 num - 1 不存在时，当前数字 num 才可能是连续序列的起点。
3. 从这个起点开始不断检查 num + 1、num + 2 是否存在，统计当前连续序列长度。
4. 在遍历过程中更新最长长度，最终返回结果。

时间复杂度：O(n)。
空间复杂度：O(n)。
*/
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        for (int num : numSet) {
            if (numSet.contains(num - 1)) {
                continue;
            }

            int currentNum = num;
            int currentLength = 1;

            while (numSet.contains(currentNum + 1)) {
                currentNum++;
                currentLength++;
            }

            longest = Math.max(longest, currentLength);
        }

        return longest;
    }
}
