import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String[][] arr = new String[N][2];
        for(int i =0; i<N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }
        Arrays.sort(arr, (o1,o2) -> Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]));
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<N; i++){
            sb.append(arr[i][0]+" "+arr[i][1]).append("\n");
        }
        System.out.println(sb);
    }
}