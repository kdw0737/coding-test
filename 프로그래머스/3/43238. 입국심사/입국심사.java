import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = (long) Arrays.stream(times).max().getAsInt() * n;

        while (left < right) {
            long mid = (left + right) / 2;

            if (canProcess(mid, times, n)) {
                right = mid;          // mid는 가능하니 포함
            } else {
                left = mid + 1;       // mid는 불가능하니 제외
            }
        }

        return left; // left == right일 때 종료됨
    }

    private boolean canProcess(long time, int[] times, int n) {
        long count = 0;
        for (int t : times) {
            count += time / t;
            if (count >= n) return true;
        }
        return false;
    }
}
