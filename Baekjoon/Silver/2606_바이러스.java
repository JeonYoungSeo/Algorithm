import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-25
 * Description : 백준 11724
 */

public class Main{
	
	static int N;
	static int[] parents;
	
	public static void make() {
		parents = new int[N+1];
		
		for(int i=1; i<=N; i++)
			parents[i] = i;
	}
	
	public static int find(int n) {
		if(parents[n] == n) return n;
		
		return parents[n] = find(parents[n]);
	}
	
	public static void union(int a, int b) {
		
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return;
		
		parents[bRoot] = aRoot;
		
		return;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		make();
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken()); 
			union(a,b);
		}
		
		int count = -1;
		int parent = find(1);
		for(int i=1; i<=N; i++)
			if(find(i)==parent) count++;
		
		System.out.println(count);
	}
}
