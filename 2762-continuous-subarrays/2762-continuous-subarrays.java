
import java.util.*;

class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long res = 0;

        Deque<Integer> min = new ArrayDeque<>();
        Deque<Integer> max = new ArrayDeque<>();

        int low = 0;

        for (int high = 0; high < n; high++) {
            while (!min.isEmpty() && nums[min.peekLast()] > nums[high]) {
                min.pollLast();
            }
            min.offerLast(high);

            while (!max.isEmpty() && nums[max.peekLast()] < nums[high]) {
                max.pollLast();
            }
            max.offerLast(high);

            while (nums[max.peekFirst()] - nums[min.peekFirst()] > 2) {
                low++;

                if (min.peekFirst() < low) {
                    min.pollFirst();
                }

                if (max.peekFirst() < low) {
                    max.pollFirst();
                }
            }

            res += high - low + 1;
        }

        return res;
    }
}
