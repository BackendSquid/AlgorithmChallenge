import java.util.*;

class Solution {
    private int x = 0;
    private int y = 0;
    public int solution(String dirs) {
        x = 0;
        y = 0;
        
        Set<Line> movedLine = new HashSet<>();
        for (char d : dirs.toCharArray()) {
            if (!canMove(d)) {
                continue;
            }
            movedLine.add(getNextLineAndMove(d));
        }
        
        return movedLine.size();
    }
    
    private boolean canMove(char direction) {
        if (direction == 'U') {
            return y < 5;
        }
        if (direction == 'D') {
            return y > -5;
        }
        if (direction == 'R') {
            return x < 5;
        }
        if (direction == 'L') {
            return x > -5;
        }
        throw new AssertionError();
    }
    
    private Line getNextLineAndMove(char direction) {
        if (direction == 'U') {
            return new Line(x, y, x, ++y);
        }
        if (direction == 'D') {
            return new Line(x, y, x, --y);
        }
        if (direction == 'R') {
            return new Line(x, y, ++x, y);
        }
        if (direction == 'L') {
            return new Line(x, y, --x, y);
        }
        throw new AssertionError(); 
    }
    
    private static class Line {
        private final Integer x0;
        private final Integer y0;
        private final Integer x1;
        private final Integer y1;
        
        private Line(int x0, int y0, int x1, int y1) {
            this.x0 = Integer.min(x0, x1);
            this.y0 = Integer.min(y0, y1);
            this.x1 = Integer.max(x0, x1);
            this.y1 = Integer.max(y0, y1);
        }
        
        @Override
        public boolean equals(Object obj) {
            Line l = (Line) obj;
            return x0 == l.x0 && y0 == l.y0 && x1 == l.x1 && y1 == l.y1;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x0, y0, x1, y1);
        }
    }
}
