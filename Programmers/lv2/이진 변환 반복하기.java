import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        int cnt = 0;
        int zero = 0;
        while(!s.equals("1")){
            cnt++;
            int num = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)=='1') num++;
                else zero ++;
            }
            Stack<Integer> stack = new Stack<>();

            while(num>=1){
                stack.add(num%2);
                num /= 2;
            }

            if(stack.peek()==0) stack.pop();
            s = "";
            while(!stack.isEmpty()){
                s += stack.pop();
            }
        }

        answer[0] = cnt;
        answer[1] = zero;
        return answer;
    }
}
