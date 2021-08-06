import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        R = (R%N==0)? R/N: (R/N)+1;
        C = (C%N==0)? C/N: (C/N)+1;
        
        bw.write((long)R*C+"\n");
        
        bw.flush();
        bw.close();
        br.close();
    }                
}
