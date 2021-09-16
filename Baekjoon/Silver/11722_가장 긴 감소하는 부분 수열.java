import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-16
 * Description : 백준 
 */


public class Main{
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int[] LIS = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int max = 0;
        for(int i=0; i<N; i++) {
        	LIS[i] = 1;
        	
        	for(int j=0; j<i; j++) {
        		if(arr[i]<arr[j] && LIS[i]<LIS[j]+1) {
        			LIS[i] = LIS[j]+1;
        		}
        	}
        	max = Math.max(LIS[i], max);
        }
        
        bw.write(max+"\n");
        
        bw.flush();
        bw.close();
        br.close();
    }
}
