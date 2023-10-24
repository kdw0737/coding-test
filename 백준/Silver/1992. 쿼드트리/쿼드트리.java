import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = bf.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        division(0, 0, N);
        System.out.println(sb);
    }

    public static void division(int y, int x, int size) { //
        if (isPossible(y, x, size)) {
            sb.append(arr[y][x]);
            return;
        }

        int nSize = size / 2;
        sb.append("(");

        division(y, x, nSize); // 왼쪽 상단
        division(y, x + nSize, nSize); //오른쪽 상단
        division(y + nSize, x, nSize); // 왼쪽 하단
        division(y + nSize, x + nSize, nSize); // 오른쪽 하단

        sb.append(")");
    }

    public static boolean isPossible(int y, int x, int size) { // 압축이 가능한지 체크
        int num = arr[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (num != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
