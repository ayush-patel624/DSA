class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        PriorityQueue<int[]> free = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0])
                    return a[0] - b[0];
                return a[1] - b[1];
            }
        );

        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0])
                    return Long.compare(a[0], b[0]);
                if (a[1] != b[1])
                    return Long.compare(a[1], b[1]);
                return Long.compare(a[2], b[2]);
            }
        );

        for (int i = 0; i < servers.length; i++) {
            free.add(new int[]{servers[i], i});
        }

        int[] res = new int[tasks.length];

        long time = 0;

        for (int i = 0; i < tasks.length; i++) {

            time = Math.max(time, i);

            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] server = busy.remove();

                free.add(new int[]{
                    (int) server[1],
                    (int) server[2]
                });
            }

            if (free.isEmpty()) {
                time = busy.peek()[0];

                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    long[] server = busy.remove();

                    free.add(new int[]{
                        (int) server[1],
                        (int) server[2]
                    });
                }
            }

            int[] server = free.remove();

            res[i] = server[1];

            busy.add(new long[]{
                time + tasks[i],
                server[0],
                server[1]
            });
        }

        return res;
    }
}