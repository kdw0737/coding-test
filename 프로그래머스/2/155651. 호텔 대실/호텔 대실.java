import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        // 예약을 시작 시간 기준으로 정렬
        PriorityQueue<int[]> wq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        // 현재 사용 중인 방(퇴실 시간 기준 정렬)
        PriorityQueue<Integer> uq = new PriorityQueue<>();

        for (String[] arr : book_time) {
            int start = convertToMinutes(arr[0]); // 시작 시간을 분 단위 변환
            int end = convertToMinutes(arr[1]) + 10; // 종료 시간 + 청소 시간(10분)

            wq.add(new int[]{start, end});
        }

        int result = 0;

        while (!wq.isEmpty()) {
            int[] room = wq.poll();
            int now = room[0];

            // 사용이 끝난 방을 제거
            while (!uq.isEmpty() && uq.peek() <= now) {
                uq.poll();
            }

            // 새 손님 입실
            uq.add(room[1]);

            // 사용 중인 방의 최대 개수 갱신
            result = Math.max(result, uq.size());
        }

        return result;
    }

    // HH:MM 형식을 "분" 단위로 변환하는 함수
    private int convertToMinutes(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
