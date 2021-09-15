import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-15
 * Description : 백준 3004 
 */


public class Main{
	static int C,R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int inc = 1;
        int result = 1;
        for(int i=1; i<=N; i++) {
        	if(i%2 == 0) inc++;
        	
        	result += inc;
        }
        
        System.out.println(result);
    }
}
