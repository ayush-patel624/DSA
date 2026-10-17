import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        for (int num : nums) {
            pq.offer(new int[]{digitSum(num), num});
        }

        int[] sorted = new int[n];
        int idx = 0;

        while (!pq.isEmpty()) {
            sorted[idx++] = pq.poll()[1];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != sorted[i]) {
                swaps++;

                int j = map.get(sorted[i]);

                map.put(nums[i], j);
                map.put(sorted[i], i);

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        return swaps;
    }

    private int digitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}