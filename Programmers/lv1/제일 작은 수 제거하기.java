class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        
        if(arr.length==1){
            return new int[] {-1};
        }
        
        int len = arr.length;
        
        answer = new int[len-1];
        
        int min = arr[0];
        int minNum = 0;
        
        for(int i=0; i<len; i++){
            if(min>arr[i]){
                min = arr[i];
                minNum = i;
            }
        }
        int num = 0;
        for(int i=0; i<len; i++){
            if(i==minNum) continue;
            
            answer[num++] = arr[i];
        }
        
        
        return answer;
    }
}
