import java.util.*;
import java.io.*;

public class Main {
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        nums = new int[N];
        int left = 0;
        int right = 0;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            right += n;
            nums[i] = n;
            left = Math.max(left, nums[i]);
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            if (Count(mid) <= M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }

    public static int Count(int n) {
        int cnt = 0;
        int sum = 0;
        for (int i : nums) {
            if (sum + i > n) {
                cnt++;
                sum = 0;
            }
            sum += i;
        }
        if (sum != 0) {
            return cnt +1;
        }
        return cnt;
    }
}
