class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>(); // (neighbor, time)
        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : times) {
            int ui = edge[0], vi = edge[1], ti = edge[2];
            adj.get(ui).add(new int[]{vi, ti});
        }

        Map<Integer, Integer> shortest = new HashMap<>(); // {node, time}
        Queue<int[]> minHeap = new PriorityQueue<>((n1, n2) -> n1[0] - n2[0]); // (total time, node)
        minHeap.add(new int[]{0, k});
        
        while(!minHeap.isEmpty()) {
            int[] cur = minHeap.remove();
            int t1 = cur[0], n1 = cur[1];

            if (shortest.containsKey(n1)) {
                continue;
            }
            shortest.put(n1, t1);
            for (int[] neighbor : adj.get(n1)) {
                int n2 = neighbor[0], t2 = neighbor[1];
                if (!shortest.containsKey(n2)) {
                    minHeap.add(new int[]{t1 + t2, n2});
                }
            }
        }  
        System.out.println(shortest);
        if (shortest.size() != n) {
            return -1;
        }
        return Collections.max(shortest.values());
    }
}
