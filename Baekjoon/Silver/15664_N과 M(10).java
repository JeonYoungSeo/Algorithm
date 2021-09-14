import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-14
 * Description : 백준 15664
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
		permutation(sb,0,0);
        
        bw.flush();
        br.close();
        bw.close();
	}
	
	static boolean[] visited;
	public static void permutation(StringBuilder sb,int n,int curr) throws IOException {
		if(n == N) {
			bw.write(sb.toString()+"\n");
			return ;
		}
		
		for(int i=curr; i<M; i++) {
			if(visited[i] || (i>=1&&(!visited[i-1]&& (arr[i]==arr[i-1])))) continue;
			
			if(i>=1 && sb.lastIndexOf(" ")!=-1) {
				sb.setLength(sb.length()-1);
				int temp = Integer.parseInt(sb.substring(sb.lastIndexOf(" ")+1));
				sb.append(" ");
				
				if(temp>arr[i]) continue;
			}
			
			sb.append(arr[i]+" ");
			visited[i] = true;
			permutation(sb,n+1,curr+1);
			sb.setLength(sb.length()-1);
			if(sb.lastIndexOf(" ")!=-1) {
				sb.setLength(sb.lastIndexOf(" "));
				sb.append(" ");
			}else {
				sb.setLength(0);
			}
			visited[i] = false;
			
			curr++;
		}
	}
}
