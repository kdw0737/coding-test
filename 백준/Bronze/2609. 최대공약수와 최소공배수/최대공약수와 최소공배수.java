import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int gcd = 0;
        int lcm = 0;
        if(N>M){
            for(int i =1; i<=M; i++){
                if(M%i==0 && N%i==0)
                    gcd = i;
            }
        }else if(N==M)
            gcd = N;
        else{
            for(int i =1; i<=N; i++){
                if(M%i==0 && N%i==0)
                    gcd = i;
            }
        }
        sb.append(gcd).append("\n");
        sb.append((N*M)/gcd);
        System.out.println(sb);
    }
}