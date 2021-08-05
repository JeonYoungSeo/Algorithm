import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br ;
	static BufferedWriter bw ;
	
	static List<Integer> deque = new ArrayList<Integer>();
	
	public static void main(String args[]) throws Exception
	{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<N; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
			case "push_back" :
				push_back(Integer.parseInt(st.nextToken()));
				break;
			case "push_front" :
				push_front(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front" :
				pop_front();
				break;
			case "pop_back" :
				pop_back();
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
	
	static private void push_back(int x) {
		deque.add(x);
	}
	
	static private void push_front(int x) {
		deque.add(0, x);
	}
	
	static private void pop_front() throws IOException {
		if(deque.isEmpty()) {
			bw.write(-1+"\n");
		}else {
			bw.write(deque.get(0)+"\n");
			deque.remove(0);
		}
	}
	
	static private void pop_back() throws IOException {
		if(deque.isEmpty()) {
			bw.write(-1+"\n");
		}else {
			bw.write(deque.get(deque.size()-1)+"\n");
			deque.remove(deque.size()-1);
		}
	}
	
	static private void size() throws IOException{ 
		bw.write(deque.size()+"\n");
	}
	
	static private void empty() throws IOException{
		if(deque.isEmpty()) {
			bw.write(1+"\n");
		}else {
			bw.write(0+"\n");
		}
	}
	
	static private void back() throws IOException{
		if(deque.isEmpty()) {
			bw.write(-1+"\n");
		}else {
			bw.write(deque.get(deque.size()-1)+"\n");
		}
	}
	
	static private void front() throws IOException{
		if(deque.isEmpty()) {
			bw.write(-1+"\n");
		}else {
			bw.write(deque.get(0)+"\n");
		}
	}
	
}
