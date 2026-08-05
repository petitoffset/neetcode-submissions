class Solution {
    // Recursive Hierholzer
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> flight : tickets) {
            String src = flight.get(0);
            String dest = flight.get(1);
            adj.computeIfAbsent(src, key -> new PriorityQueue<String>()).offer(dest);
            adj.putIfAbsent(dest, new PriorityQueue<>());
        }
        List<String> path = new ArrayList<String>();
        dfs("JFK", adj, path);
        Collections.reverse(path);
        return path;
    }

    private void dfs(String src, Map<String, PriorityQueue<String>> adj, List<String> path) {
        PriorityQueue<String> neighbours = adj.get(src);
        while (!neighbours.isEmpty()) {
            String dest = neighbours.poll();
            dfs(dest, adj, path);
        }
        path.add(src);
    }
}
