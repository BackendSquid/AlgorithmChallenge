package com.example.programmers.레벨2.방문길이;

public class Solution {
    static final int MAX_N = 11;
    static int startRow = 5;
    static int startCol = 5;
    static boolean[][][][] visited = new boolean[MAX_N][MAX_N][MAX_N][MAX_N];

    public int solution(String dirs) {
        int answer = 0; // 처음 걸어본 길의 길이
        for (String dir : dirs.split("")) {
            answer += move(startRow, startCol, directionFrom(dir));
        }
        return answer;
    }

    private int move(int sRow, int sCol, int[] direction) {
        int nCol = sCol + direction[0];
        int nRow = sRow + direction[1];

        // 경계 벗어날 때
        if (nRow < 0 || nCol < 0 || nRow > MAX_N-1 || nCol > MAX_N-1) {
            return 0;
        }
        if (visited[sRow][sCol][nRow][nCol] || visited[nRow][nCol][sRow][sCol]){
            startRow = nRow;
            startCol = nCol;
            return 0;
        }

        // 양방향
        visited[sRow][sCol][nRow][nCol] = true;
        visited[nRow][nCol][sRow][sCol] = true;

        startRow = nRow;
        startCol = nCol;
        return 1;
    }

    public int[] directionFrom(String command) {
        switch (command) {
            case "U":
                return new int[]{0, -1};
            case "D":
                return new int[]{0, 1};
            case "R":
                return new int[]{1, 0};
            case "L":
                return new int[]{-1, 0};
        }
        return null;
    }
}