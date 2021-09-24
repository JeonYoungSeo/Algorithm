import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //표 생성
        int[][] chart = new int[N+1][N+1];
        //입력 
        for(int i=1; i<=N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	for(int j=1; j<=N; j++) {
        		chart[i][j] = chart[i][j-1] + Integer.parseInt(st.nextToken());
        	}
        }
        
        //M횟수만큼 값 입/출력
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int x1 = Integer.parseInt(st.nextToken()); 
        	int y1 = Integer.parseInt(st.nextToken()); 
        	int x2 = Integer.parseInt(st.nextToken()); 
        	int y2 = Integer.parseInt(st.nextToken()); 
        	
        	int result = 0;
        	
        	for(int x=x1; x<=x2; x++) {
    			result += chart[x][y2]-chart[x][y1-1];
        	}
        	
        	bw.write(result+"\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
