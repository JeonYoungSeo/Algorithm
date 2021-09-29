import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.mapays;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-29
 * Description : 백준 3109
 */


public class Main{
	static boolean[][] visited;
	static char[][] map;
	static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        //세로 가로 입력
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	//맵과 방문 배열 생성 -이제보니 방문배열없이 x로 바꿔줘도 될것같다.
    	map = new char[N][M];
    	visited = new boolean[N][M];
    	for(int i=0; i<N; i++) {
    		String str = br.readLine();
    		for(int j=0; j<M; j++) {
    			map[i][j] = str.charAt(j);
    		}
    	}
    	int result = 0;
      //첫번째지점마다 출발
    	for(int i=0; i<N; i++) {
    		result += pipe(i,0);
    	}
    	
    	bw.write(result+"\n");
        bw.flush();
        bw.close();
        br.close();	
    }
    //움직일 곳
    static int[] move = {-1,0,1};
	private static int pipe(int y,int x) {
		//도착할수 있으면 1 반환
		if(x==M-1) return 1;
		
		int result = 0;
    //위 중간 아래 탐색
		for(int i=0; i<3; i++) {
			int ny = y+move[i];
			int nx = x+1;
			
			if(ny<0 || ny>=N || visited[ny][nx]) continue;
			if(map[ny][nx] == 'x') continue;
			visited[ny][nx] = true;
			result = pipe(ny,nx);
      //이미 찾앗으면 탐색을 멈춤
			if(result==1) return 1;
		}
		return result;
	}
    
}
