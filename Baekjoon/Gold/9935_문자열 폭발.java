import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        String comp = br.readLine();
        int N = comp.length();
        //누적할 스택 ;
        Stack<Character> stack = new Stack<Character>();
        int cnt = 0;
        //문자열 처음부터 접근
        for(int i=0; i<str.length(); i++) {
        	stack.push(str.charAt(i));
          //스택 마지막 문자가 cnt번째의 문자와 같으면 cnt++아니면 cnt 초기화 
        	if(stack.peek().compareTo(comp.charAt(cnt))==0) {
        		cnt++;
            //cnt갯수만큼 push에서 제거
        		if(cnt==N) {
        			while(cnt-->0) {
        				stack.pop();
        			}
        			cnt=0;
        			
        			boolean check = true;
        			//제거 후 글자수만큼 뒤로 돌아가서 다시 문자열이 완성되거나 겹치는  검사한다.
    			out : while(check) {
	        			int start = (stack.size()-N-1>=0)?stack.size()-N-1:0;
	        			int end = stack.size();
	        			
	        			for(int j=start; j<end; j++) {
	        				if(stack.get(j).compareTo(comp.charAt(cnt))==0) {
	        					cnt++;
	        					if(cnt==N) {
	        						while(cnt-->0) {
	        							stack.pop();
	        						}
	        						cnt=0;
	        						continue out;
	        					}
	        				}else {
	        					cnt=0;
	        	        		if(stack.get(j).compareTo(comp.charAt(cnt))==0) 
	        	        			cnt++;
	        				}
	        			}
	        			check = false;
        			}
        			
        		}
        		
        	}else {
        		cnt = 0;
            //cnt초기화 후 첫번째 문자열과 같으면 
        		if(stack.peek().compareTo(comp.charAt(cnt))==0) {
        			cnt++;
        		}
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        
        if(stack.isEmpty()) {
        	bw.write("FRULA");
        }else {
        	for(char c : stack) {
        		sb.append(c);
        	}
        	bw.write(sb.toString());
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}
