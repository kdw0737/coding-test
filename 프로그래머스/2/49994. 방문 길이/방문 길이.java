import java.util.*;
class Solution {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();
        int x =5; int y =5;
        for(int i =0; i<dirs.length(); i++){
            if(dirs.charAt(i) == 'U'){
                if(checkIdx(y,x,'U')){
                    set.add(""+y+x+(y-1)+x);
                    set.add(""+(y-1)+x+y+x);
                    y--;
                }
            }else if(dirs.charAt(i) == 'D'){
                if(checkIdx(y,x,'D')){
                    set.add(""+y+x+(y+1)+x);
                    set.add(""+(y+1)+x+y+x);
                    y++;
                }
            }else if(dirs.charAt(i) == 'L'){
                if(checkIdx(y,x,'L')){
                    set.add(y+" "+x+" "+y+" "+(x-1));
                    set.add(y+" "+(x-1)+" "+y+" "+x);
                    x--;
                }
            }else if(dirs.charAt(i) == 'R'){
                if(checkIdx(y,x,'R')){
                    set.add(y+" "+x+" "+y+" "+(x+1));
                    set.add(y+" "+(x+1)+" "+y+" "+x);
                    x++;
                }
            }
        }
        return set.size()/2;
    }
    
    public static boolean checkIdx(int y, int x, char dir){
        if(dir == 'U'){
            y--;
        }else if(dir == 'D'){
            y++;
        }else if(dir == 'L'){
            x--;
        }else{
            x++;
        }
        if(y<11 && y>=0 && x<11 && x>=0){
            return true;
        }else{
            return false;
        }
    }
}