import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int a = Math.abs(X-W);
        int b = Math.abs(Y-h);
        if(a>X)
            a=X;
        if(b>Y)
            b=Y;
        System.out.println(a>b?b:a);
    }
}