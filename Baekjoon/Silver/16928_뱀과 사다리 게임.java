import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//사다리의 수, 뱀의 수
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] board = new int[101];
		
		//사다리 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			board[x] = y;
		}
		//뱀 입력
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			board[x] = y;
		}
		//시작 지점
		int start = 1;
		//너비 우선 탐색을 위한 큐 생성
		Queue<Integer> queue = new LinkedList<Integer>();
		//방문 체크 
		boolean[] visited = new boolean[101];
		queue.add(start);
		visited[start] = true;
		//주사휘 던지는 횟수
		int count = 0;
	out : while(!queue.isEmpty()) {
			
			int size = queue.size();
			//0이 될때까지 진행
			while(size!=0) {
				int curr = queue.poll();
				size--;
				
				if(curr==100) break out;
				
				for(int i=1; i<=6; i++) {
					if(curr+i>100) continue;
					
					if(board[curr+i]!=0 && !visited[board[curr+i]]) {
						queue.add(board[curr+i]);
						visited[board[curr+i]] = true;
					}else {
						if(board[curr+i]==0 && !visited[curr+i]) {
							queue.add(curr+i);
							visited[curr+i] = true;
						}
					}
				}
			}
			count ++;
		}
		System.out.println(count);
	}
}

