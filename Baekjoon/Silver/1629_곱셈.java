import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        
        bw.write(pow(A,B,C)+"\n");
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static long pow(long a, long b, long c) {
    	
    	if(b==1) return a%c;
    	
    	long half = pow(a,b/2,c);
    	
    	if(b%2==0) {
    		return half*half%c;
    	}else {
    		return (((a*half)%c)*half)%c;
    	}
    }
}
