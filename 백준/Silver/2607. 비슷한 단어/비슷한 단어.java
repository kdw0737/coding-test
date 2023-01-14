import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String mainWord = bf.readLine();
        HashMap<Character,Integer> mainMap = new HashMap<>();
        int answer = 0;
        settingMap(mainMap);
        for(int j =0; j<mainWord.length(); j++){
            mainMap.put(mainWord.charAt(j), mainMap.getOrDefault(mainWord.charAt(j), 0) + 1);
        }
        for(int i =0; i<N-1; i++){
            HashMap<Character,Integer> subMap = new HashMap<>();
            settingMap(subMap);
            String str = bf.readLine();
            for (int j = 0; j < str.length(); j++) {
                subMap.put(str.charAt(j), subMap.getOrDefault(str.charAt(j), 0) + 1);
            }
            int mainLen = 0;
            int subLen = 0;
            int gap = 0;
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                mainLen += mainMap.get(ch);
                subLen += subMap.get(ch);
                gap += Math.abs(mainMap.get(ch) - subMap.get(ch));
            }
            if(gap<=2 && Math.abs(mainLen-subLen)<=1)
                answer++;
        }
        System.out.println(answer);
    }
    private static void settingMap(HashMap<Character, Integer> map){
        for(char ch='A';ch<='Z';ch++) map.put(ch, 0);
    }
}