import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	
	static int N;
	static int[] parents;
	//가지는 부모를 가리키는 배열
	public static void make() {
		parents = new int[N+1];
		//배열 초기화
		for(int i=1; i<=N; i++)
			parents[i] = i;
	}
	//루트 부모를 찾는 함수
	public static int find(int n) {
    //자기 자신이 부모이면 return
		if(parents[n] == n) return n;
		//아니면 부모를 찾아서 저장
		return parents[n] = find(parents[n]);
	}
	//서로소 함수
	public static void union(int a, int b) {
		//각각의 부모 저장
		int aRoot = find(a);
		int bRoot = find(b);
		//같으면 하나의 집단
		if(aRoot == bRoot) return;
		//다르면 하나의 집단으로 합쳐준다.
		parents[bRoot] = aRoot;
		
		return;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		//테스트 케이스동안 동작
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//마을 주민의 수, 관계의 수 
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			//부모 배열 초기화 함수
			make();
			//입력 받아서 서로소함수로 다른 집단이면 합쳐준다.
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()); 
				int b = Integer.parseInt(st.nextToken()); 
				union(a,b);
			}
			//무리의 수를 세기 위해 모두 root parents를 찾아준뒤 갯수를 세준다.
			boolean[] check = new boolean[N+1];
			int count = 0;
			for(int i=1; i<=N; i++)
				find(i);
			for(int i=1; i<=N; i++)
				check[find(i)] = true;
			for(int i=1; i<=N; i++)
				if(check[i]) count++;
			
			System.out.println("#"+tc+" "+count);
		}
	}
}
