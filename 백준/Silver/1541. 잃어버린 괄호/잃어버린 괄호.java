import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(),"-");
        int sum = Integer.MAX_VALUE;
        while(st.hasMoreTokens()){
            int tmp=0;
            StringTokenizer plus = new StringTokenizer(st.nextToken(),"+");
            while(plus.hasMoreTokens()) {
                tmp += Integer.parseInt(plus.nextToken());
            }
            if(sum==Integer.MAX_VALUE){
                sum=tmp;
            }else
                sum-=tmp;
        }
        System.out.println(sum);
    }
}