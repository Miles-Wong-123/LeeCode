/*
解题思路：
1. 字母异位词排序后一定会得到相同的字符串，因此可以把排序后的结果作为分组 key。
2. 遍历数组中的每个字符串，转成字符数组后排序，再放入 HashMap 对应的列表中。
3. 最后返回 HashMap 中所有分组即可。

时间复杂度：O(n * k log k)，其中 n 是字符串个数，k 是单个字符串的平均长度。
空间复杂度：O(n * k)。
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(groups.values());
    }
}
