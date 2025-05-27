import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int[] arr = new int[n];
        String[] result = new String[n];
        for(int i =0; i< n; i++){
            arr[i] = arr1[i] | arr2[i];
            StringBuilder sb = new StringBuilder();
            
            for(int j = n - 1; j >= 0; j--){
                if((arr[i] & (1 << j)) != 0){
                    sb.append("#");
                }else{
                    sb.append(" ");
                }
            }
            
            result[i] = sb.toString();
        }
        return result;
    }
}