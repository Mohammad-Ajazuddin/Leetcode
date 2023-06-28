class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // Step 1: Create adjacency list
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            double p = succProb[i];
            graph.get(a).add(new Node(b, p));
            graph.get(b).add(new Node(a, p));
        }

        // Step 2: Initialize data structures
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(b.probability, a.probability));
        double[] probabilities = new double[n];
        Arrays.fill(probabilities, 0);
        probabilities[start] = 1;
        pq.offer(new Node(start, 1));

        // Step 3: Dijkstra's algorithm
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int node = curr.node;
            double prob = curr.probability;
            if (node == end) {
                return prob;
            }

            for (Node neighbor : graph.get(node)) {
                int nextNode = neighbor.node;
                double edgeProb = neighbor.probability;
                double newProb = prob * edgeProb;
                if (newProb > probabilities[nextNode]) {
                    probabilities[nextNode] = newProb;
                    pq.offer(new Node(nextNode, newProb));
                }
            }
        }

        // Step 6: No path found
        return 0;
    }

    private static class Node {
        int node;
        double probability;

        public Node(int node, double probability) {
            this.node = node;
            this.probability = probability;
        }
    }
}
