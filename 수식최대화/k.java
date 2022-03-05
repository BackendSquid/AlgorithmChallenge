import java.util.*;
import java.util.regex.*;

class Solution {
    
    private char[][] priorities = new char[][]{
        {'*', '+', '-'},
        {'*', '-', '+'},
        {'+', '*', '-'},
        {'+', '-', '*'},
        {'-', '*', '+'},
        {'-', '+', '*'}
    };
    
    public long solution(String expression) {        
        Pattern p = Pattern.compile("\\d+|[*+-]");
        Pattern o = Pattern.compile("[*+-]");
        
        Matcher m = p.matcher(expression);
        
        List<Node> nodeList = new LinkedList<>();
        
        while (m.find()) {
            String token = m.group();
            
            if (o.matcher(token).matches()) {
                nodeList.add(new Operator(token.charAt(0)));
            } else {
                nodeList.add(new Num(Long.parseLong(token)));
            }
        }
        
        long answer = 0;
        for (char[] priority : priorities) {
            answer = Math.max(answer, calculateWithPriority(nodeList, priority));
        }
        
        return answer;
    }
    
    private long calculateWithPriority(List<Node> nodeList, char[] priority) {
        List<Node> list = nodeList;
        for (char operator : priority) {
            list = calculateOperator(list, operator);
        }
        
        return Math.abs(list.get(0).value());
    }
    
    private List<Node> calculateOperator(List<Node> nodeList, char operator) {
        List<Node> stack = new ArrayList<>();
        ListIterator<Node> it = nodeList.listIterator(); 
        while (it.hasNext()) {
            Node current = it.next();
            if (current.eq(operator)) {
                current.left(stack.remove(stack.size() - 1));
                current.right(it.next());
                stack.add(new Num(current.value()));
            } else {
                stack.add(current);
            }
        }
        
        return stack;
    }
}

interface Node {
    long value();
    void left(Node n);
    void right(Node n);
    boolean eq(char op);
}

class Num implements Node {
    private long value;
    public Num(long value) {
        this.value = value;
    }
    
    public long value() {
        return value;
    }
    
    public boolean eq(char op) {
        return false;
    }
    
    public void left(Node n) {
        return;
    }
    
    public void right(Node n) {
        return;
    }
    
    public String toString() {
        return String.valueOf(value);
    }
}

class Operator implements Node {
    private Node left;
    private Node right;
    private char op;
    
    public Operator(char op) {
        this.op = op;
    }
    
    public long value() {
        long lValue = left.value();
        long rValue = right.value();
        
        if (op == '*') {
            return lValue * rValue;
        }
        if (op == '+') {
            return lValue + rValue;
        }
        if (op == '-') {
            return lValue - rValue;
        }
        return 0;
    }
    
    public void left(Node n) {
        this.left = n;
    }
    
    public void right(Node n) {
        this.right = n;
    }
    
    public boolean eq(char op) {
        return this.op == op;
    }
    
    public String toString() {
        return String.valueOf(op);
    }
}
