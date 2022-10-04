import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
            for(int[] a : commands){
                int[] arr = Arrays.copyOfRange(array,a[0]-1,a[1]);
                Arrays.sort(arr);
                answer.add(arr[a[2]-1]);
            }
            return answer.stream().mapToInt(i->i).toArray();
    }
}