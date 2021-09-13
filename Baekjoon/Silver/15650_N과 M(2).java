import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-13
 * Description : 백준 15650
 * 순열에서 조건에 맞게 수정해주었다. 
 */

public class Main{
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int M, N ;
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visited = new boolean[M];
        for(int i=0; i<M; i++) 
        	arr[i] = i+1;
        
        StringBuilder sb = new StringBuilder();
		permutation(sb,0,1);
        
        bw.flush();
        br.close();
        bw.close();
	}
	
	
	public static void permutation(StringBuilder sb,int n,int pre) throws IOException {
		if(n == N) {
			bw.write(sb.toString()+"\n");
			return ;
		}
		
		for(int i=pre; i<=M; i++) {
			sb.append(i+" ");
			permutation(sb,n+1,i+1);
			sb.setLength(sb.length()-2);
		}
	}
}
