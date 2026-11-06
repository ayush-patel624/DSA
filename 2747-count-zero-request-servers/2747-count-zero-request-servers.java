import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, Comparator.comparingInt(a -> a[1]));
        
        int[][] orderedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            orderedQueries[i][0] = queries[i];
            orderedQueries[i][1] = i;
        }
        
        Arrays.sort(orderedQueries, Comparator.comparingInt(a -> a[0]));
        
        int[] result = new int[queries.length];
        int[] count = new int[n + 1];
        int left = 0;
        int right = 0;
        int active = 0;
        
        for (int[] query : orderedQueries) {
            int time = query[0];
            
            while (right < logs.length && logs[right][1] <= time) {
                int server = logs[right][0];
                if (count[server]++ == 0) {
                    active++;
                }
                right++;
            }
            
            while (left < right && logs[left][1] < time - x) {
                int server = logs[left][0];
                if (--count[server] == 0) {
                    active--;
                }
                left++;
            }
            
            result[query[1]] = n - active;
        }
        
        return result;
    }
}
