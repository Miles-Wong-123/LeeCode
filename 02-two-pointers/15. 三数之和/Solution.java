/*
解题思路：
1. 先对数组排序，这样相同数字会相邻，也方便使用双指针寻找另外两个数。
2. 枚举第一个数 nums[i]，如果它和前一个数相同，就跳过，避免产生重复三元组。
3. 对每个 i，使用 left 和 right 分别指向 i 右侧区间的两端，根据三数之和与 0 的大小移动指针。
4. 找到和为 0 的三元组后加入结果，并跳过 left 和 right 位置上的重复数字。
5. 遍历结束后返回所有不重复的三元组。

时间复杂度：O(n^2)。
空间复杂度：O(1)，不考虑返回结果占用的空间。
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] > 0) {
                break;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
