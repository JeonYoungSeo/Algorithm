import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-22
 * Description : 백준 1260
 */

public class Main{
	static boolean[][] arr;
	static int N;
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//정점의 개수, 간선의 개수, 시작지점
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		//배열 생성
		arr = new boolean[N+1][N+1];
		//입력
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			//양방향 그래프
			arr[from][to] = true;
			arr[to][from] = true;
		}
		//방문 여부
		boolean visited[] = new boolean[N+1];
		dfs(V, visited); //dfs 
		System.out.println();
		bfs(V); //bfs 
		
	}

	public static void dfs(int v,boolean[] visited) {
		//방문 했으니 true 
		visited[v] = true;
		//출력
		System.out.print(v+" ");
		//다음 인접행렬 찾는다
		for(int i=0; i<N+1; i++) {
			if(arr[v][i] && !visited[i]) {
				//방문 체크후 해당 정점으로 이동
				visited[i] = true;
				dfs(i, visited);
			}
		}		
	}
	public static void bfs(int v) {
		//큐 생성
		Queue<Integer> queue = new LinkedList<Integer>();
		//방문 체크 배열
		boolean visited[] = new boolean[N+1];
		//첫 정점 큐에 삽입
		queue.offer(v);
		//방문 했다 체크
		visited[v] = true;
		//큐가 빌때까지
		while(!queue.isEmpty()) {
			//다음 정점 방문 후 추렭
			int temp = queue.poll();
			System.out.print(temp+" ");
			//갈수있는 정점 큐에 넣고 방문 체크 후 다음 정점 으로 
			for(int i=0; i<N+1; i++) {
				if(arr[temp][i] && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}
