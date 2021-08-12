/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-12
 * Description : 백준 10814
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        //수의 개수
        int N = Integer.parseInt(br.readLine());
    	
        String[] lst = new String[100001];
        for(int i=0; i<100001; i++) {
        	lst[i] = new String();
        }
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int temp = Integer.parseInt(st.nextToken());
    		lst[temp] += (" "+st.nextToken());
    	}
        
        for(int i=0; i<100001; i++) {
        	StringTokenizer st = new StringTokenizer(lst[i]);
        	while(st.hasMoreTokens()) {
        		bw.write(i+" "+st.nextToken()+"\n");
        	}
        	
        }
        bw.flush();
        bw.close();
        br.close();
        
    }
}

