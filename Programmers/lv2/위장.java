import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        
        int len = clothes.length;
        
        for(int i=0; i<len; i++){
            if(map.containsKey(clothes[i][1])){
                int num = map.get(clothes[i][1]);
                map.put(clothes[i][1], num+1);

            }else{
                map.put(clothes[i][1], 1);
            }
        }
        
        int answer = 1;
        
        if(map.size()==1){
            for(String key : map.keySet()){
                return map.get(key);
            }
        }else{
            for(String key : map.keySet()){
                answer *= map.get(key)+1;
            }
        }
        
        return answer-1;
    }
}
