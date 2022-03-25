import java.util.*;

class Solution {
    public class Node implements Comparable<Node>{
        int ori;
        int num;
        
        Node(int ori, int num){
            this.ori = ori;
            this.num = num;
        }
        
        @Override
        public int compareTo(Node o){
            return -this.num+o.num;
            
        }
        
    }
    
    public String solution(int[] numbers) {
        int len = numbers.length;
        
        Node[] nodes = new Node[len];
        boolean zero = true;
        for(int i=0; i<len; i++){
            int num = numbers[i];
            if(num!=0) zero = false;
            int new_num = num;
            if(new_num<10){
                new_num *= 10;
                new_num += num;
                new_num *= 10;
                new_num += num;
                new_num *= 10;
                new_num += num;
            }else if(new_num<100){
                new_num *= 100;
                new_num += num;
            }else if(new_num<1000){
                new_num *= 10;
                new_num += num/100;
            }
            
            nodes[i] = new Node(num, new_num);
        }
        if(zero) return "0";
        Arrays.sort(nodes);
        
        StringBuilder answer = new StringBuilder();
        
        for(Node curr : nodes){
            answer.append(curr.ori+"");
        }
        
        return answer.toString();
    }
}
