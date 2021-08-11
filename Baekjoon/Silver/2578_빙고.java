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
        
        int[][] A = new int[5][5];
        
        //빙고판 입력
        for(int i=0; i<5; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0; j<5; j++) {
        		A[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int num=0;
        //사회자가 번호 부를거임
    first : for(int i=0; i<5; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0; j<5; j++) {
        		num++;
        		//번호 부른곳 0으로 
        		int temp = Integer.parseInt(st.nextToken());
        		out : for(int k=0; k<5; k++) {
        			for(int l=0; l<5; l++) {
        				if(A[k][l] == temp){
            				A[k][l] = 0;
            				break out;
        				}
        			}
        		}
        		
        		//검사
        		int count = 0;
        		
        		for(int y=0; y<5; y++) {
        			int check_y = 1;
            		int check_x = 1;
            		
        			for(int x=0; x<5; x++) {
        				if(A[y][x]!=0) check_x =0;
        				if(A[x][y]!=0) check_y = 0;
        			}
        			if(check_x==1) count++;
        			if(check_y==1) count++;
        		}
        		
        		//대각선 검사
        		int check_diag1 = 1;
        		int check_diag2 = 1;
        		
        		for(int y=0; y<5; y++) {
        			if(A[y][y] != 0) check_diag1 = 0;
        			if(A[4-y][y] != 0) check_diag2 = 0;
        		}
        		if(check_diag1==1) count++;
    			if(check_diag2==1) count++;    	
    			
    			if(count>=3) {
    				bw.write(num+"\n");
    				break first;
    			}
        		
        	}
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
