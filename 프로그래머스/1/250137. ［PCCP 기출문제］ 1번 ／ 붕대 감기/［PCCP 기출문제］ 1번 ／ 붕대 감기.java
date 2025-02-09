class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // bandage (시전 시간, 초당 회복량, 추가 회복량)
        // attack(공격 시간, 피해량)
        // 1. 공격시간에 해당하지 않으면 붕대감기
        // 2. 공격시간에 해당하면 연속보너스 초기화 및 피 감소 
        // 3. 죽으면 -1, 살아있으면 남은 체력 return 
        
        int maxTime = attacks[attacks.length-1][0];
        int now = 1;
        int atkIdx = 0;
        int bandStack = 1;
        int maxHealth = health;
        
        while(now<=maxTime){
            if(attacks[atkIdx][0] == now){
                //현재 시간이 공격 시간인 경우
                health -= attacks[atkIdx][1];
                atkIdx++;
                bandStack = 1;
                if(health <= 0) return -1;
            }else{
                //현재 시간이 붕대감는 시간인 경우
                if(bandStack == bandage[0]){
                    // 붕대 다 감은 경우 추가 체력
                    health += bandage[1] + bandage[2];
                    bandStack = 1;
                    if(health > maxHealth) health = maxHealth;
                }else{
                    // 아직 붕대 감는 중
                    bandStack++;
                    health += bandage[1];
                    if(health > maxHealth) health = maxHealth;
                }
            }
            now++;
            System.out.println("현재 체력 :" + health);
        }
        return health;
    }
}