/*
解题思路：
1. 使用双端队列保存数组下标，并让队列中对应的值保持单调递减。
2. 遍历每个位置 right 时，先移除队尾所有小于等于 nums[right] 的下标，因为它们不可能再成为后续窗口最大值。
3. 将 right 加入队尾后，如果队头下标已经离开当前窗口，就从队头移除。
4. 当窗口长度达到 k 时，队头下标对应的值就是当前窗口最大值，写入结果数组。
5. 遍历结束后返回所有窗口最大值。

时间复杂度：O(n)。
空间复杂度：O(k)。
*/
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int right = 0; right < nums.length; right++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[right]) {
                deque.pollLast();
            }

            deque.offerLast(right);

            int left = right - k + 1;
            if (deque.peekFirst() < left) {
                deque.pollFirst();
            }

            if (left >= 0) {
                result[left] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
