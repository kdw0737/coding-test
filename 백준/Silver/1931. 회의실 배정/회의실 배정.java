import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        int start = arr[0][0];
        int end = arr[0][1];
        int count = 1;
        for (int i = 1; i < N; i++) {
            if(end == arr[i][0] && arr[i][0] == arr[i][1]) {
                count++;
                start = arr[i][0];
                end = arr[i][1];
                continue;
            }
            else if(start == end && end == arr[i][0]) {
                count++;
                start = arr[i][0];
                end = arr[i][1];
                continue;
            }
            if (arr[i][0] >= end) {
                count++;
                start = arr[i][0];
                end = arr[i][1];
            }
        }
        System.out.println(count);
    }
 }
