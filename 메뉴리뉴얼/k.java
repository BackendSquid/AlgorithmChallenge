import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        Map<Integer, Map<String, Integer>> courseCandidateCounters = initCourseCandidateCounters(course);
        
        for(String order : orders) {
            String[] orderItems = toOrderItems(order);
            countCourseCandidates(orderItems, course, courseCandidateCounters);
        }
        
        List<String> result = new ArrayList<>();
        
        for(int c : course) {
            Map<String, Integer> counter = courseCandidateCounters.get(c);
            Map<Integer, List<String>> l = new HashMap<>();
            
            // collect by count
            for (Map.Entry<String, Integer> e : counter.entrySet()) {
                Integer count = e.getValue();
                if(count >= 2) {
                    List<String> list = l.getOrDefault(count, new ArrayList<>());
                    list.add(e.getKey());
                    l.put(count, list);
                }
            }
    
            // get max count and add to result
            if (l.size() > 0) {
                Integer maxCount = l.keySet().stream().max(Comparator.naturalOrder()).get();
                result.addAll(l.get(maxCount));
            }
        }
        
        return result.stream().sorted().toArray(String[]::new);
    }
    
    private String[] toOrderItems(String order) {
        return Arrays.stream(order.split(""))
            .sorted()
            .toArray(String[]::new);
    }
    
    private Map<Integer, Map<String, Integer>> initCourseCandidateCounters(int[] course) {
        Map<Integer, Map<String, Integer>> result = new HashMap<>();
        
        for(int c : course) {
            result.put(c, new HashMap<>());
        }
        
        return result;
    }
    
    private void countCourseCandidates(String[] orderItems, int[] course, Map<Integer, Map<String, Integer>> courseCandidateCounters) {
        for (int c : course) {
            Map<String, Integer> candidateCounter = courseCandidateCounters.get(c);
            
            recursive(orderItems, 0, c, candidateCounter, new ArrayList<>());
        }
    }
    
    private void recursive(String[] orderItems, int start, int max, Map<String, Integer> counter, List<String> r) {
        if (r.size() == max) {
            String candidate = buildString(r);
            Integer count = counter.getOrDefault(candidate, 0);
            counter.put(candidate, count + 1);
            return;
        }
        
        for (int i = start; i < orderItems.length; i++) {
            r.add(orderItems[i]);
            recursive(orderItems, i + 1, max, counter, r);
            r.remove(r.size() - 1);
        }
    }
    
    private String buildString(List<String> r) {
        StringBuilder result = new StringBuilder();
        for(String c : r) {
            result.append(c);
        }
        return result.toString();
    }
    
    class CourseCount {
        private final Integer count;
        private final String course;
        CourseCount(Integer count, String course) {
            this.count = count;
            this.course = course;
        }
    }
}
