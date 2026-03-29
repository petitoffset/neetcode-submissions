class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n == 0) return true;
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];
            //if (src == dst) return false;
            adjList.computeIfAbsent(src, ArrayList::new);
            adjList.computeIfAbsent(dst, ArrayList::new);
            adjList.get(src).add(dst);
            adjList.get(dst).add(src);
        }
        HashSet<Integer> visited = new HashSet<>();
        if (!dfs(0, -1, adjList, visited)) {
            return false;
        }
        
        return visited.size() == n;
    }

    public boolean dfs(int node, int parent, HashMap<Integer, ArrayList<Integer>> adjList, HashSet<Integer> visited) {
        if (visited.contains(node)) {
            return false;
        }
        visited.add(node);

        for (int neighbor : adjList.get(node)) {
            if (neighbor != parent) {
                if (!dfs(neighbor, node, adjList, visited)) {
                    return false;
                }
            }
        }
        return true;
    }
}
