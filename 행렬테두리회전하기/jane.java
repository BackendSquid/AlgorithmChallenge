import java.util.Arrays;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows][columns];
        int data = 0;

        // 보드 채우기
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data++;
                matrix[i][j] = data;
            }
        }

        int index = 0;
        for (int[] query : queries) {
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;
            int removed = matrix[x1][y1];
            int min = removed;

            // 위로 밀기
            for (int x = x1; x < x2; x++) {
                int temp = matrix[x + 1][y1];
                matrix[x][y1] = temp;
                min = Math.min(min, temp);
            }

            // 왼쪽으로 밀기
            for (int y = y1; y < y2; y++) {
                int temp = matrix[x2][y + 1];
                matrix[x2][y] = temp;
                min = Math.min(min, temp);
            }

            // 아래로 밀기
            for (int x = x2; x > x1; x--) {
                int temp = matrix[x - 1][y2];
                matrix[x][y2] = temp;
                min = Math.min(min, temp);
            }

            // 우로 밀기
            for (int y = y2; y > y1; y--) {
                int temp = matrix[x1][y - 1];
                matrix[x1][y] = temp;
                min = Math.min(min, temp);
            }

            matrix[x1][y1 + 1] = removed;
            answer[index++] = min;
        }

        return answer;
    }
}
