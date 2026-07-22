class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>(); // (neighbor, time)

        for (int[] time : times) {
            int ui = time[0], vi = time[1], ti = time[2];
            adj.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[] {vi, ti});
        }

        Queue<int[]> minHeap = new PriorityQueue<>((n1, n2) -> n1[0] - n2[0]); // (total time, node)
        minHeap.add(new int[] {0, k});

        Set<Integer> visited = new HashSet<>();
        int t = 0;

        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.remove();
            int t1 = cur[0], n1 = cur[1];

            if (visited.contains(n1)) {
                continue;
            }
            visited.add(n1);

            t = t1;

            if (adj.containsKey(n1)) {
                for (int[] neighbor : adj.get(n1)) {
                    int n2 = neighbor[0], t2 = neighbor[1];
                    if (!visited.contains(n2)) {
                        minHeap.add(new int[] {t1 + t2, n2});
                    }
                }
            }
        }
        return visited.size() == n ? t : -1;
    }
}
