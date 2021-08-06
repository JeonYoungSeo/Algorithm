import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] times = new int[1001];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	times[Integer.parseInt(st.nextToken())]++;
        }
        
        int count = 0;
        int time = 0 ;
        int acc = 0;
        for(int i=1; i<1001; i++) {
        	if(times[i]>0) {
        		for(int j=1; j<=times[i]; j++) {
        			acc += i;
        			time += acc;
        			count ++;
        			if(count == N) break;
        		}
        	}
        }
        bw.write(time+"\n");
        
        bw.flush();
        bw.close();
        br.close();
    }                
}
