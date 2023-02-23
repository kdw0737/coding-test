import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String[][] arr = new String[N][2];
        for (int i = 0; i < N; i++) {
            int sum =0;
            arr[i][0] = bf.readLine();
            for (int j = 0; j < arr[i][0].length(); j++) {
                if ('0' <= arr[i][0].charAt(j) && arr[i][0].charAt(j) <= '9') {
                    sum+= Integer.parseInt(String.valueOf(arr[i][0].charAt(j)));
                }
            }
            arr[i][1] = String.valueOf(sum);
        }
        Arrays.sort(arr,(o1,o2) -> {
            if (o1[0].length() == o2[0].length()) {
                if (Integer.parseInt(o1[1]) == Integer.parseInt(o2[1])) {
                    return o1[0].compareTo(o2[0]);
                } else {
                    return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
                }
            } else {
                return o1[0].length() - o2[0].length();
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i][0]).append('\n');
        }
        System.out.println(sb);

    }
}
