import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-24
 * Description : SWEA 3289
 */

public class Main{
	static int N; //원소 개수
	static int[] parents; //부모원소 관리
	
	//모든원소를 자신을 대표자로 만듦
	private static void make() {
		for(int i=1; i<N+1; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(a==parents[a]) return a;//자신이 대표자
		return parents[a] = find(parents[a]); //자신이 속한 집하의 대표자를 자신의 부모로 : path compression
		
	}
	
	//두 원소를 하나의 집합으로 합치기
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		
		
		return true;
		
	}
	
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc =1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N=Integer.parseInt(st.nextToken());
			parents = new int[N+1]; 
			make();
			int M = Integer.parseInt(st.nextToken());
			
			System.out.print("#"+tc+" ");
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				
				if(c==0) {
					union(a,b);
				}else {
					int aRoot = find(a);
					int bRoot = find(b);
					if(aRoot==bRoot)
						System.out.print(1);
					else
						System.out.print(0);
				}
			}
			System.out.println();
		}
	}
}
