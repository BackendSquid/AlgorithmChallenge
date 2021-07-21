class Solution {
    
    private boolean[][] visited;
    private int[][] picture;
    private int numberOfArea = 0;
    private int maxSizeOfOneArea = 0;
    private int m;
    private int n;
    
    public int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        
        visited = new boolean[m][n];
        
        this.picture = picture;
        this.m = m;
        this.n = n;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, travel(i, j, picture[i][j]));
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    private int travel(int i, int j, int space) {
        if (i < 0 || i >= m  || j < 0 || j >= n) {
            return 0;
        }
        
        if (visited[i][j] || picture[i][j] != space) {
            return 0;
        }
        
        visited[i][j] = true;
        
        return 1 
            + travel(i - 1, j, space) 
            + travel(i, j - 1, space) 
            + travel(i + 1, j, space) 
            + travel(i, j + 1, space);
    }
}
