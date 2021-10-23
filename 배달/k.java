import java.util.*;
class Solution {
    
    private Map<Integer, List<int[]>> graph;
    private int[] dist;
    private boolean[] visited;
    public int solution(int N, int[][] road, int K) {
        graph = buildGraph(road);
        dist = new int[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(dist, 500_001);
        dist[1] = 0;
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparing((int[] a) -> a[1]));
        queue.add(new int[]{1, 0});
        
        while(!queue.isEmpty()) {
            int[] u = queue.poll();
            if (visited[u[0]]) continue;
            visited[u[0]] = true;
            
            List<int[]> edges = graph.get(u[0]);
            for(int[] edge : edges) {
                int v = edge[0];
                if (visited[v]) continue;
                int alt = dist[u[0]] + edge[1];
                if (alt < dist[v]) {
                    dist[v] = alt;
                    queue.add(new int[]{v, dist[v]});
                }54
            }
        }
        
        int answer = 0;
        for(int d : dist) {
            if (d <= K) {
                answer++;
            }
        }

        return answer;
    }
    
    private Map<Integer, List<int[]>> buildGraph(int[][] roads) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] road : roads) {
            int start = road[0];
            int end = road[1];
            int weight = road[2];
            addEdge(start, end, weight, graph);
            addEdge(end, start, weight, graph);
        }
        return graph;
    }
    
    private void addEdge(int node1, int node2, int weight, Map<Integer, List<int[]>> graph) {
        List<int[]> edges = graph.getOrDefault(node1, new ArrayList<>());
        edges.add(new int[]{node2, weight});
        graph.put(node1, edges);
    }
}
