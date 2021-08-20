/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-12
 * Description : 백준 1927
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N  = Integer.parseInt(st.nextToken());
        int M  = Integer.parseInt(st.nextToken());
        
        HashMap<String, String> map = new HashMap<String, String>();
        
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	map.put(st.nextToken(), st.nextToken());
        }
        
        for(int i=0; i<M; i++) {
        	System.out.println(map.get(br.readLine()));
        }
        
    }        
}
