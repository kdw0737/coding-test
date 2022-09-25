import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        BigInteger factorial = new BigInteger("1");
        for(int i =1; i<=N; i++){
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        boolean check = true;
        int count =0;
        String[] arr = factorial.toString().split("");
        for(int i = arr.length-1; i>=0; i--){
            if(!arr[i].equals("0")) {
                check = false;
                break;
            }else if(arr[i].equals("0"))
                count++;
        }
        System.out.println(count);
    }
}