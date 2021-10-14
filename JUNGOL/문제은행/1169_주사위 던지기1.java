import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr,visited;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		if(M==1) {
			permu(0);
		}else if(M==2) {
			permu2(0,1);
		}else {
			visited = new int[7];
			permu3(0);
		}
		
		
	}

	private static void permu(int n) {
		if(n==N) {
			for(int i=0; i<N; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<=6; i++) {
			arr[n]=i;
			permu(n+1);
		}
	}

	private static void permu2(int n,int num) {
		if(n==N) {
			for(int i=0; i<N; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=num; i<=6; i++) {
			arr[n]=i;
			permu2(n+1,i);
		}
	}

	private static void permu3(int n) {
		if(n==N) {
			for(int i=0; i<N; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<=6; i++) {
			if(visited[i]==1) continue;
			visited[i] = 1;
			arr[n]=i;
			permu3(n+1);
			visited[i] = 0;
		}
	}
}
