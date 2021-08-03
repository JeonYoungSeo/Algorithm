import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int N = 1; N <= 10; N++)
		{
            int tc = Integer.parseInt(br.readLine());
            int[][] ladder = new int[100][100];
            int x=0;
            int y=99;
            //사다리 저장
            for(int i=0; i<100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++){
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            for(int i=0; i<100; i++){
                if(ladder[99][i] ==2){
                    x = i;
                }
            }
            
            int[] move_y = {0, 0, -1};
            int[] move_x = {-1, 1, 0};
            
            while(y != 0){
                for(int i=0; i<3; i++){
                    if(y+move_y[i]<100 && x+move_x[i]>=0 && x+move_x[i]<100){
                        if(ladder[y+move_y[i]][x+move_x[i]]==1){
                            if(i<2){
                                while(ladder[y][x]==1){
                            	x += move_x[i];
                         		if(x+move_x[i]<0 || x+move_x[i]>99) {
                                    x += move_x[i];
                                    break;
                         			}
                                }
                                x = x - move_x[i] + move_x[2];
                                y = y - move_y[i] + move_y[2];
                            	break;
                            }
                            else{
                                x += move_x[i];
                            	y += move_y[i];
                            }
                        }
                    }
    	       }
            }
            bw.write("#"+tc+" "+x);
            bw.newLine();
        }
    	bw.flush();
        bw.close();
        br.close();
    }
}
