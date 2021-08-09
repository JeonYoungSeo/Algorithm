import java.util.*;
import java.io.*;

class Solution
{
		public static void main(String args[]) throws Exception
	{
              BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			int[][] sdoku = new int[9][9];
			for(int i=0; i<9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<9; j++) {
					sdoku[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			boolean check = true;
			int[] x_range = {0,3,6,0,3,6,0,3,6};
			int[] y_range = {0,0,0,3,3,3,6,6,6};
			
			
	  out : for(int i=0; i<9; i++) {
			  	int[] check_x = new int[10];
				int[] check_y = new int[10];
				int[] check_sqr = new int[10];
				//가로 검사
				for(int j=0; j<9; j++) {
					check_x[sdoku[i][(i+j)%9]]++;
				}
				//세로 검사 
				for(int j=0; j<9; j++) {
					check_y[sdoku[(i+j)%9][i]]++;
				}
				//사각형 검사
				for(int j=y_range[i]; j<y_range[i]+3; j++) {
					for(int k=x_range[i]; k<x_range[i]+3; k++) {
						check_sqr[sdoku[j][k]]++;
					}
				}
				//1~9검사 
				for(int j=1; j<10; j++) {
					if(check_x[j] != 1 || check_y[j] != 1 || check_sqr[j] !=1) {
						check = false;
						break out;
					}
				}
				
			}
			if(check) bw.write("#"+test_case+" "+"1 \n");
			else bw.write("#"+test_case+" "+"0 \n");
		}
        bw.flush();
        bw.close();
        br.close();
	}
}
