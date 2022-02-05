package com.example.programmers.신고결과받기;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Solution {
    private final Map<String, Set<String>> reportHistory = new HashMap<>();
    private final Map<String, Set<String>> reportedHistory = new HashMap<>();

    private int[] calc(String[] id_list, int K) {
        int[] result = new int[id_list.length];

        int idx = 0;
        for (String id : id_list) {
            result[idx++] = getBanned(reportHistory.getOrDefault(id, new HashSet<>()), K);
        }

        return result;
    }

    private int getBanned(Set<String> reportIds, int K) {
        int banCount = 0;

        for (String reportId : reportIds) {
            int reportCount = reportedHistory.get(reportId)
                                             .size();
            if (reportCount >= K) {
                banCount++;
            }
        }
        return banCount;
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        for(String r : report){
            int emptyIdx = r.indexOf(" ");
            String userId= r.substring(0, emptyIdx);
            String reportedId = r.substring(emptyIdx+1);

            Set<String> reportSet = reportHistory.getOrDefault(
                    userId,
                    new HashSet<>()
            );
            reportSet.add(reportedId);
            reportHistory.put(userId, reportSet);

            Set<String> reportedSet = reportedHistory.getOrDefault(
                    reportedId,
                    new HashSet<>()
            );
            reportedSet.add(userId);
            reportedHistory.put(reportedId, reportedSet);
        }

        return calc(id_list, k);
    }

    @Test
    void test() {
        assertArrayEquals(new int[]{2,1,1,0}, new Solution().solution(
                new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},
                2
        ));
    }
}