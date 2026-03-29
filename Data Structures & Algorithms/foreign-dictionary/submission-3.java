class Solution {
    public String foreignDictionary(String[] words) {
        if (words.length == 1) {
            return words[0];
        }
        Map<Integer, List<Integer>> adj = new HashMap<>(); 
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }
            for (char c : w1.toCharArray()) {
                adj.putIfAbsent(c -'a', new ArrayList<>());
            }
            for (char c : w2.toCharArray()) {
                adj.putIfAbsent(c -'a', new ArrayList<>());
            }
            int l = Math.min(w1.length(), w2.length());
            for (int k = 0; k < l; k++) {
                if (w1.charAt(k) != w2.charAt(k)) {
                    adj.get(w2.charAt(k) - 'a').add(w1.charAt(k) - 'a');
                    break; 
                }
            }
        }

        List<Integer> topSort = new ArrayList<>();
        Set<Integer> visit = new HashSet<>();
        Set<Integer> path = new HashSet<>();
        for (int i : adj.keySet()) { 
            if (!dfs(i, adj, visit, path, topSort)) {
                return "";
            } 
        } 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < topSort.size(); i++) {
            sb.append((char) ((int)'a' + topSort.get(i)));
        }     
        return sb.toString();
    } 
    
    public static boolean dfs(int src, Map<Integer, List<Integer>> adj, Set<Integer> visit, Set<Integer> path, List<Integer> topSort) { 
        if (path.contains(src)) {
            return false;
        }
        if (visit.contains(src)) {
            return true; 
        } 
        visit.add(src); 
        path.add(src);
        if (adj.get(src) != null) {
            for (int neighbor : adj.get(src)) {
                if (!dfs(neighbor, adj, visit, path, topSort)) {
                    return false;
                } 
            } 
        }
        topSort.add(src); 
        path.remove(src);
        return true; 
    }
}
