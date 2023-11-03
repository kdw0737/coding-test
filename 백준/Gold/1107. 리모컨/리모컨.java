import java.util.*;
import java.io.*;

public class Main {
    static String[] tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        boolean[] remoteController = new boolean[10];
        String target = bf.readLine();
        int M = Integer.parseInt(bf.readLine());
        if (M != 0) {
            tmp = bf.readLine().split(" ");
            for (int i = 0; i < M; i++) {
                remoteController[Integer.parseInt(tmp[i])] = true;
            }
        }
        int result = Math.abs(Integer.parseInt(target) - 100);
        for (int i = 0; i <= 999999; i++) {
            boolean check = false;
            String str = String.valueOf(i);
            for (int j = 0; j < str.length(); j++) {
                if (remoteController[str.charAt(j) - '0']) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                result = Math.min(result, str.length() + (Math.abs(Integer.parseInt(target) - i)));
            }
        }
        System.out.println(result);
    }
}
