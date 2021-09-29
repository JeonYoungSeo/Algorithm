package prac;
	
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
 * Description : 백준
 */


public class Main{
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=1; tc<=T; tc++) {
        	int N = Integer.parseInt(br.readLine());
        	int M = Integer.parseInt(br.readLine());
        	
        	int[][] arr = new int[N+1][N+1];
        	for(int i=1; i<=N; i++) {
        		Arrays.fill(arr[i], 987654321);
        	}
        	for(int i=0; i<M; i++) {
	        	StringTokenizer st = new StringTokenizer(br.readLine());
	        	
	        	int a = Integer.parseInt(st.nextToken());
	        	int b = Integer.parseInt(st.nextToken());
	        	
	        	arr[a][b] = 1;
        	}
        	
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
        	
        	for(int i=1; i<=N; i++) {
        		for(int j=1; j<=N; j++) {
        			if(arr[i][j] == 987654321) continue;
        			count[i]++;
        			count[j]++;
        		}
        	}
        	int result = 0;
        	for(int i=1; i<=N; i++) {
        		if(count[i] == N-1) result ++;
        	}
        	bw.write("#"+tc+" "+result+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
