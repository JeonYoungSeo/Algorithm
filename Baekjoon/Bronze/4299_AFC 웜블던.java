import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-15
 * Description : 백준 
 */


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int sum = Integer.parseInt(st.nextToken());
        int sub = Integer.parseInt(st.nextToken());
        
        if(sub<sub) {
        	System.out.println(-1);
        	return;
        }
        
        int result = sum+sub;
        
        if(result%2==0) {
        	bw.write(result/2+" "+(sum-sub)/2);
        }else {
        	bw.write("-1");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
