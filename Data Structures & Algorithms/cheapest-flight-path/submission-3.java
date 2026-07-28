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

        int[] minFlightsUsed = new int[n];
        Arrays.fill(minFlightsUsed, Integer.MAX_VALUE);

        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int price1 = cur[0], node1 = cur[1], flightsUsed = cur[2];

            if (flightsUsed >= minFlightsUsed[node1]) {
                continue;
            }

            if (node1 == dst) {
                return price1;
            }

            minFlightsUsed[node1] = flightsUsed;

            if (adj.containsKey(node1)) {
                for (int[] next : adj.get(node1)) {
                    int node2 = next[0], price2 = next[1];
                    if (flightsUsed + 1 <= maxFlights && flightsUsed + 1 < minFlightsUsed[node2]) {
                        minHeap.offer(new int[] {price1 + price2, node2, flightsUsed + 1});
                    }
                }
            }
        }
        return -1;
    }
}
