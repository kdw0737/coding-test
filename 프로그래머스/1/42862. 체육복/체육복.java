import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 바로 앞이나 뒤의 학생에게만 대여 가능
        // 최대한 많이 수업을 듣도록 
        // 최대 학생 수 return 
        
        int result = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        HashSet<Integer> set = new HashSet<>();
        for(int k : reserve){
            set.add(k);
        }
        
        // 도난당한 학생 중 여벌 체육복이 있는 경우 먼저 처리
        List<Integer> actualLost = new ArrayList<>();
        for (int k : lost) {
            if (set.contains(k)) {
                set.remove(k);  // 본인이 사용해야 하므로 제거
                result++;  // 본인은 체육수업 가능
            } else {
                actualLost.add(k); // 빌려야 하는 학생 리스트
            }
        }

        // 체육복 빌려주기 (앞번호 → 뒷번호 순서로)
        for (int k : actualLost) {
            if (set.contains(k - 1)) {
                set.remove(k - 1);
                result++;
            } else if (set.contains(k + 1)) {
                set.remove(k + 1);
                result++;
            }
        }

        return result;
    }
}