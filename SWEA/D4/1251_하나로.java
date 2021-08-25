import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//테스트 케이스 갯수
		int T = Integer.parseInt(br.readLine());
		//tc만큼 실행
		for(int tc = 1; tc<=T; tc++) {
            //섬의 갯수
			int N = Integer.parseInt(br.readLine());
            //섬의 좌표 
			int[] x = new int [N];
			int[] y = new int [N];
			
			//섬 입력  x좌표와 y좌표
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			//환경세
			double tax = Double.parseDouble(br.readLine());
			//가장 최솟값
			double min_result = Double.MAX_VALUE;

			//방문여부, 거리 배열
			boolean visited[] = new boolean[N];
			double[] cost = new double[N];
			//거리 초기화 
			Arrays.fill(cost, Double.MAX_VALUE);
			
			cost[start] = 0;
			double result = 0;
			for(int i=0; i<N; i++) {
				//1. 입력값에서 다음까지의 최소거리 구한다
				double min = Double.MAX_VALUE;
				int current = -1;
				for(int j=0; j<N; j++) {
					if(!visited[j] && min>cost[j]) {
						min = cost[j];
						current = j;
					}
				}
				visited[current] = true;
				result += cost[current];
				
				//2. 현재 위치에서 다음까지의 거리의 최솟값 구한다.
				//또한 방문하지 않은곳까지
				//Arrays.fill(cost, Double.MAX_VALUE);
				for(int j=0; j<N; j++) {
					double dis = (double) (Math.pow((y[j]-y[current]),2)+Math.pow((x[j]-x[current]),2));
					
					if(!visited[j] && cost[j]>dis) {
						cost[j] = dis;
					}
				}
			}

			//출력
			System.out.println("#"+tc+" "+String.format("%.0f", result*tax));
		}

	}
}
