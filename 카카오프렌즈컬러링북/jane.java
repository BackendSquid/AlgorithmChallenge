import java.util.*;

class Solution {

    private static boolean[][] visited;
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int bfs(int x, int y, int[][] picture, int m, int n) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        visited[x][y] = true;
        int sum = 1;

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();

            int nextX, nextY;
            for (int i = 0; i < 4; i++) {
                nextX = pair.x + dx[i];
                nextY = pair.y + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n && !visited[nextX][nextY]
                        && picture[pair.x][pair.y] == picture[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.add(new Pair(nextX, nextY));
                    sum++;
                }
            }
        }
        return sum;
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j, picture, m, n));
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
