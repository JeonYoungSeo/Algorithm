import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
	static int[] team,pop;
	static boolean [] visited;
	static int N, result;
	static boolean[][] adj;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //구역 개수
        N = Integer.parseInt(br.readLine());
        team = new int[N+1];
        visited = new boolean[N+1];
        //인구수
        pop = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=1; i<=N; i++) {
        	pop[i] = Integer.parseInt(st.nextToken());
        }
        //인접 행렬 표기
        adj = new boolean[N+1][N+1];
        //입력
        for(int i=1; i<=N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int n = Integer.parseInt(st.nextToken());
        	for(int j=1; j<=n; j++) {
        		int end = Integer.parseInt(st.nextToken());
        		adj[i][end] = true;
        	}
        }
      //결과값
        result = Integer.MAX_VALUE;
      //순열 : 1개4개 고른거랑 4개1개 고른거 똑같으므로 절반갯수만큼만  A팀으로 만든다.
        permu(0, N/2);
        //출력
        if(result == Integer.MAX_VALUE) {
        	bw.write(-1+"\n");
        }else {
        	bw.write(result+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
	}

	private static void permu(int cnt, int num) {
    //절반 넘어가면 종료, 0~절반이면 연결체크한다.
		if(cnt==num+1) {
			return;
		}else if(cnt>0){
			check();
		}
		
		for(int i=1; i<=N; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			team[i] = 1;
			permu(cnt+1,num);
			team[i] = 0;
			visited[i] = false;
		}
	}

	private static void check() {
    //첫 a구역을 고른다.
		int anum=0;
		for(int i=1; i<=N; i++) {
			if(team[i]==1) {
				anum=i;
				break;
			}
		}
		svisited = new boolean[N+1];
		svisited[anum] = true;
		int a = dfs(anum); //갈수 있는 구역 갯수
		//첫 B구역 구한다
		int bnum = 0;
		for(int i=1; i<=N; i++) {
			if(team[i]==0) {
				bnum = i;
				break;
			}
		}
		svisited = new boolean[N+1];
		svisited[bnum] = true;
		int b = dfs2(bnum); //갈수있는 구역 갯수
		
		//갈수있는 갯수를 더해서 전체 구역수가 되면 차이의 최소를 구한다.
		if(a+b==N) {
			int aTeam = 0;
			int bTeam = 0;
			
			for(int i=1; i<=N; i++) {
				if(team[i]==1) {
					aTeam += pop[i];
				}else {
					bTeam += pop[i];
				}
			}
			
			result = Integer.min(result, Math.abs(aTeam-bTeam));
		}
	}

	static boolean[] svisited;
	private static int dfs(int n) {
		
		int result = 1;
		
		for(int i=1; i<=N; i++) {
			if(adj[n][i] && !svisited[i] && team[i]==1) {
				svisited[i] = true;
				result += dfs(i);
			}
		}
		
		return result;
	}
	
	private static int dfs2(int n) {
		
		int result = 1;
		
		for(int i=1; i<=N; i++) {
			if(adj[n][i] && !svisited[i] && team[i]==0) {
				svisited[i] = true;
				result += dfs2(i);
			}
		}
		
		return result;
	}
}
