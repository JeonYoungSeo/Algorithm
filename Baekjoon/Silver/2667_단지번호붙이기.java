/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-21
 * Description : 백준 2667 단지 번호 붙이기
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	static int[][] field;
	static int count;
	static int N;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        
        StringTokenizer st;
    	st = new StringTokenizer(br.readLine());
    	// field의 가로세로 크기
    	N = Integer.parseInt(st.nextToken());
    	//필드 생성
    	field = new int[N][N];
    	//입력 받기
    	for(int i=0; i<N; i++) {
    		String str = br.readLine();
    		for(int j=0; j<N; j++) {
    			field[i][j] = str.charAt(j)-'0';
    		}
    	}
    	
    	//단지에 집 수를 넣기 위한 리스트
    	List<Integer> lst = new ArrayList<Integer>();
    	//아파트 확인
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<N; j++) {
    			if(field[i][j] == 1) {
            //카운트 변수 초기화
    				count =0;
    				danji(i, j);//함수 실행
    				lst.add(count); //리스트에 단지의 아파트 수 추가
    			}
    		}
    	}
      //단지 갯수 출력
    	bw.write(lst.size()+"\n");
    	//오름차순 정렬 위함
    	int[] forprint = new int[lst.size()];
    	for(int i=0; i<lst.size(); i++) {
    		forprint[i] = lst.get(i);
    	}
    	Arrays.sort(forprint);
    	for(int i=0; i<lst.size(); i++) {
    		bw.write(forprint[i]+"\n");
    	}
    	
    	bw.flush();
    	bw.close();
    	br.close();
    }        
    //붙어있는곳 다 0으로 만드는 동시에 집의 갯수를 샌다.
    static int[] move_y = {1,0,-1,0};
    static int[] move_x = {0,-1,0,1};
    public static void danji(int y, int x) {
    	field[y][x]=0;
    	count++;
    	for(int i=0; i<4; i++) {
    		int temp_y = y+move_y[i];
    		int temp_x = x+move_x[i];
    		
    		if(temp_x>=0 && temp_x<N && temp_y>=0 && temp_y<N && (field[temp_y][temp_x]==1))
    			danji(temp_y, temp_x);
    	}
    }
}
