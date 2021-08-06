import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        
        int[] seat = new int[N+1];
        int person  = 1;
        seat[1] = 1;
        int count = 0;
        while(true) {
        	if(seat[person] == M) {
        		break;
        	}
        	
        	if(seat[person]%2 == 1) {
        		person = (person+L>N)? (person+L)%N : person+L;
        		seat[person]++;
        		count++;
        	}else {
        		person = (person-L<1)?N+person-L : person-L;
        		seat[person]++;
        		count++;
        	}
        }
        bw.write(count+"\n");
        bw.flush();
        bw.close();
        br.close();
    }                
}
