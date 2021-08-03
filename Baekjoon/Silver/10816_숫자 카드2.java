import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        char[] lst = new char[200000002];
        int[] over_count = new int[50000];
        int over = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<N; i++) {
        	int temp = Integer.parseInt(st.nextToken());
        	
        	lst[temp+10000000]++;
        	if(lst[temp+10000000] == 65535) {
        		lst[temp+10000000] = 0;
        		over_count[over++] = temp;
        	}
        }
        
        int M = Integer.parseInt(br.readLine());
        
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
        	int temp = Integer.parseInt(st2.nextToken());
        	
        	int count = 0;
        	for(int j=0; j<over; j++) {
        		if(over_count[j] == temp) count++;
        	}
        	
        	bw.write((count*65535+(int)lst[temp+10000000])+" ");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
