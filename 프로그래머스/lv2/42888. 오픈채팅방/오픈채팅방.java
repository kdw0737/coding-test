import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        int N = record.length;
        HashMap<String,String> map = new HashMap<>();
        for(int i =0; i<N; i++){
            String[] tmp = record[i].split(" ");
            if(!tmp[0].equals("Leave")){
                map.put(tmp[1],tmp[2]);
            }
        }
        List<String> list = new ArrayList<>();
        for(int i =0; i<N; i++){
            String[] tmp = record[i].split(" ");
            if(tmp[0].equals("Enter")){
                list.add(map.get(tmp[1])+"님이 들어왔습니다.");
            }else if(tmp[0].equals("Leave")){
                list.add(map.get(tmp[1])+"님이 나갔습니다.");
            }
        }
        String[] result = list.toArray(new String[0]);
        return result;
    }
}