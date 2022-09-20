import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if(N==0 && M==0){
                break;
            }
            if (N < M) {
                if (M % N == 0)
                    System.out.println("factor");
                else
                    System.out.println("neither");
            }else if(N>M){
                if(N%M==0)
                    System.out.println("multiple");
                else
                    System.out.println("neither");
            }
        }
    }
}