import java.util.*;

class Solution {
    HashMap<String, Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        Set<Integer> courseSet = new HashSet<>();
        for (int c : course) {
            courseSet.add(c);
        }

        ArrayList<String> list = new ArrayList<>();

        // 각 주문을 알파벳 순으로 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = new String(chars);
        }

        // 모든 가능한 조합 생성
        for (String order : orders) {
            dfs(order, 0, "", courseSet);
        }

        // 각 코스 길이에 대해 가장 많이 주문된 조합만 선택
        for (int c : course) {
            int maxCount = 2; // 최소 2명 이상이 주문해야 함
            List<String> maxCombos = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                int count = entry.getValue();

                if (key.length() == c) {
                    if (count > maxCount) {
                        maxCount = count;
                        maxCombos.clear();
                        maxCombos.add(key);
                    } else if (count == maxCount) {
                        maxCombos.add(key);
                    }
                }
            }
            list.addAll(maxCombos);
        }

        Collections.sort(list);
        return list.toArray(new String[0]); // ArrayList -> String[] 변환
    }

    // DFS를 이용한 조합 생성
    public void dfs(String str, int index, String sub, Set<Integer> courseSet) {
        if (courseSet.contains(sub.length())) {
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }

        for (int i = index; i < str.length(); i++) {
            dfs(str, i + 1, sub + str.charAt(i), courseSet);
        }
    }
}
