/*
解题思路：
1. 使用左右两个指针分别指向数组两端，此时容器宽度最大。
2. 当前容器的水量由较短的线决定，面积为 min(height[left], height[right]) * (right - left)。
3. 每次移动较短线对应的指针，因为继续保留短板只会让宽度变小，面积不可能变大。
4. 在移动过程中不断更新最大面积，最终返回结果。

时间复杂度：O(n)。
空间复杂度：O(1)。
*/
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, width * currentHeight);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
