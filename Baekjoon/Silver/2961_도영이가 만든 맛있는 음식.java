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
        
        int N = Integer.parseInt(br.readLine());
        
        int[] S = new int[N]; 
        int[] B = new int[N]; 
        
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	S[i] = Integer.parseInt(st.nextToken());
        	B[i] = Integer.parseInt(st.nextToken());
        }
        
        int min_sub = Integer.MAX_VALUE;
        for(int i=1; i<Math.pow(2, N); i++) {
        	int sum_S=1;
        	int sum_B=0;
        	
        	for(int j=0; j<N; j++) {
        		if((i & 1<<j) != 0) {
        			sum_S *= S[j];
        			sum_B += B[j];
        		}
        	}
        	
        	int sub = (sum_S>sum_B)? sum_S-sum_B : sum_B-sum_S;
        	min_sub = (min_sub>=sub)? sub : min_sub;
        }
        
        bw.write(min_sub+"\n");
        bw.flush();
        br.close();
        bw.close();
    }    
}

