package prac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-13
 * Description : 백준 1932
*                아래서부터 올라오면서 최대값을 합쳐주었습니다. 
 */

public class Main{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        int n = Integer.parseInt(br.readLine());
        
        int[][] tri = new int[n][];
        
        StringTokenizer st;
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	tri[i] = new int[i+1];
        	
        	for(int j=0; j<=i; j++) {
        		tri[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        
        for(int i=n-1; i>0; i--) {
        	for(int j=0; j<i; j++) {
        		tri[i-1][j] += Math.max(tri[i][j], tri[i][j+1]);
        	}
        }
        
        bw.write(tri[0][0]+"\n");
        bw.flush();
        br.close();
        bw.close();
	}
}
