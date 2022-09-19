import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<Integer> A = new HashSet<>();
        HashSet<Integer> B = new HashSet<>();
        st=new StringTokenizer(bf.readLine());
        for(int i =0; i<N; i++){
            A.add(Integer.parseInt(st.nextToken()));
        }
        st=new StringTokenizer(bf.readLine());
        for(int i=0; i<M ; i++){
            B.add(Integer.parseInt(st.nextToken()));
        }
        HashSet<Integer> tmp = new HashSet<>();
        tmp.addAll(A);
        A.removeAll(B);
        B.removeAll(tmp);
        int count = A.size()+B.size();
        System.out.println(count);
    }
}