class Solution {
    private Map<Integer, Integer> par;
    private Map<Integer, Integer> rank;

    public int countComponents(int n, int[][] edges) {
        initializeUnionFind(n);
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        Set<Integer> roots = new HashSet<>();
        for (int root : par.values()) {
            roots.add(root);
        }
        return roots.size();
    }

    public void initializeUnionFind(int n) {
        par = new HashMap<>();
        rank = new HashMap<>();

        for (int i = 0; i < n; i++) {
            par.put(i, i);
            rank.put(i, 0);
        }
    }

    public int find(int n) {
        int p = par.get(n);
        while (p != par.get(p)) {
            par.put(p, par.get(par.get(p))); 
            p = par.get(p);
        }
        return p;
    }

    public void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        if (p1 != p2) {
            if (rank.get(p1) > rank.get(p2)) {
                par.put(p2, p1);
            } else if (rank.get(p1) < rank.get(p2)) {
                par.put(p1, p2);
            } else {
                par.put(p1, p2);
                rank.put(p2, rank.get(p2) + 1);
            }
        }
    }
}


