import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-29
 * Description : 백준 2458
 */


public class Main{
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	int[][] arr = new int[N+1][N+1];
    	for(int i=1; i<=N; i++) {
    		Arrays.fill(arr[i], 987654321);
    	}
    	for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	arr[a][b] = 1;
    	}
    	//플로이드 와샬 적용
    	for(int k=1; k<=N; k++) {
    		for(int i=1; i<=N; i++) {
    			if(k==i) continue;
    			for(int j=1; j<=N; j++) {
    				if(k==j || j==i) continue;
    				
    				if(arr[i][j]>=arr[i][k]+arr[k][j]) {
    					arr[i][j] = arr[i][k]+arr[k][j];
    				}
    			}
    		}
    	}
    	
    	int[] count = new int[N+1];
    	//올수있는곳 갈수 있는곳 count 해준다
    	for(int i=1; i<=N; i++) {
    		for(int j=1; j<=N; j++) {
    			if(arr[i][j] == 987654321) continue;
    			count[i]++;
    			count[j]++;
    		}
    	}
    	int result = 0;
      //count가 N-1이면 순서를 구할수 있다. 
    	for(int i=1; i<=N; i++) {
    		if(count[i] == N-1) result ++;
    	}
    	bw.write(result+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
