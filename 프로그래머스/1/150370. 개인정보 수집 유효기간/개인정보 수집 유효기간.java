import java.util.*;
class Solution {
    public int[] solution(String tdy, String[] terms, String[] privacies) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        String[] today = tdy.split("\\.");

        // (1) terms를 쪼개서 약관별 유효기간 정리
        for (int i = 0; i < terms.length; i++) {
            String[] tmp = terms[i].split(" ");
            map.put(tmp[0], Integer.parseInt(tmp[1]));
        }

        // (2) 각 유효기간을 적용해서 날짜 계산
        for (int i = 0; i < privacies.length; i++) {
            String[] tmp = privacies[i].split(" ");
            String type = tmp[1];
            String[] day = tmp[0].split("\\.");
            int n = map.get(type);
            
            int year = Integer.parseInt(day[0]);
            int month = Integer.parseInt(day[1]);
            int dayOfMonth = Integer.parseInt(day[2]);

            // 유효기간을 더함
            month += n;
            while (month > 12) {
                month -= 12;
                year += 1;
            }
            
            privacies[i] = year + "." + (month < 10 ? "0" + month : month) + "." + dayOfMonth;
        }

        // (3) 현재 날짜와 비교해서 유효기간이 지난 경우 리스트에 담기
        for (int i = 0; i < privacies.length; i++) {
            String[] day = privacies[i].split("\\.");
            int year = Integer.parseInt(day[0]);
            int month = Integer.parseInt(day[1]);
            int dayOfMonth = Integer.parseInt(day[2]);

            // 비교하는 현재 날짜
            int currentYear = Integer.parseInt(today[0]);
            int currentMonth = Integer.parseInt(today[1]);
            int currentDay = Integer.parseInt(today[2]);

            // 현재 년도가 이미 지난 경우
            if (year < currentYear) {
                list.add(i + 1);
            } else if (year > currentYear) {
                // 현재 년도가 더 미래인 경우
                continue;
            } else {
                // 년도가 같은 경우, 월과 일을 비교
                if (month < currentMonth) {
                    list.add(i + 1);
                } else if (month > currentMonth) {
                    continue;
                } else {
                    // 월이 같은 경우, 일 비교
                    if (dayOfMonth <= currentDay) {
                        list.add(i + 1);
                    }
                }
            }
        }

        // 결과를 int[] 배열로 반환
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
