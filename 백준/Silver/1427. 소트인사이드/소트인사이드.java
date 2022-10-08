import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        String str = bf.readLine();
        for(int i=0; i<str.length(); i++){
            list.add(Integer.parseInt(String.valueOf(str.charAt(i))));
        }
        Collections.sort(list,Collections.reverseOrder());
        for(int a:list){
            System.out.print(a);
        }
    }
}
