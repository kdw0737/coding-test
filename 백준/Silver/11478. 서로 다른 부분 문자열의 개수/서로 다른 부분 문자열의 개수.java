import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        HashMap<String, Integer> map = new HashMap<>();
        int size =2;
        for(int i =0; i<str.length(); i++){
            if(!map.containsKey(String.valueOf(str.charAt(i)))){
                map.put(String.valueOf(str.charAt(i)),1);
            }
        }
        while(size<=str.length()){
            for(int i=0; i<str.length()-size+1; i++){
                String tmp = str.substring(i,i+size);
                if(!map.containsKey(tmp)){
                    map.put(tmp,1);
                }
            }
            size++;
        }
        System.out.println(map.size());
    }
}