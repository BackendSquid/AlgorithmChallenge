package com.example.programmers.레벨2.배달;

import java.util.*;

public class Noeul {

    private static Map<Integer, List<Edge>> graph;
    private static int[] distance;
    private static boolean[] visited;

    static class Edge{
        int vertex;
        int cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }

    public int solution(int N, int[][] road, int K) {
        initGraph(road);
        initDistance(N);
        dijkstra();

        return result(K);
    }

    private void initGraph(int[][] road) {
        graph = new HashMap<>();

        for (int[] town : road) {
            int vertex = town[0];
            int vertex2 = town[1];
            int cost = town[2];

            List<Edge> edgeList = graph.getOrDefault(vertex, new ArrayList<>());
            edgeList.add(new Edge(vertex2, cost));
            graph.put(vertex, edgeList);

            List<Edge> edgeList2 = graph.getOrDefault(vertex2, new ArrayList<>());
            edgeList2.add(new Edge(vertex, cost));
            graph.put(vertex2, edgeList2);
        }
    }

    private void initDistance(int N) {
        // 1번 마을과 떨어진 vertex간의 거리를 담는 배열
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
    }

    private void dijkstra() {
        PriorityQueue<Edge> heap = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);
        heap.add(new Edge(1, 0));

        while (!heap.isEmpty()) {

            Edge edge = heap.poll();
            int vertex = edge.vertex;
            int cost = edge.cost;

            if (visited[vertex] || distance[vertex] < cost) {
                continue;
            }

            visited[vertex] = true;

            List<Edge> edgeList = graph.get(vertex);
            for (int i = 0; i < edgeList.size(); i++) {
                int nextVertex = edgeList.get(i).vertex;
                int nextCost = edgeList.get(i).cost + cost; // 이전 cost 합

                if (distance[nextVertex] > nextCost) {
                    distance[nextVertex] = nextCost;
                    heap.add(new Edge(nextVertex, nextCost));
                }
            }
        }
    }

    private int result(int K) {
        int answer = 0;
        for (int cost : distance) {
            if (cost <= K) {
                answer++;
            }
        }
        return answer;
    }
}