import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] arags) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int N = Integer.parseInt(br.readLine());
    	boolean[][] board = new boolean[101][101];
    	
    	for(int tc=0; tc<N; tc++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	
        	for(int i=y; i<y+10; i++) {
        		for(int j=x; j<x+10; j++) {
        			board[i][j] = true;
        		}
        	}
    	}
    	int count = 0;
    	for(int i=1; i<101; i++) {
    		for(int j=1; j<101; j++) {
    			if(board[i][j]) count++;
    		}
    	}
    	
    	bw.write(count+" ");
    	
    	bw.flush();
    	bw.close();
    	br.close();
    }
}
