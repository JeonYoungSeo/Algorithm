class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        int len = s.length();
        for(int i=0; i<len; i++){
            int m = 1;
            int temp = 1;
            while(i-m>=0 && i+m <len){
                if(s.charAt(i-m)!=s.charAt(i+m)) break;
                temp+=2;
                m++;
            }
            
            answer = Math.max(answer, temp);
        }
        
        for(int i=1; i<len; i++){
            if(s.charAt(i)!=s.charAt(i-1)) continue;
            int m = 1;
            int temp = 2;
            while(i-1-m>=0 && i+m <len){
                if(s.charAt(i-1-m)!=s.charAt(i+m)) break;
                temp+=2;
                m++;
            }
            
            answer = Math.max(answer, temp);
        }
        return answer;
    }
}
