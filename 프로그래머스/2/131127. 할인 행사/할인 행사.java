import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> discountMap = new HashMap<>();

            for (int j = i; j < i + 10; j++) {
                discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
            }

            if (isSame(wantMap, discountMap)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isSame(Map<String, Integer> map1, Map<String, Integer> map2) {
        if (map1.size() != map2.size()) return false;

        for (String key : map1.keySet()) {
            if (!map2.containsKey(key) || !map1.get(key).equals(map2.get(key))) {
                return false;
            }
        }
        return true;
    }
}
