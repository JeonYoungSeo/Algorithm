class Solution {
    public long[] solution(long[] numbers) {
        
        int len = numbers.length;
        long[] answer = new long[len];
        
        for(int i=0; i<len; i++){
            long num = numbers[i];
            int n = 0;
            while(true){
                if((num & (1L<<n))==0){
                    break;
                }
                n++;
            }
            if(n==0){
                answer[i] = num+1;
                continue;
            }
            answer[i] = num + (1L<<n) - (1L<<(n-1));
            
        }
        
        
        return answer;
    }
}
