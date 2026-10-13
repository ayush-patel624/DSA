class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        int count = 1;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1] + 1) {
                count++;
            } else {
                count = 1;
            }

            if (i >= k - 1) {
                if (count >= k) {
                    res[i - k + 1] = nums[i];
                } else {
                    res[i - k + 1] = -1;
                }
            }
        }

        return res;
    }
}