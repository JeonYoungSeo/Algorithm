import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br ;
	static BufferedWriter bw ;
	
	static List<Integer> stack = new ArrayList<Integer>();
	
	public static void main(String args[]) throws Exception
	{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<N; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
			case "push" :
				push(Integer.parseInt(st.nextToken()));
				break;
			case "pop" :
				pop();
				break;
			case "size" :
				size();
				break;
			case "empty" :
				empty();
				break;
			case "top" :
				top();
				break;
			}
			
		}
			
		bw.flush();
		bw.close();
		br.close();
	}
	
	static private void push(int x) {
		stack.add(x);
	}
	
	static private void pop() throws IOException {
		if(stack.isEmpty()) {
			bw.write(-1+"\n");
		}else {
			bw.write(stack.get(stack.size()-1)+"\n");
			stack.remove(stack.size()-1);
		}
	}
	
	static private void size() throws IOException{ 
		bw.write(stack.size()+"\n");
	}
	
	static private void empty() throws IOException{
		if(stack.isEmpty()) {
			bw.write(1+"\n");
		}else {
			bw.write(0+"\n");
		}
	}
	
	static private void top() throws IOException{
		if(stack.isEmpty()) {
			bw.write(-1+"\n");
		}else {
			bw.write(stack.get(stack.size()-1)+"\n");
		}
	}
	
}
