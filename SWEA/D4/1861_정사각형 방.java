import java.util.*;
import java.io.*;

class Solution
{
     static int[][] square;
    static int[] move_x = {0,0,-1,1};
    static int[] move_y = {-1,1,0,0};
    static int N;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = Integer.parseInt(br.readLine());
            square = new int[N][N];
            
            StringTokenizer st;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    square[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int max = -1;
            int result_y = 0;
           	int result_x = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    int temp = count(i,j)+1;
                    if(temp>max){
                        max = temp;
                        result_y = i;
                    	result_x = j;
                    }else if(temp == max){
                    	if(square[i][j] < square[result_y][result_x]){
                    		result_y = i;
                        	result_x = j;
                    	}
                    }
                }
            }
            bw.write("#"+test_case+" "+square[result_y][result_x]+" "+max+"\n");
		}
        bw.flush();
        bw.close();
        br.close();
	}
    
    private static int count(int y, int x){//좌표 전달
        //기저 조건?? 
        int result = 0;

        for(int i=0; i<4; i++){
            if(y+move_y[i]>-1 && y+move_y[i]<N && x+move_x[i]>-1 && x+move_x[i]<N){
                if(square[y][x]+1 == square[y+move_y[i]][x+move_x[i]]){
                    result += 1;
                    result += count(y+move_y[i], x+move_x[i]);
                }
            }
        }
        
        return result;
    }                
}
