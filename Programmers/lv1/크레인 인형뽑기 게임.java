import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int len = board.length;
        
        Stack<Integer>[] boards = new Stack[len];
        for(int i=0; i<len; i++){
            boards[i] = new Stack<>();
        }
        
        for(int y=len-1; y>=0; y--){
            for(int x=0; x<len; x++){
                if(board[y][x]!=0){
                    boards[x].push(board[y][x]);
                }
            }
        }
        
        Stack<Integer> bag = new Stack<>();
        
        for(int num : moves){
            if(boards[num-1].isEmpty()) continue;
            
            
            int curr = boards[num-1].pop();
            
            if(!bag.isEmpty() && bag.peek() == curr){
                bag.pop();
                answer+=2;
                continue;
            }
            
            bag.push(curr);
            
        }
        
        return answer;
    }
}
