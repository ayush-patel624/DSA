
class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] row : edges) {
            int u = row[0];
            int v = row[1];
            int w = row[2];

            adj.get(u).add(new int[]{v, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[][] dist = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[0][1] = 0;
        pq.add(new int[]{0, 0, 1});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int d = curr[0];
            int u = curr[1];
            int count = curr[2];

            if (d != dist[u][count]) continue;

            if (u == n - 1) return d;

            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int w = edge[1];

                int newCount;

                if (labels.charAt(u) == labels.charAt(v)) {
                    newCount = count + 1;
                } else {
                    newCount = 1;
                }

                if (newCount > k) continue;

                int newDist = d + w;

                if (newDist < dist[v][newCount]) {
                    dist[v][newCount] = newDist;
                    pq.add(new int[]{newDist, v, newCount});
                }
            }
        }

        return -1;
    }
}
