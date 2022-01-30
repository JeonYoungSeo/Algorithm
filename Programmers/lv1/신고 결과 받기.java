import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        
        HashMap<String, HashSet<String>> hashmap = new HashMap<String, HashSet<String>>();
        
        HashMap<String, Integer> reportcnt = new HashMap<String, Integer>();
        
        int len = id_list.length;
        int len2 = report.length;
        int[] answer = new int[len];
        for(int i=0; i<len2; i++){
            StringTokenizer st = new StringTokenizer(report[i]);
            
            String reporter = st.nextToken();
            String reported = st.nextToken();
            
            if(!hashmap.containsKey(reported)){
                HashSet<String> value = new HashSet<>();
                value.add(reporter);
                hashmap.put(reported, value);
            }else{
                HashSet<String> value = hashmap.get(reported);
                value.add(reporter);
                hashmap.put(reported, value);
            }
        }
        
        for(int i=0; i<len; i++){
            HashSet<String> value = hashmap.get(id_list[i]);
            if(value==null){
                continue;
            }else{
                int size = value.size();
                if(size>=k){
                    for(String key : value){
                        if(reportcnt.containsKey(key)){
                            int cnt = reportcnt.get(key);
                            cnt++;
                            reportcnt.put(key,cnt);
                        }else{
                            reportcnt.put(key,1);
                        }
                    }
                }
            }
        }
        
        for(int i=0; i<len; i++){
            if(reportcnt.containsKey(id_list[i])){
                answer[i] = reportcnt.get(id_list[i]);
            }
            
        }
        
        
        return answer;
    }
}
