import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-28
 * Description : 백준 16134
 */


public class Main{
	
	static long div = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
    	StringTokenizer st= new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	
    	long[] fac = new long[N+1];
    	Arrays.fill(fac, 1);
    	for(int i=2; i<=N; i++) {
    		fac[i] = fac[i-1]*i%div; 
    	}
    	
    	long result = (fac[N]*pow(fac[N-K]*fac[K]%div,div-2)%div);
    	
    	bw.write(result+"\n");
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static long pow(long base, long expo) {
    	long result = 1;
    	
    	while(expo>0) {
    		if(expo%2 == 1) {
    			result *= base;
    			result %= div;
    		}
    		base = (base*base)%div;
    		expo /= 2;
    	}
    	return result;
    }
    

}
