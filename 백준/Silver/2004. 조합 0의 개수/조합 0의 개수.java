import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        long power_2 = find_2_power(N)-find_2_power(M)-find_2_power(N-M);
        long power_5 = find_5_power(N)-find_5_power(M)-find_5_power(N-M);
        System.out.println(Math.min(power_2,power_5));
    }

    static long find_2_power(long a){
        int count =0;
        while(a>=2){
            count += (a/2);
            a/=2;
        }
        return count;
    }

    static  long find_5_power(long a){
        int count =0;
        while(a>=5){
            count+=(a/5);
            a/=5;
        }
        return count;
    }
}