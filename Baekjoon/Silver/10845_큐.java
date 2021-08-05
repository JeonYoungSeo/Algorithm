import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br ;
	static BufferedWriter bw ;
	
	static List<Integer> queue = new ArrayList<Integer>();
	
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
			case "front" :
				front();
				break;
			case "back" :
				back();
				break;
			}
			
			
		}
			
		bw.flush();
		bw.close();
		br.close();
	}
	
	static private void push(int x) {
		queue.add(x);
	}
	
	static private void pop() throws IOException {
		if(queue.isEmpty()) {
			bw.write(-1+"\n");
		}else {
			bw.write(queue.get(0)+"\n");
			queue.remove(0);
		}
	}
	
	static private void size() throws IOException{ 
		bw.write(queue.size()+"\n");
	}
	
	static private void empty() throws IOException{
		if(queue.isEmpty()) {
			bw.write(1+"\n");
		}else {
			bw.write(0+"\n");
		}
	}
	
	static private void back() throws IOException{
		if(queue.isEmpty()) {
			bw.write(-1+"\n");
		}else {
			bw.write(queue.get(queue.size()-1)+"\n");
		}
	}
	
	static private void front() throws IOException{
		if(queue.isEmpty()) {
			bw.write(-1+"\n");
		}else {
			bw.write(queue.get(0)+"\n");
		}
	}
	
}
