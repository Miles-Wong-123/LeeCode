/*
解题思路：
1. 使用左右两个指针分别从数组两端向中间移动，并维护 leftMax 和 rightMax。
2. 某个位置能接的雨水由它左右两侧较小的最大高度决定。
3. 如果 leftMax 小于 rightMax，说明左侧当前位置的接水量已经可以确定，处理 left 后右移。
4. 否则处理 right 位置，并将右指针左移。
5. 在移动过程中累加每个位置能接的雨水量，最终返回总量。

时间复杂度：O(n)。
空间复杂度：O(1)。
*/
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                water += leftMax - height[left];
                left++;
            } else {
                water += rightMax - height[right];
                right--;
            }
        }

        return water;
    }
}
