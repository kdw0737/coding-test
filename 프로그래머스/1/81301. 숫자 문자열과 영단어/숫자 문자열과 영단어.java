import java.util.*;
class Solution {
    static HashMap<String,String> map;
    public int solution(String s) {
        String result = "";
        String tmp = "";
        map = new HashMap<>();
        // 숫자인경우는 그대로 result에 추가 
        // 숫자가 아닌 경우는 숫자가 나올때까지 tmp에 문자 저장
        addNum();
        for(int i =0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                //숫자인 경우
                if(map.containsKey(tmp)){
                    result += map.get(tmp);
                }
                result += String.valueOf(s.charAt(i));
                tmp = "";
            }else{
                tmp += String.valueOf(s.charAt(i));
                if(map.containsKey(tmp)){
                    result += map.get(tmp);
                    tmp = "";
                }
            }
        }
        if(tmp != ""){
            result += map.get(tmp);
        }
        return Integer.parseInt(result);
    }
    
    public static void addNum(){
        map.put("zero","0");
        map.put("one","1");
        map.put("two","2");
        map.put("three","3");
        map.put("four","4");
        map.put("five","5");
        map.put("six","6");
        map.put("seven","7");
        map.put("eight","8");
        map.put("nine","9");
    } 
}