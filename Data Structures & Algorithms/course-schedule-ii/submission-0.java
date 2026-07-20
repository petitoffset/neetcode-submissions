class Solution {
    private Map<Integer, List<Integer>> preMap = new HashMap<>();
    private Set<Integer> visiting = new HashSet<>();
    private List<Integer> res = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            preMap.get(pre[0]).add(pre[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (preMap.get(i).isEmpty()) {
                res.add(i);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return new int[0];
            }
        }
        return res.stream().mapToInt(i -> i).toArray();    
    }

    private boolean dfs(int crs) {
        if (visiting.contains(crs)) {
            return false;
        }
        if (preMap.get(crs).isEmpty()) {
            return true;
        }
        visiting.add(crs);
        for (int pre : preMap.get(crs)) {
            if (!dfs(pre)) {
                return false;
            }
        }
        visiting.remove(crs);
        preMap.put(crs, new ArrayList<>());
        res.add(crs);
        return true;
    }
}
