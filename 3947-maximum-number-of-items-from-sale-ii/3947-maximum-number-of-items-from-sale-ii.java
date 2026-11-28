
import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int[] freq = new int[n + 1];
        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            freq[item[0]]++;
            minPrice = Math.min(minPrice, item[1]);
        }

        int[] free = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int count = 0;

            for (int j = i; j <= n; j += i) {
                count += freq[j];
            }

            free[i] = count - 1;
        }

        long[] order = new long[n];

        for (int i = 0; i < n; i++) {
            order[i] = (long) items[i][1] * (n + 1) + i;
        }

        Arrays.sort(order);

        long remaining = budget;
        long bonus = 0;

        for (long key : order) {
            int idx = (int)(key % (n + 1));
            long price = items[idx][1];

            if (price > 2L * minPrice) break;
            if (remaining < price) break;

            long take = Math.min((long) free[items[idx][0]], remaining / price);

            bonus += take;
            remaining -= take * price;
        }

        return (int)(2 * bonus + remaining / minPrice);
    }
}
