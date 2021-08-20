/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-20
 * Description : 백준 1927
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[][] field;
	static int count;
	static int N,M;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T  = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tc = 0; tc<T; tc++) {
        	st = new StringTokenizer(br.readLine());
        	//가로 세로 배추의 개수
        	M = Integer.parseInt(st.nextToken());
        	N = Integer.parseInt(st.nextToken());
        	int K = Integer.parseInt(st.nextToken());
        	//밭 생성
        	field = new int[N][M];
        	//배추 심기
        	for(int i=0; i<K; i++) {
        		st = new StringTokenizer(br.readLine());
        		int x = Integer.parseInt(st.nextToken());
        		int y = Integer.parseInt(st.nextToken());
        		field[y][x] = 1;
        	}
        	count = 0;
        	//지렁이 확인
        	for(int i=0; i<N; i++) {
        		for(int j=0; j<M; j++) {
        			if(field[i][j] == 1) {
        				count ++;
        				worm(i, j);
        			}
        		}
        	}
        	
        	System.out.println(count);
        }
    }        
    static int[] move_y = {1,0,-1,0};
    static int[] move_x = {0,-1,0,1};
  //재귀 돌면서 다 0으로 만든다
    public static void worm(int y, int x) {
    	field[y][x]=0;
    	
    	for(int i=0; i<4; i++) {
    		int temp_y = y+move_y[i];
    		int temp_x = x+move_x[i];
    		
    		if(temp_x>=0 && temp_x<M && temp_y>=0 && temp_y<N && (field[temp_y][temp_x]==1))
    			worm(temp_y, temp_x);
    	}
    }
}
