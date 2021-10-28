import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


/* 백준 14226번 문제 이모티콘
  BFS문제이다. 가장 빨리 해당 갯수를 완성시킬수 있는 시간을 찾는문제 
  방문 체크시 숫자와 클립보드의 숫자를 동시에 체크해주는것이 포인트인것 같다.
*/
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int S = Integer.parseInt(br.readLine());
		boolean[][] visited = new boolean[2001][2001];
		Queue<int[]> que = new LinkedList<>();
		
		que.add(new int[] {1,0});
		int result = 0;
		while(!que.isEmpty()) {
			int cnt = que.size();
			while(cnt-->0) {
				int[] curr = que.poll();
				int num = curr[0];
				int clip = curr[1];
				
				if(visited[num][clip]) continue;
				
				visited[num][clip] = true;
				
				
				if(num == S) {
					System.out.println(result);
					return;
				}
				
				//1.이모티콘 복사 클립보드에 저장
				que.add(new int[] {num, num});
				
				//2. 클립보드에 있는 이모티콘 붙여넣기
				if(num+clip<2001)
					que.add(new int[] {num+clip, clip});
				
				//3. 이모티콘 삭제
				if(num-1>=0)
					que.add(new int[] {num-1, clip});
				
			}
			result ++;
		}
		
	}
}
