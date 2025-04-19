import java.util.*;
class Solution {
    public String solution(String id) {
        // Id 구성 : 알파벳, 숫자, -, _, .
        // "."은 처음과 끝에 사용 불가능, 연속 사용 불가능
        
        // 1단계
        id = id.toLowerCase();
        
        // 2단계
        id = id.replaceAll("[^0-9a-z-_.]","");
        
        // 3단계
        id = id.replaceAll("[.]{2,}",".");
        
        // 4단계
        id = id.replaceAll("^[.]|[.]$","");
        
        // 5단계
        if(id.length() == 0) id = "a";
        
        // 6단계
        if(id.length() >= 16) id = id.substring(0,15);
        id = id.replaceAll("[.]$","");
        
        // 7단계
        while (id.length() < 3) {
            id += id.charAt(id.length() - 1);
        }
        
        return id;
    }
}