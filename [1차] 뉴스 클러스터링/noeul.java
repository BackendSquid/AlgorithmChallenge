public class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        List<String> str1List = buildMultiSet(str1);
        List<String> str2List = buildMultiSet(str2);

        List<String> intersection  = getIntersection(str1List, str2List);
        List<String> union  = getUnion(str1List, str2List, intersection);


        float jaccard = (float) intersection.size() / union.size();

        if(union.isEmpty()){
            return 65536;
        }

        return (int) Math.floor(jaccard * 65536);
    }

    private List<String> getUnion(List<String> str1List, List<String> str2List, List<String> intersection) {
        List<String> list1 = new ArrayList<>(str1List);
        List<String> list2 = new ArrayList<>(str2List);
        intersection.forEach(list2::remove);

        List<String> union = new ArrayList<>();
        union.addAll(list1);
        union.addAll(list2);

        return union;
    }

    private List<String> getIntersection(List<String> str1List, List<String> str2List) {
        List<String> list2 = new ArrayList<>(str2List);
        List<String> intersection = new ArrayList<>();

        for(String str1 : str1List){
            if(list2.contains(str1)){
                list2.remove(str1);
                intersection.add(str1);
            }
        }
        return intersection;
    }

    private List<String> buildMultiSet(String str) {
        List<String> strList = new ArrayList<>();
        char[] strToChar = str.toCharArray();
        for (int i = 0; i < strToChar.length - 1; i++) {
            char a = strToChar[i];
            char b = strToChar[i + 1];

            if (Character.isAlphabetic(a) && Character.isAlphabetic(b)) {
                strList.add(a + "" + b);
            }
        }
        return strList;
    }
}
