import java.util.*;

class Solution {
    private final int SOURCE = 0;
    private final int TARGET = 1;
    
    public int[] solution(String[] idList, String[] report, int k) {
        final Map<String, Set<String>> reportedMap = buildReportedMap(idList);
        
        updateReportedMap(reportedMap, report);
        
        Map<String, Integer> emailResult = getEmailResult(idList, reportedMap, k);
        
        int[] answer = new int[idList.length];
        
        for(int i = 0; i < idList.length; i++) {
            answer[i] = emailResult.get(idList[i]);
        }
        
        return answer;
    }
    
    private void updateReportedMap(Map<String, Set<String>> reportedMap, String[] report) {
        for(String reportItem : report) {
            String[] r = reportItem.split(" ");
            
            reportedMap.get(r[TARGET]).add(r[SOURCE]);
        }
    }
    
    private Map<String, Integer> getEmailResult(String[] idList, Map<String, Set<String>> reportedMap, int k) {
        Map<String, Integer> result = buildResult(idList);
        
        reportedMap.values().stream()
            .filter(users -> users.size() >= k)
            .forEach(users -> {
                updateResultCount(result, users);
            });
        
        return result;
    }
    
    private void updateResultCount(Map<String, Integer> result, Set<String> users) {
        for(String user : users) {
            result.put(user, result.get(user) + 1);
        }
    }
        
    private Map<String, Set<String>> buildReportedMap(String[] idList) {
        final Map<String, Set<String>> result = new HashMap<>();
        
        for(String id : idList) {
            result.put(id, new HashSet<>());
        }
        
        return result;
    }
    
    private Map<String, Integer> buildResult(String[] idList) {
        Map<String, Integer> result = new HashMap<>();
        for(String user : idList) {
            result.put(user, 0);
        }
        return result;
    }
}
