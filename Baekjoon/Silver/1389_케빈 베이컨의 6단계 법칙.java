import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-26
 * Description : 백준 1389
 */

public class Main{
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//사람의 수, 관계의 수
		int N = Integer.parseInt(st.nextToken())+1;
		int M = Integer.parseInt(st.nextToken());
		//인접 행렬 생성
		int[][] matrix = new int[N][N];
		//인접 행렬 입력
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			matrix[y][x] = 1;
			matrix[x][y] = 1;
		}
		//bfs를 위한 큐 생성
		Queue<Integer> queue = new LinkedList<Integer>();
		//각 번호의 케빈 베이컨 수 저장
		int[] count = new int[N];
		for(int start=1; start<N; start++) {
      //bfs 생성
			boolean[] visited = new boolean[N];
			queue.add(start);
			visited[start] = true;
			
			int dis = 0;
			int result =0;
			while(!queue.isEmpty()) {
				int size = queue.size();
				while(size!=0) {
					int curr = queue.poll();
					size --;
          //케빈베이컨 거리 계산
					result += dis;
					
					for(int i=1; i<N; i++) {
						if(!visited[i] && matrix[curr][i]==1) {
							queue.add(i);
							visited[i] = true;
						}
					}
				}
				dis++;
			}
      //후 저장
			count[start] = result;
		}
    //가장 작은 베이컨 거리 찾은뒤 출력
		int min_value = 987654321;
		int print=0;
		for(int i=1; i<N; i++) {
			if(count[i]!=0 && min_value>count[i]) {
				min_value = count[i];
				print = i;
			}
		}
		
		System.out.println(print);
	}
}
