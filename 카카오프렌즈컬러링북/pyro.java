import java.util.*;

class Solution {
    private int m;
    private int n;
    private int[][] picture;
    private boolean[][] visited;
    private Queue<Node> queue = new LinkedList<Node>();
    private static final Node[] moves = new Node[]{
        new Node(1, 0),
        new Node(-1, 0),
        new Node(0, 1),
        new Node(0, -1)
    };
    private static class Node {
        private final int i;
        private final int j;
        private Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int[] solution(int m, int n, int[][] picture) {
        this.m = m;
        this.n = n;
        this.picture = picture;
        this.visited = new boolean[m][n];

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] > 0 && !visited[i][j]) {
                    numberOfArea++;
                    int sizeOfOneArea = bfs(i, j);
                    maxSizeOfOneArea = Math.max(sizeOfOneArea, maxSizeOfOneArea);
                }
            }
        }
        return new int[]{numberOfArea, maxSizeOfOneArea};
    }

    private int bfs(int i, int j) {
        int sizeOfOneArea = 1;
        visited[i][j] = true;
        queue.add(new Node(i, j));
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            for(Node move: moves) {
                int movedI = current.i + move.i;
                int movedJ = current.j + move.j;
                if(movedI >= 0 && movedJ >= 0 && movedI < m && movedJ < n
                && !visited[movedI][movedJ] && picture[movedI][movedJ] == picture[i][j]) {
                    queue.add(new Node(movedI, movedJ));
                    visited[movedI][movedJ] = true;
                    sizeOfOneArea++;
                }
            }
        }
        return sizeOfOneArea;
    }
}
