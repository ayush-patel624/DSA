
import java.util.HashSet;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int low = 0;
        int high = 0;

        long sum = 0;
        long res = 0;

        HashSet<Integer> set = new HashSet<>();

        while (high < n) {
            while (set.contains(nums[high])) {
                sum -= nums[low];
                set.remove(nums[low]);
                low++;
            }

            sum += nums[high];
            set.add(nums[high]);
            high++;

            if (high - low == k) {
                res = Math.max(res, sum);

                sum -= nums[low];
                set.remove(nums[low]);
                low++;
            }
        }

        return res;
    }
}
