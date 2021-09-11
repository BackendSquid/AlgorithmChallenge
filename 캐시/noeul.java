package com.example.programmers.레벨2._1차캐시;

import java.util.*;

public class Solution {
    public int solution(int cacheSize, String[] cities) {

        final int cacheHitTime = 1;
        final int cacheMissTime = 5;

        int executeTime = 0;

        if (cacheSize == 0) {
            return cities.length * cacheMissTime;
        }

        Deque<String> cache = new ArrayDeque<>();


        for (String city : cities) {

            city = city.toUpperCase();

            if (cache.contains(city)) {
                executeTime += cacheHitTime;
                cache.remove(city);
                cache.add(city);
            } else if (cache.size() == cacheSize) {
                cache.pollFirst();
                cache.add(city);
                executeTime += cacheMissTime;
            } else{
                cache.add(city);
                executeTime += cacheMissTime;
            }

        }

        return executeTime;
    }

    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(new Solution().solution(cacheSize,cities));
    }
}
