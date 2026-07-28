class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>(); // src : [dst, price]
        for (int i = 0; i < flights.length; i++) {
            adj.computeIfAbsent(flights[i][0], key -> new ArrayList<>())
                .add(new int[] {flights[i][1], flights[i][2]});
        }

        Queue<int[]> minHeap =
            new PriorityQueue<>((n1, n2) -> (n1[0] - n2[0])); //[price, node, stops]
        minHeap.offer(new int[] {0, src, -1});

        boolean[][] visited = new boolean[n][k + 2]; // (node, usedStops)

        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int price1 = cur[0], node1 = cur[1], stops1 = cur[2];

            if (visited[node1][stops1 + 1]) {
                continue;
            }

            if (node1 == dst) {
                return price1;
            }

            visited[node1][stops1 + 1] = true;
            if (adj.containsKey(node1)) {
                for (int[] next : adj.get(node1)) {
                    int node2 = next[0], price2 = next[1];
                    if (!visited[node2][stops1 + 1] && stops1 + 1 <= k) {
                        minHeap.offer(new int[] {price1 + price2, node2, stops1 + 1});
                    }
                }
            }
        }
        return -1;
    }
}
