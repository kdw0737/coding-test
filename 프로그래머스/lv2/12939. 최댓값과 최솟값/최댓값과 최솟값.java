import java.util.*;
class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");
        int[] arr = new int[str.length];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i =0; i<arr.length; i++){
            arr[i] = Integer.parseInt(str[i]);
            max = Math.max(arr[i],max);
            min = Math.min(arr[i],min);
        }
        return String.valueOf(min)+" "+String.valueOf(max);
    }
}