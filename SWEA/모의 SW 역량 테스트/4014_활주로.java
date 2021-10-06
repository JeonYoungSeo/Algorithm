import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution{
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //tc
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=1; tc<=T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	//지형 크기, 활주로 길이
        	int N = Integer.parseInt(st.nextToken());
        	int X = Integer.parseInt(st.nextToken());
        	//지형 정보
        	int[][] map = new int[N][N];
        	//입력
        	for(int i=0; i<N; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j=0; j<N; j++) {
        			map[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	int result = 0;
        	//가로 검사
			//경사로 설치 여부 배열
        	boolean[][] rInstall = new boolean[N][N];
        	for(int y=0; y<N; y++) {
				//각 줄마다 검사
        		int curr = 0;
        		for(int x=0; x<N; x++) {
        			if(x==N-1) {
        				result++;
        				break;
        			}
					//높이가 같으면 통과
        			if(map[y][x]==map[y][x+1])continue;
        			//높이가 2이상 차이나면 실패
        			if(Math.abs(map[y][x]-map[y][x+1])>1) break;
        			//높이가 높아지면
        			if(map[y][x+1]-map[y][x]>0) {
	    				curr=x;
	    				int cnt = 0;
	    				//경사로 설치할 공간 체크
	    				while(map[y][curr]==map[y][x]) {
							//이미 경사로 설치되있으면 설치불가
	    					if(rInstall[y][curr]) break;
	    					cnt++;
	    					curr--;
	    					if(cnt==X) break;
	    					if(curr<0) break;
	    				}
	    				//X만큼의 공간 있으면 설치하고 전진
	    				if(cnt==X) {
	    					continue;
	    				}else {
	    					break;
	    				}//이하 반복
        			}else {
        				curr=x+1;
        				int cnt = 0;
        				
        				while(map[y][curr] == map[y][x+1]) {
        					cnt++;
        					curr++;
        					if(cnt==X)break;
        					if(curr>=N) break;
        				}
        				
        				if(cnt==X) {
        					for(int i=curr-1; i>curr-1-X; i--) {
        						rInstall[y][i] = true;
        					}
        					continue;
        				}else {
        					break;
        				}
        			}
        		}
        	}
        	
        	//세로검사
        	boolean[][] cInstall = new boolean[N][N];
        	for(int x=0; x<N; x++) {
        		int curr = 0;
        		for(int y=0; y<N; y++) {
        			if(y==N-1) {
        				result++;
        				break;
        			}
        			//높이 같으면 통과
        			if(map[y][x]==map[y+1][x])continue;
        			//차의 절대값 1 넘으면 불가능
        			if(Math.abs(map[y][x]-map[y+1][x])>1) break;
        			//높아지면
        			if(map[y+1][x]-map[y][x]>0) {
	    				curr=y;
	    				int cnt = 0;
	    				
	    				while(map[curr][x]==map[y][x]) {
	    					if(cInstall[curr][x]) break;
	    					cnt++;
	    					curr--;
	    					if(cnt==X) break;
	    					if(curr<0) break;
	    				}
	    				
	    				if(cnt==X) {
	    					continue;
	    				}else {
	    					break;
	    				}
        			}else {
        				curr=y+1;
        				int cnt = 0;
        				
        				while(map[curr][x] == map[y+1][x]) {
        					cnt++;
        					curr++;
        					if(cnt==X)break;
        					if(curr>=N) break;
        				}
        				
        				if(cnt==X) {
        					for(int i=curr-1; i>curr-1-X; i--) {
        						cInstall[i][x] = true;
        					}
        					continue;
        				}else {
        					break;
        				}
        			}
        		}
        	}
        	
        	bw.write("#"+tc+" "+result+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
