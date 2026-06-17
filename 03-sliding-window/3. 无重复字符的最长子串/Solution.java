/*
解题思路：
1. 使用滑动窗口维护一个不包含重复字符的子串，left 表示窗口左边界。
2. 用数组记录每个字符上一次出现的位置，初始值为 -1。
3. 遍历字符串时，如果当前字符已经在窗口内出现过，就把 left 移动到上一次出现位置的右侧。
4. 每次处理完当前字符后，更新它的最新位置，并用当前窗口长度更新最大值。
5. 遍历结束后返回最大长度。

时间复杂度：O(n)。
空间复杂度：O(1)。
*/
import java.util.Arrays;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[128];
        Arrays.fill(lastIndex, -1);

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            if (lastIndex[current] >= left) {
                left = lastIndex[current] + 1;
            }

            lastIndex[current] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
