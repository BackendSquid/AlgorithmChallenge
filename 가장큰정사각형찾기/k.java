class Solution {
  public int solution(int [][]board) {
      int width = getMaxWidth(board);
      
      return width * width;
  }
  
  private int[][] buildSizeTable(int row, int col) {
      return new int[row + 1][col + 1];
  }
  
  private int getMaxWidth(int[][] board) {
      int row = board.length;
      int col = board[0].length;

      int[][] sizeTable = buildSizeTable(row, col);
      
      int maxWidth = 0;
      for (int r = 0; r < row; r++) {
          maxWidth = Integer.max(maxWidth, calculateMaxWidthInBoardRow(board, sizeTable, r));
      }
      
      return maxWidth;
  }
  
  private int calculateMaxWidthInBoardRow(int[][] board, int[][] sizeTable, int r) {
      int rIndex = r + 1;
      int colSize = board[r].length;
      
      int maxWidth = 0;
      int[] boardRow = board[r];
      
      int[] sizeTableRow = sizeTable[rIndex];
      int[] sizeTablePrevRow = sizeTable[rIndex - 1];
      
      for (int c = 0; c < colSize; c++) {
          if (boardRow[c] == 0) {
              continue;
          }

          int cIndex = c + 1;
          int width = min(
              sizeTableRow[cIndex - 1], 
              sizeTablePrevRow[cIndex], 
              sizeTablePrevRow[cIndex - 1]) + 1;
          sizeTableRow[cIndex] = width;
          
          maxWidth = Integer.max(maxWidth, width);
      }
      
      return maxWidth;
  }
  
  private int min(int a, int b, int c) {
      return Integer.min(a, Integer.min(b, c));
  }
}
