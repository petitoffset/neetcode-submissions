class Solution {
    Map<Integer, Integer> par = new HashMap<>();
    Map<Integer, Integer> rank = new HashMap<>();
    
    int[] res;
    public int[] findRedundantConnection(int[][] edges) {
        for (int i = 0; i <= edges.length; i++) {
            par.put(i, i);
            rank.put(i, 0);
        }

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                return res;
            }
        }
        return res;        
    }

    private int find(int n) {
        int p = par.get(n);
        while (p != par.get(p)) {
            p = par.get(p);
            par.put(p, par.get(par.get(p)));
        }
        return p;
    }

    private boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        if (p1 == p2) {
            res = new int[]{n1, n2};
            return false;
        }
        if (rank.get(p1) > rank.get(p2)) {
            par.put(p2, p1);
        } else if (rank.get(p2) > rank.get(p1)) {
            par.put(p1, p2);
        } else {
            par.put(p1, p2);
            rank.put(p2, rank.get(p2) + 1);
        }
        return true;
    }
}
