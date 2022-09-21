import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for(int i =0; i<N ; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            double distance = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
            if(r1+r2<distance){
                System.out.println(0);
            }
            else if(r1+r2==distance){
                System.out.println(1);
            }
            else if(x1==x2 && y1==y2 && r1==r2){
                System.out.println(-1);
            }
            else if(Math.abs(r2-r1)==distance){
                System.out.println(1);
            }
            else if(Math.abs(r2-r1)>distance){
                System.out.println(0);
            }
            else
                System.out.println(2);
        }
    }
}