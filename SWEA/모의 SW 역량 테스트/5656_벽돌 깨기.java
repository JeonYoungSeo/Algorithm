import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N,W,H;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			result = 987654321;
			int[][] brick = new int[H][W];
			
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					brick[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bbreak(brick, 0);
			if(result == 987654321) result = 0;
			System.out.println("#"+tc+" "+result);
			
		}
	}
	static int result;
	private static void bbreak(int[][] brick, int n) {
		if(n==N) {
			int cnt = 0;
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(brick[i][j]!=0) {
						cnt++;
					}
				}
			}
			
			result = Math.min(result, cnt);
			return;
		}
		//첫번째부터 마지막 칸까지 한번씩 내려보기
		for(int x=0; x<W; x++) {
			for(int y=0; y<H; y++) {
				if(brick[y][x]==0) continue;
				//벽돌 부수기
				int[][] tbrick = pop(brick,y,x);
				//벽돌 내리기
				tbrick = downing(tbrick);
				//다음 회차
				bbreak(tbrick, n+1);
				break;
			}
		}
	}

	private static int[][] downing(int[][] tbrick) {
		for(int y=H-2; y>=0; y--) {
			for(int x=0; x<W; x++) {
				if(tbrick[y][x]!=0 && tbrick[y+1][x]==0) {
					int ty = y+1;
					
					while(ty<H && tbrick[ty][x]==0) ty++; 
					
					tbrick[ty-1][x] = tbrick[y][x];
					tbrick[y][x] = 0;
				}
			}
		}
		
		return tbrick;
	}

	private static int[][] pop(int[][] brick, int y, int x) {
		if(brick[y][x]==0) return brick;
		
		int[][] result = new int[H][W];
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				result[i][j] = brick[i][j];
			}
		}
		
		int range = brick[y][x]-1;
		
		result[y][x] = 0;
		
		for(int i=1; i<=range; i++) {
			if(y+i<H)
				result = pop(result,y+i,x);
			if(x+i<W)
				result = pop(result,y,x+i);
			if(y-i>=0)
				result = pop(result,y-i,x);
			if(x-i>=0)
				result = pop(result,y,x-i);
		}
		
		return result;
	}
}
