import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
	static int[] gyu, iny;  //규영,인영
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=1; tc<=T; tc++) {
        	boolean[] card = new boolean[19];
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	gyu = new int[9];
        	iny = new int[9];
        	//규영 카드
        	for(int i=0; i<9; i++) {
        		gyu[i] = Integer.parseInt(st.nextToken());
        		card[gyu[i]] = true;
        	}
        	
        	//인영 카드
        	for(int i=0; i<9; i++) {
        		for(int j=1; j<19; j++) {
        			if(card[j] == false) {
        				iny[i] = j;
        				card[j] = true;
        				break;
        			}
        		}
        	}
        	
        	//tc돌아서 초기화
        	win = 0 ;
        	lose =0;
        	g_total=0;
        	i_total=0;
        	game(0,0);  //해당 함수 실행
        	bw.write("#"+tc+" "+win+" "+lose+"\n"); //출력
        }
        bw.flush();
        bw.close();
        br.close();
    }
    
    static int win, lose;
    static int g_total, i_total;
    private static void game(int n, int flag) {
    	
    	//기저 조건
    	if(n == 9) {
    		if(g_total>i_total) {
    			win ++;
    		}else if(g_total<i_total){
    			lose ++;
    		}
    		return ;
    	}
    	
    	for(int i=0; i<9; i++) {
    		if((flag & 1<<i) != 0) continue;
    		if(gyu[n] > iny[i]) {
    			g_total += (gyu[n]+iny[i]); 
    		}else {
    			i_total += (gyu[n]+iny[i]);
    		}
    		game(n+1, flag | 1 << i);
    		if(gyu[n] > iny[i]) {
    			g_total -= (gyu[n]+iny[i]);
    		}else {
    			i_total -= (gyu[n]+iny[i]);
    		}
    	}
    	
    	return;
    }
}
