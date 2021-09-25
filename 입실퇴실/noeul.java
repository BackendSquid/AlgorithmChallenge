package com.example.programmers.위클리챌린지.week7.입실퇴실;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    static int upperPoint = 0;
    static int lowerPoint = 0;

    public int[] solution(int[] enter, int[] leave) {

        final List<Integer> enteredList = new ArrayList<>();

        int[] result = new int[enter.length];

        while (upperPoint < (enter.length) && lowerPoint < (leave.length)) {
            if (enteredList.isEmpty()) {
                upper(enter, enteredList, result);
                lower(leave, enteredList);
            } else {
                lower(leave, enteredList);
                upper(enter, enteredList, result);
            }
        }

        return result;
    }

    private void upper(int[] enter, List<Integer> enteredList, int[] result) {
        if (upperPoint > enter.length - 1) {
            return;
        }

        int current = enter[upperPoint];

        result[current - 1] = enteredList.size();

        if (!enteredList.isEmpty()) {
            for (int entered : enteredList) {
                result[entered - 1]++;
            }
        }

        enteredList.add(current);
        upperPoint++;
    }

    private void lower(int[] leave, List<Integer> enteredList) {
        while (lowerPoint < leave.length - 1) {
            int current = leave[lowerPoint];

            if (!enteredList.contains(current)) break;
            enteredList.remove((Integer) current);

            lowerPoint++;
        }
    }
}