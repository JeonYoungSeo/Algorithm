import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());

        
        for(int tc=1; tc<=T; tc++) {
        	int K = Integer.parseInt(br.readLine());
        	
        	int[][] gear = new int[5][8];
        	//기어정보 입력
        	for(int i=1; i<5; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		for(int j=0; j<8; j++){
        			gear[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	for(int k=0; k<K; k++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		
        		int n = Integer.parseInt(st.nextToken());
        		int d = Integer.parseInt(st.nextToken());
        		int dir[] = new int[5];
        		for(int i=1; i<5; i++) {
        			if((n%2==0 && i%2==0) || (n%2==1 && i%2==1)) {
        				dir[i] = d;
        			}else if((n%2==1 && i%2==0)||(n%2==0 && i%2==1)) {
        				dir[i] = -d;
        			}
        		}
        		//돌릴수 있는지
        		boolean[] checked = new boolean[5];
        		checked[n] = true;
        		//돌아가는지 확인
        		check(gear, n, checked);
        		
        		//돌려
        		spin(gear,n,dir,checked);
        	}
        	int cnt = 0; 
        	for(int i=1; i<5; i++) {
        		if(gear[i][0]==1)
        			cnt += 1<<(i-1);
        	}
        	
        	bw.write("#"+tc+" "+cnt+"\n");
        }
        
        bw.flush();
        bw.close();
        br.close();	
    }

	private static void spin(int[][] gear, int n, int[] dir, boolean[] checked) {
		for(int i=1; i<5; i++) {
			if(!checked[i]) continue;
			
			if(dir[i]==1) {
				for(int j=0; j<8; j++) {
					int temp = gear[i][j];
					gear[i][j] = gear[i][0];
					gear[i][0] = temp;
				}
			}else {
				for(int j=7; j>=0; j--) {
					int temp = gear[i][j];
					gear[i][j] = gear[i][0];
					gear[i][0] = temp;
				}
			}
		}
	}

	private static void check(int[][] gear, int n, boolean[] checked) {		
		
		//왼쪽 확인
		for(int i=n; i>1; i--) {
			if(gear[i][6]!=gear[i-1][2]) {
				checked[i-1] = true;
			}else {
				break;
			}
		}
		
		//오른쪽 확인
		for(int i=n; i<4; i++) {
			if(gear[i][2]!=gear[i+1][6]) {
				checked[i+1] = true;
			}else {
				break;
			}
		}
	}
}
