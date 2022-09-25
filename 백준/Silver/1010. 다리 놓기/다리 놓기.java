import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for(int i =0;  i<N ; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int tmp = a;
            if(a<b) {
                a = b;
                b = tmp;
            }
            BigInteger sum_a = new BigInteger("1");
            BigInteger sum_b = new BigInteger("1");
            for (int j = a; j > a - b; j--) {
                sum_a = sum_a.multiply(BigInteger.valueOf(j));
            }
            for (int j = 1; j <= b; j++) {
                sum_b = sum_b.multiply(BigInteger.valueOf(j));
            }
            System.out.println(sum_a.divide(sum_b));
        }
    }
}