class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int size = w*2+1;
        int left = 1 ;
        int right = 1;
        for(int i=0; i<stations.length; i++){
            left = stations[i]-w;
            if(right<left){
                answer += (left-right)/size;
                if((right-left)%size!=0) answer++;
            }
            right = stations[i]+w+1;
        }
        left = n+1;
        if(right<=left){
            answer += (left-right)/size;
            if((left-right)%size!=0) answer++;
        }
        return answer;
    }
}
