
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;

        int[] diff = new int[n];
        int maxDiff = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
            sum += diff[i];
        }

        if (sum <= k) return 0;

        int low = 0, high = maxDiff;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long needed = 0;

            for (int d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int limit = low;
        long result = 0;
        long used = 0;

        for (int d : diff) {
            int reduced = Math.min(d, limit);
            result += (long) reduced * reduced;
            used += d - reduced;
        }

        long remaining = k - used;

        for (int i = 0; i < n && remaining > 0; i++) {
            if (diff[i] >= limit && limit > 0) {
                result -= (long) limit * limit;
                result += (long) (limit - 1) * (limit - 1);
                remaining--;
            }
        }

        return result;
    }
}
