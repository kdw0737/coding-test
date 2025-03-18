import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        // [기본 시간(분), 기본 요금(원), 단위 시간(분), 단위 요금(원)]
        // 나간 기록이 없으면 23:59분에 출차로 계산
        // 단위시간보다 적어도 기본요금으로 적용
        // 자동차 번호 오름차순으로 주차요금 return .
        HashMap<String, Integer> timeMap = new HashMap<>();
        HashMap<String, Integer> costMap = new HashMap<>();
        HashSet<String> cars = new HashSet<>();
        
        for(String record : records){
            String[] arr = record.split(" ");
            String[] timeArr = arr[0].split(":");
            int time = Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
            String car = arr[1];
            String status = arr[2];
            
            if(status.equals("IN")){
                // 입차인 경우
                timeMap.put(car, time);
                cars.add(car);
            }else{
                // 출차인 경우
                int term = time - timeMap.get(car); // 사용 시간
                costMap.put(car, costMap.getOrDefault(car, 0) + term);
                cars.remove(car);
            }
        }
        
        int endTime = 1439;
        for(String car : cars){
            // 아직 출차 안한 차들 계산
            int term = endTime - timeMap.get(car);
            costMap.put(car, costMap.getOrDefault(car, 0) + term);
        }
        
        // 비용계산을 위한 list
        List<String> carList = new ArrayList<>(costMap.keySet());
        int[] result = new int[carList.size()];
        Collections.sort(carList);
        
        int idx = 0;
        for(String car : carList){
            int totalTime = costMap.get(car);
            
            if(totalTime <= fees[0]){
                // 기본시간보다 같거나 작은 경우
                result[idx] = fees[1];
                idx++;
            }else{
                // 추가요금 내야하는 경우 
                int overTime = totalTime - fees[0];
                int extraFee = 0;
                if(overTime % fees[2] != 0){
                    extraFee = ((overTime / fees[2]) + 1) * fees[3];
                    result[idx] = extraFee + fees[1];
                    idx++;
                }else{
                    extraFee = (overTime / fees[2]) * fees[3];
                    result[idx] = extraFee + fees[1];
                    idx++;
                }
            }
        }
        
        return result;
    }
}