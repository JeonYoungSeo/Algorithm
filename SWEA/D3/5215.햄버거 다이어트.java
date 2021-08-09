import java.util.*;
import java.io.*;

class Solution
{
		static int[] fav;
    static int[] cal ;
    static int L, N;
	public static void main(String args[]) throws Exception
	{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            fav = new int[N];
            cal = new int[N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                fav[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }
            result = 0;
            recur(0,0,0);
        	bw.write("#"+test_case+" "+result+"\n");
		}
        bw.flush();
        bw.close();
        br.close();
	                
	}
    static int result=0;
    static private void recur(int num, int cal_sum, int fav_sum){
        if(num ==N){
            if(result<fav_sum && cal_sum<=L){
                result = fav_sum;
            }
            return;
        }
        recur(num+1, cal_sum+cal[num], fav_sum+fav[num]);
        recur(num+1, cal_sum, fav_sum);
    }
}
