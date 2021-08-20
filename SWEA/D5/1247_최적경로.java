import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int min_dis,N;
	static int[][] pos;
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			//첫번째는 회사의 좌표, 두번째부터 고객의 좌표
			pos = new int[N+2][2];
			//방문 여부
			visited = new boolean[N+2];
			//출력물
			min_dis = Integer.MAX_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			//입력
			for(int i=0; i<N+2; i++) {
				pos[i][0] = Integer.parseInt(st.nextToken());
				pos[i][1] = Integer.parseInt(st.nextToken());
			}
			//방문 함수
			visit(0, 0,0); //(방문한 회사 번호, 누적 거리)
			
			System.out.println("#"+tc+" "+min_dis);
		}
	}
	//함수 부분
	public static void visit(int c_num, int dis, int num) {
		//기저조건
		if(num == N) {
			//마지막엔 집으로
			dis += Math.abs(pos[c_num][0]-pos[1][0])+Math.abs(pos[c_num][1]-pos[1][1]);
			min_dis = (min_dis>dis)? dis:min_dis;
			return;
		}
		
		//어디부터 방문 할래 ? 
		for(int i=2; i<=N+1; i++) {
			//방문했으면 패스
			if(visited[i]==true) continue;
			//거리 더해주기
			int temp = Math.abs(pos[c_num][0]-pos[i][0])+Math.abs(pos[c_num][1]-pos[i][1]);
			//최소거리를 구할거니 최소거리보다 길어지면 종료.
			if(dis>=min_dis) return;
			dis += temp;
			visited[i] = true;
			visit(i, dis,num+1);
			visited[i] = false;
			dis -= temp;
		}
		
	}	
}
