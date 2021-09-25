package com.example.programmers.레벨2.올바른_괄호;

import java.util.Stack;

public class Solution {
    boolean solution(String s) {
        boolean answer = false;
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
