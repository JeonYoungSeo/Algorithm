import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution{
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = 291;
        int[][] lst = new int[N][N];
        
        //첫번쨋줄 구하고
        lst[1][1] = 1;
        for(int i=2; i<N; i++) {
        	lst[1][i] = lst[1][i-1] + i; 
        }
        
        //나머지줄 완성
        for(int i=2; i<N; i++) {
        	lst[i][1] = lst[i-1][1] + i - 1;
        	for(int j=2; j<N; j++) {
        		lst[i][j] = lst[i][j-1] + i + j -1; 
        	}
        }
        //반복회수
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=1; tc<=T; tc++) {
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int p = Integer.parseInt(st.nextToken());
        	int q = Integer.parseInt(st.nextToken());
        	
        	int count = 0;
        	int I = 0;
        	int J = 0;
    	out : for(int i=1; i<N; i++) {
        		for(int j=1; j<N; j++) {
        			if(lst[i][j] == p) {
        				I+=i;
        				J+=j;
        				count++;
        			}
        			if(lst[i][j] == q) {
        				I+=i; 
        				J+=j;
        				count++;
        			}
        			if(count==2) break out;
        		}
        	}
        	
        	bw.write("#"+tc+" "+lst[I][J]+"\n");
        	
        }
        
        
        bw.flush();
        br.close();
        bw.close();
    }    
}
