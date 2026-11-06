
import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int k = queries.length;
        int[] ans = new int[k];

        Integer[] idx = new Integer[k];
        for (int i = 0; i < k; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, (a, b) ->
            Integer.compare(queries[a], queries[b]));

        int[] freq = new int[n + 1];
        int active = 0;

        int left = 0, right = 0;

        for (int id : idx) {

            int q = queries[id];
            int start = q - x;

            while (right < logs.length && logs[right][1] <= q) {
                int server = logs[right][0];

                if (freq[server] == 0) {
                    active++;
                }

                freq[server]++;
                right++;
            }

            while (left < right && logs[left][1] < start) {
                int server = logs[left][0];

                freq[server]--;

                if (freq[server] == 0) {
                    active--;
                }

                left++;
            }

            ans[id] = n - active;
        }

        return ans;
    }
}
