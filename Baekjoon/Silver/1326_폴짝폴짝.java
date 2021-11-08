import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(start);
		boolean visited[] = new boolean[N+1];
		int result = 0;
		
		while(!que.isEmpty()) {
			int size = que.size();
			
			while(size-->0) {
				int curr = que.poll();
				
				if(curr==end) {
					System.out.println(result);
					return;
				}
				int add = arr[curr];
				int number = curr;
				while(true){
					number += add;
					if(number>N) break;
					if(visited[number]) continue;
					visited[number] = true;
					que.add(number);
				}
				
				number = curr;
				
				while(true) {
					number -= add;
					if(number<=0) break;
					if(visited[number]) continue;
					visited[number] = true;
					que.add(number);
				}
			}
			result ++;
		}
		
		System.out.println(-1);
		
	}
}
