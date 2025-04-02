import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        int totalTypes = gemTypes.size();

        Map<String, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int answerLeft = 0;
        int answerRight = 0;

        while (right < gems.length) {
            // 오른쪽 포인터 확장
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            right++;

            // 조건 만족할 때 왼쪽 포인터 줄이기 시도
            while (map.size() == totalTypes) {
                if (right - left < minLength) {
                    minLength = right - left;
                    answerLeft = left + 1;   // 문제 조건: 진열대는 1부터 시작
                    answerRight = right;
                }

                // 왼쪽 포인터 줄이기
                map.put(gems[left], map.get(gems[left]) - 1);
                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                left++;
            }
        }

        return new int[]{answerLeft, answerRight};
    }
}
