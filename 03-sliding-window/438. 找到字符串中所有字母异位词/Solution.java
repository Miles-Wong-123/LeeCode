/*
解题思路：
1. 异位词要求字符种类和出现次数完全相同，因此可以用长度为 26 的数组记录字符频次。
2. 先统计字符串 p 的字符频次，再用固定长度为 p.length() 的滑动窗口遍历字符串 s。
3. 每次右边界加入一个字符，如果窗口长度超过 p.length()，就移除左边界字符。
4. 当窗口长度等于 p.length() 时，比较窗口频次和 p 的频次；如果完全一致，就记录当前窗口起始索引。
5. 遍历结束后返回所有起始索引。

时间复杂度：O(n * 26)，其中 n 是字符串 s 的长度。
空间复杂度：O(1)。
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }

        int[] targetCount = new int[26];
        int[] windowCount = new int[26];

        for (int i = 0; i < p.length(); i++) {
            targetCount[p.charAt(i) - 'a']++;
        }

        for (int right = 0; right < s.length(); right++) {
            windowCount[s.charAt(right) - 'a']++;

            if (right >= p.length()) {
                int leftCharIndex = s.charAt(right - p.length()) - 'a';
                windowCount[leftCharIndex]--;
            }

            if (right >= p.length() - 1 && Arrays.equals(windowCount, targetCount)) {
                result.add(right - p.length() + 1);
            }
        }

        return result;
    }
}
