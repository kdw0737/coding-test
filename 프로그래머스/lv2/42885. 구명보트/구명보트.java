import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int right = people.length-1;
        int left =0;
        int answer =0;
        while(right>=left){
            if(people[right]+people[left]>limit){
                answer++;
                right--;
            }
            else{
                answer++;
                right--;
                left++;
            }
        }
        return answer;
    }
}