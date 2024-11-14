import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        // 대소문자 구분하지 않음
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        // 두 리스트를 저장할 리스트 생성
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        
        // str1에서 두 글자씩 자르고, 문자가 알파벳인 경우만 추가
        for (int i = 0; i < str1.length() - 1; i++) {
            String subStr = str1.substring(i, i + 2);
            if (isCharacter(subStr)) {
                list1.add(subStr);
            }
        }
        
        // str2에서 두 글자씩 자르고, 문자가 알파벳인 경우만 추가
        for (int i = 0; i < str2.length() - 1; i++) {
            String subStr = str2.substring(i, i + 2);
            if (isCharacter(subStr)) {
                list2.add(subStr);
            }
        }
        
        // 교집합과 합집합을 계산
        int intersectionCount = 0;
        int unionCount = 0;

        // 각 리스트의 원소를 카운팅
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (String s : list1) map1.put(s, map1.getOrDefault(s, 0) + 1);
        for (String s : list2) map2.put(s, map2.getOrDefault(s, 0) + 1);

        // 교집합과 합집합을 계산
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                // 교집합은 최소값
                intersectionCount += Math.min(map1.get(key), map2.get(key));
            }
            // 합집합은 최대값
            unionCount += Math.max(map1.getOrDefault(key, 0), map2.getOrDefault(key, 0));
        }

        // map2에만 있는 원소들을 합집합에 추가
        for (String key : map2.keySet()) {
            if (!map1.containsKey(key)) {
                unionCount += map2.get(key);
            }
        }

        // 유사도 계산
        if (unionCount == 0) return 65536;  // 두 문자열 모두 교집합이 없을 때

        return (int)(((double) intersectionCount / unionCount) * 65536);  // 유사도를 계산하여 반환
    }

    // 알파벳만 포함된 두 글자씩 자르는지 체크
    public static boolean isCharacter(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i))) {
                return false;  // 특수 문자나 숫자가 포함되면 false
            }
        }
        return true;
    }
}
