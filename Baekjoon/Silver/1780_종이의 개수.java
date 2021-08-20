import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[][] paper;
	static int[] result = new int[3];
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        paper = new int[N][N];
        
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0; j<N; j++) {
        		paper[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        scissors(0,0,N,N);
                
        for(int n : result) {
        	System.out.println(n);
        }
    }
    
    private static void scissors(int sx,int sy, int ex, int ey) {
    	//-1,0,1 체크 전부다 -1,0,1인지 확인하기 위한 변수
    	boolean check[] = new boolean[3];
    	for(int i=0; i<3; i++) {
    		check[i] = true;
    	}
    	for(int i=sy; i<ey; i++) {
    		for(int j=sx; j<ex; j++) {
    			if(paper[i][j] != 1) {
    				//1이 아니면 전부 1이 아닌것으로
    				check[2] = false;
    			}
    			if(paper[i][j] != 0) {
    				//0이 아니면 전부 0이 아닌것으로
    				check[1] = false;
    			}
    			if(paper[i][j] != -1) {
    				//-1이 아니면 전부 -1이 아닌것으로
    				check[0] = false;
    			}
    		}
    	}
    	//true의 갯수 카운트
    	int count = 0;
    	for(int i=0; i<3; i++) {
    		if(check[i]) count ++;
    	}
    	int size = (ex-sx)/3;
    	
    	
    	if(count != 1) {
    		//한가지 숫자만 있는게 아니면 재귀 실행
    		scissors(sx,sy,sx+size,sy+size);
    		scissors(sx+size,sy,sx+2*size,sy+size);
    		scissors(sx+2*size,sy,sx+3*size,sy+size);
    		
    		scissors(sx,sy+size,sx+size,sy+2*size);
    		scissors(sx+size,sy+size,sx+2*size,sy+2*size);
    		scissors(sx+2*size,sy+size,sx+3*size,sy+2*size);
    		
    		scissors(sx,sy+2*size,sx+size,sy+3*size);
    		scissors(sx+size,sy+2*size,sx+2*size,sy+3*size);
    		scissors(sx+2*size,sy+2*size,sx+3*size,sy+3*size);
    	}else {
    		for(int i=0; i<3; i++) {
    			if(check[i]) result[i]++;
    		}
    	}
    	
    	
    }
}
