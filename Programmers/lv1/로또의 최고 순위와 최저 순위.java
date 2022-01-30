class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int correct = 0;
        int zeroCnt = 0;
        for(int i=0; i<6; i++){
            if(lottos[i]==0) {
                zeroCnt++;
                continue;
             }
            for(int j=0; j<6; j++){
                if(lottos[i] == win_nums[j]){
                    correct++;
                    break;
                }
            }
        }
        if(zeroCnt==6) {
            answer[0] = 1;
            answer[1] = 6;
        }else if(zeroCnt==0 && correct==0){
            answer[0] = answer[1] = 6;
        }
        else{
            answer[1] = 7-correct;
            answer[0] = answer[1]-zeroCnt;
        }
        
        
        return answer;
    }
}
