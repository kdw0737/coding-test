import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int result = 0;
        LinkedHashMap<String, String> map = new LinkedHashMap<>(cacheSize,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest){
                return size()>cacheSize;
            }
        };
        
        for(String city: cities){
            String name = city.toUpperCase();
            if(map.get(name) == null){
                result+=5;
                map.put(name," ");
            }else{
                result+=1;
            }
        }
        return result;
    }
}