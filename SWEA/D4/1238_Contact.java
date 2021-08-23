import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-22
 * Description : SWEA 1238
 */

public class Main{
	static boolean[][] arr;
	static int max_value;
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//10번의 테스트 케이스
		for(int tc=1; tc<=10; tc++) {
			arr = new boolean [101][101];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			//길이, 시작 정점 입력
			int leng = Integer.parseInt(st.nextToken())/2;
			int start = Integer.parseInt(st.nextToken());
			
			//입력
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<leng; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				arr[from][to] = true;
			}
			max_value = 0;
      //bfs시작
			bfs(start);
			
			System.out.println("#"+tc+" "+max_value);
		}
	}
	
	public static void bfs(int v) {
		//큐 생성
		Queue<Integer> queue = new LinkedList<Integer>();
		// 방문 배열 및 첫 번째 방문 처리
		boolean visited[] = new boolean[101];
		queue.offer(v);
		visited[v] = true;
		int value=0;
    
		while(!queue.isEmpty()) {
      //size받는 이유는 각각의 level마다 최대 숫자를 구하기 위해서
			int size = queue.size();
			value = 0;
			while(size-- >0) {
				int temp = queue.poll();
				for(int i=1; i<arr.length; i++) {
					if(arr[temp][i] == true && !visited[i]){
						queue.offer(i);
						visited[i] = true;
					}
				}
				value = Math.max(value, temp);
			}
		}
    //최종level의 큰 수만 구해서 저장한다.
		max_value = value;
	}
}
