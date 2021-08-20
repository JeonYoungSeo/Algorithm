/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-21
 * Description : 백준 10026
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	
	static char[][] pic1, pic2;//정상인,색약을 위한 그림
	static int count_n=0, count_ab = 0 ,N;//정상인,색약 따로 카운트
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        pic1 = new char[N][N];
        pic2 = new char[N][N];
        //입력
        for(int i=0; i<N; i++) {
        	String str  = br.readLine();
        	for(int j=0; j<N; j++) {
        		pic1[i][j] = pic2[i][j] = str.charAt(j);
        		//색약은 R과 G를 구분 못한다.	
        		if(pic2[i][j] == 'G') pic2[i][j] = 'R';
        	}
        }
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		//정상
        		if(pic1[i][j] != 'x') {
        			count_n ++;
        			divideArea(pic1,pic1[i][j],i,j);
        		}
			//색약
        		if(pic2[i][j] != 'x') {
        			count_ab++;
        			divideArea(pic2,pic2[i][j],i,j);
        			
        	}
        }
        }
        System.out.println(count_n+" "+count_ab);
    }
        
    static int[] move_y = {1,0,-1,0};
    static int[] move_x = {0,-1,0,1};
	//인접 부분 x로 만듬
    private static void divideArea(char[][] pic,char color,int y, int x) {
    	for(int i=0; i<4; i++) {
    		pic[y][x]='x';
    		
    		int temp_y = y+move_y[i];
    		int temp_x = x+move_x[i];
    		
    		if(temp_x>=0 && temp_x<N && temp_y>=0 && temp_y<N && (pic[temp_y][temp_x]==color))
    			divideArea(pic,color,temp_y, temp_x);
    		
    	}
    }
}
