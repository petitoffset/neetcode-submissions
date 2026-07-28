class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>(); // src : [dst, price]
        for (int i = 0; i < flights.length; i++) {
            adj.computeIfAbsent(flights[i][0], key -> new ArrayList<>())
                .add(new int[] {flights[i][1], flights[i][2]});
        }

        Queue<int[]> minHeap =
            new PriorityQueue<>((n1, n2) -> (n1[0] - n2[0])); //[price, node, flightUsed]
        minHeap.offer(new int[] {0, src, 0});

        int maxFlights = k + 1;

        boolean[][] visited = new boolean[n][maxFlights + 1]; // (node, flightUsed)

        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int price1 = cur[0], node1 = cur[1], flightUsed = cur[2];

            if (visited[node1][flightUsed]) {
                continue;
            }

            if (node1 == dst) {
                return price1;
            }

            visited[node1][flightUsed] = true;
            if (adj.containsKey(node1)) {
                for (int[] next : adj.get(node1)) {
                    int node2 = next[0], price2 = next[1];
                    if (flightUsed + 1 <= maxFlights && !visited[node2][flightUsed + 1]) {
                        minHeap.offer(new int[] {price1 + price2, node2, flightUsed + 1});
                    }
                }
            }
        }
        return -1;
    }
}
