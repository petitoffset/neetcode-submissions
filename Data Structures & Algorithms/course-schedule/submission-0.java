class Solution {
    Set<Integer> noPrerequisites;
    Set<Integer> possible;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        noPrerequisites = new HashSet<>();
        possible = new HashSet<>();
        for (int[] edge : prerequisites) {
            if (edge[0] == edge[1]) {
                return false;
            }
        }
        for (int i = 0; i < numCourses; i++) {
            noPrerequisites.add(i);
        }
        Map<Integer, List<Integer>> adjList = buildGraph(prerequisites);
        Set<Integer> visited = new HashSet<>();
        if (noPrerequisites.isEmpty()) {
            return false;
        }
        for (Integer course : noPrerequisites) {
            if (!dfs(course, adjList, visited)) {
                return false;
            }
        }
        return possible.size() == numCourses;
    }

    public Map<Integer, List<Integer>> buildGraph(int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : prerequisites) {
            int dst = edge[0];
            int src = edge[1];
            noPrerequisites.remove(dst);
            if (!adjList.containsKey(src)) {
                adjList.put(src, new ArrayList<Integer>());
            }
            if (!adjList.containsKey(dst)) {
                adjList.put(dst, new ArrayList<Integer>());
            }
            adjList.get(src).add(dst);
        }
        return adjList;
    }

    public boolean dfs(int node, Map<Integer, List<Integer>> adjList, Set<Integer> visited) {
        if (visited.contains(node)) {
            return false;
        }
        if (possible.contains(node)) {
            return true;
        }
        possible.add(node);
        visited.add(node);
        if (adjList.get(node) != null) {
            for (int next : adjList.get(node)) {
                if(!dfs(next, adjList, visited)) {
                    return false;
                }
            }   
        }
        visited.remove(node);
        return true;
    }
}
