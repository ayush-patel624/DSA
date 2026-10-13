import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int j = 0; j < k; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
        }

        res[0] = calculateSum(map, x);

        for (int i = 1; i <= n - k; i++) {
            int outgoing = nums[i - 1];

            if (map.get(outgoing) == 1) {
                map.remove(outgoing);
            } else {
                map.put(outgoing, map.get(outgoing) - 1);
            }

            int incoming = nums[i + k - 1];
            map.put(incoming, map.getOrDefault(incoming, 0) + 1);

            res[i] = calculateSum(map, x);
        }

        return res;
    }

    private int calculateSum(HashMap<Integer, Integer> map, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(b[0], a[0]);
            }
            return Integer.compare(b[1], a[1]);
        });

        for (int num : map.keySet()) {
            pq.offer(new int[]{map.get(num), num});
        }

        int sum = 0;

        for (int i = 0; i < x && !pq.isEmpty(); i++) {
            int[] curr = pq.poll();
            sum += curr[0] * curr[1];
        }

        return sum;
    }
}