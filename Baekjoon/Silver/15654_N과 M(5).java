import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-13
 * Description : 백준 15654
 */

public class Main{
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int M, N ;
	static int[] arr;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visited  = new boolean[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) 
        	arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
		permutation(sb,0);
        
        bw.flush();
        br.close();
        bw.close();
	}
	
	static boolean[] visited;
	public static void permutation(StringBuilder sb,int n) throws IOException {
		if(n == N) {
			bw.write(sb.toString()+"\n");
			return ;
		}
		
		for(int i=0; i<M; i++) {
			if(visited[i]) continue;
			sb.append(arr[i]+" ");
			visited[i] = true;
			permutation(sb,n+1);
			sb.setLength(sb.length()-1);
			if(sb.lastIndexOf(" ")!=-1) {
				sb.setLength(sb.lastIndexOf(" "));
				sb.append(" ");
			}else {
				sb.setLength(0);
			}
			
			 
			visited[i] = false;
		}
	}
}
