import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Character> lst = new ArrayList<Character>();
		Stack<Integer> stacks = new Stack<Integer>();
		int stack = 0;
		
		for(int num=0; num<N; num++) {
			int number = Integer.parseInt(br.readLine());
			
			
			while(true) {
				if(number>stack) {
					lst.add('+');
					stacks.push(++stack);
				}else if(number==stacks.peek()) {
					lst.add('-');
					stacks.pop();
					break;
				}else if(number<stacks.peek()) {
					bw.write("NO");
					bw.flush();
					bw.close();
					br.close();
					return;
				}
			}
			
		}
		
		for(char ch : lst) {
			bw.write(ch+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}
