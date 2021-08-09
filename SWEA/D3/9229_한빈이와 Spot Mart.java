import java.util.*;
import java.io.*;

public class Solution{
	static int N, M;
	static int[] a;
	static int maxnack;
	public static void main(String args[]) throws Exception
	{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			a = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			maxnack = -1 ;
			for(int i=0; i<N; i++) {
				snack(i,i+1);
			}
			
			bw.write("#"+test_case+" "+maxnack+"\n");

		}
        bw.flush();
        bw.close();
        br.close();
	}
	static private void snack(int first, int second) {
		if(first >=N || second>=N) return ;
		int weight = a[first] + a[second];
		if(weight<=M && maxnack<weight) maxnack = weight;
		snack(first, second+1);
		return ;
	}
}
