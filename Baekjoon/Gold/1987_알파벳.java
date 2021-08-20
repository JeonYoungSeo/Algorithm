import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static char[][] board;
	static int result = 1;
	static int R,C;
	static boolean[] alpha = new boolean[26];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		alpha[board[0][0]-'A'] = true;
		horse(0,0,1);
		
		bw.write(result+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
	static int[] move_y = {-1,0,1,0};
	static int[] move_x = {0,1,0,-1};
	
	public static void horse(int y, int x, int count) {
		result = (count>result)?count:result;
	out : for(int i=0; i<4; i++) {
			int temp_y = y+move_y[i];
			int temp_x = x+move_x[i];
			if(temp_y<0 || temp_x<0 || temp_y>=R || temp_x>=C) {
				continue;
			}
			if(alpha[board[temp_y][temp_x]-'A']==true)
				continue out;
			alpha[board[temp_y][temp_x]-'A'] = true;
			horse(temp_y,temp_x,count+1);
			alpha[board[temp_y][temp_x]-'A'] = false;
		}
		
		
	}
}
