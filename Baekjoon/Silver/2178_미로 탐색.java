/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-25
 * Description : 백준 2178
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//세로 가로 크기 입력
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		//미로 생성
		int[][] maze = new int[N][M];
		//미로 입력
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				maze[i][j] = str.charAt(j)-'0';
			}
		}
		
		//이 문제는 너비 우선 탐색으로 풀어야 한다. 
		//0,0이 시작점 N-1,M-1 이 도착점
		//큐 생성
		Queue<int[]> queue = new LinkedList<int[]>();
		//방문 배열 생성
		boolean[][] visited = new boolean[N][M];
		//시작 y,x값
		int y =0;
		int x = 0;
		queue.add(new int[] {y,x});
		visited[y][x] = true;
		int result = 0;
		
		int[] my = {1,0,-1,0};
		int[] mx = {0,1,0,-1};
		//BFS 실행
	out : while(!queue.isEmpty()) {
			int size = queue.size();
			result ++;
			while(size!=0) {
				int[] temp = queue.poll();
				size --;
				
				y = temp[0];
				x = temp[1];
				
				if(y == N-1 && x == M-1) {
					break out;
				}
				
				for(int i=0; i<4; i++) {
					int temp_y = y+my[i];
					int temp_x = x+mx[i];
					
					if(temp_y>=0 && temp_x>=0 && temp_y<N && temp_x<M && !visited[temp_y][temp_x] && maze[temp_y][temp_x]==1) {
						queue.add(new int[] {temp_y,temp_x});
						visited[temp_y][temp_x] = true;
					}
				}
			}
			
		}
		
		System.out.println(result);
		bw.flush();
		bw.close();
		br.close();
	}
}

