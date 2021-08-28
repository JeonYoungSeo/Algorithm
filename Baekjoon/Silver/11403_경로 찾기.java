import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-28
 * Description : 백준 11403
 */

public class Main{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    //정점의 개수
		int N = Integer.parseInt(br.readLine())+1;
		//입력 행렬, 결과 행렬
		int[][] matrix = new int[N][N];
		int[][] rMatrix = new int[N][N];
    
    //입력받는다.
		for(int i=1; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//각각의 번호에서 출발해서 갈수있는 곳을 1로 만들어준다.
		for(int i=1; i<N; i++) {
      //BFS위한 큐와 방문 여부 리스트
			Queue<Integer> queue = new LinkedList<Integer>();
			boolean[] visited = new boolean[N];
			//첫 원소 추가
			queue.add(i);
			//큐가 빌때까지 진행한다.
			while(!queue.isEmpty()) {
				int curr = queue.poll();
			  // curr 정점에서 갈수 있는곳을 큐에 넣고 방문 체크한다. 이때 이미 간곳은 가지 않는다.(중복 및 무한루프 가능성)
				for(int j=1; j<N; j++) {
					if(matrix[curr][j] == 1 && !visited[j]) {
						rMatrix[i][j] = 1;
						queue.add(j);
						visited[j] = true;
					}
				}		
				
			}
		}
		//출력한다.
		for(int i=1; i<N; i++) {
			for(int j=1; j<N; j++) {
				bw.write(rMatrix[i][j]+" ");
			}
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
			
	}
}

