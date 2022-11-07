import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Stack<Integer> stck = new Stack<>();
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(bf.readLine());
            if(num==0)
                stck.pop();
            else
                stck.push(num);
        }
        int sum = 0;
        while(!stck.isEmpty())
            sum+=stck.pop();
        System.out.println(sum);
        }
    }