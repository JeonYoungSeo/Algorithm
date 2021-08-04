import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
            
		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            int[][] field = new int[N][N];
            
            for(int i=0; i<N; i++) {
            	StringTokenizer st2 = new StringTokenizer(br.readLine());
            	for(int j=0; j<N; j++) {
            		field[i][j] = Integer.parseInt(st2.nextToken());
            	}
            }
            
            int max_fly = -1;
            for(int i=0; i<=N-M; i++){
                for(int j=0; j<=N-M; j++){
                    int sum_fly = 0 ;
                    for(int y = i; y < i+M; y++){
                        for(int x = j; x < j+M; x++){
                            sum_fly += field[y][x];
                        }
                    }
                    if(max_fly<sum_fly) max_fly = sum_fly; 
                }
            }
            
            bw.write("#"+test_case+" "+max_fly+"\n");
		}
        bw.flush();
        bw.close();
        br.close();
	}
}
