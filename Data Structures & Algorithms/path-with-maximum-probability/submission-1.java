class Solution {
    class Node {
        int node;
        double prob;

        public Node(double prob, int node) {
            this.prob = prob;
            this.node = node;
        }
    }

    public double maxProbability(
        int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // create adj list
        Map<Integer, List<Node>> adj = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            adj.computeIfAbsent(edges[i][0], key -> new ArrayList<>())
                .add(new Node(succProb[i], edges[i][1]));
            adj.computeIfAbsent(edges[i][1], key -> new ArrayList<>())
                .add(new Node(succProb[i], edges[i][0]));
        }
        Queue<Node> maxHeap = new PriorityQueue<Node>((n1, n2) -> Double.compare(n2.prob, n1.prob));
        Set<Integer> visited = new HashSet<>();
        maxHeap.add(new Node(1, start_node));
        while (!maxHeap.isEmpty()) {
            Node cur = maxHeap.remove();
            double prob1 = cur.prob;
            int n1 = cur.node;
            if (visited.contains(n1)) {
                continue;
            }
            visited.add(n1);
            if (n1 == end_node) {
                return prob1;
            }
            if (adj.containsKey(n1)) {
                for (Node next : adj.get(n1)) {
                    double prob2 = next.prob;
                    int n2 = next.node;
                    if (!visited.contains(n2)) {
                        maxHeap.add(new Node(prob1 * prob2, n2));
                    }
                }
            }
        }
        return 0;
    }
}