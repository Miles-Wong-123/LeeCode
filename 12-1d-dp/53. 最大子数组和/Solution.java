/*
解题思路：
1. 使用动态规划，currentMax 表示以当前位置结尾的连续子数组最大和。
2. 遍历每个数字时，要么把当前数字接在前面的子数组后面，要么从当前数字重新开始。
3. 因此状态转移为 currentMax = max(num, currentMax + num)。
4. 用 maxSum 记录遍历过程中出现过的最大 currentMax。
5. 遍历结束后返回 maxSum。

时间复杂度：O(n)。
空间复杂度：O(1)。
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int currentMax = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSum = Math.max(maxSum, currentMax);
        }

        return maxSum;
    }
}
