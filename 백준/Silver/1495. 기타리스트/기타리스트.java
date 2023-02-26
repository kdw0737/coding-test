import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> list = new ArrayList<>();
    static int N;
    static int maxVolume;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        maxVolume = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int[] volume = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            volume[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N+1][maxVolume + 1];
        dp[0][start] = 1;
        for (int i = 1; i < N+1; i++) {
            for (int j = 0; j < maxVolume + 1; j++) {
                if (dp[i - 1][j] == 1) {
                    if (j + volume[i] <= maxVolume) {
                        dp[i][j + volume[i]] = 1;
                    }
                    if (j - volume[i] >= 0) {
                        dp[i][j - volume[i]] = 1;
                    }
                }
            }
        }
        for (int i = maxVolume; i >= 0; i--) {
            if (dp[N][i] == 1) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
