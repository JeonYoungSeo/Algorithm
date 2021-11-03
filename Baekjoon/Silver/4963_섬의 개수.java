import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int w,h;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w==0 && h==0) {
				break;
			}
			
			int[][] map = new int[h][w];
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = 0;
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j] == 1) {
						result ++;
						count(i,j,map);
					}
				}
			}
			
			System.out.println(result);
		}
		
	}
	static int[] my = {-1,-1,-1,0,0,1,1,1};
	static int[] mx = {-1,0,1,-1,1,-1,0,1};
	private static void count(int i, int j, int[][] map) {
		
		map[i][j] = 0;
		
		for(int k=0; k<8; k++) {
			int ny = i+my[k];
			int nx = j+mx[k];
			
			if(ny<0 || nx<0 || ny>=h || nx>=w) continue;
			
			if(map[ny][nx] == 1) {
				count(ny,nx,map);
			}
		}
		
	}
}
