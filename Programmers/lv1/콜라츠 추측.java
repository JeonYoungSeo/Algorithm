class Solution {
    public int solution(long num) {
        int answer = 0;
        if(num==1){
            return 0;
        }
        while(answer<500){
            if(num%2==0){
                num = num/2;
            }else{
                num = num*3+1;
            }
            answer++;
            if(num==1){
                return answer;
            }
        }
        
        return -1;
    }
}
