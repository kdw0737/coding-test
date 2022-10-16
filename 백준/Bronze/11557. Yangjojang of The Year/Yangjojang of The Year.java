import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for(int i =0; i<N ; i++) {
            int row = Integer.parseInt(bf.readLine());
            String univ = "";
            int max = Integer.MIN_VALUE;
            String[][] arr = new String[row][2];
            for (int j = 0; j < row; j++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                arr[j][0] = st.nextToken();
                arr[j][1] = st.nextToken();
                max = Integer.max(max,Integer.parseInt(arr[j][1]));
                if(max == Integer.parseInt(arr[j][1]))
                    univ = arr[j][0];
            }
            System.out.println(univ);
        }
    }
}