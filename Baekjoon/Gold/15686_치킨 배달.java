import java.util.*;
import java.io.*;

public class Main2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] street = new int[N+1][N+1];
		int[][] house = new int[2*N][2];
		int[][] chiken = new int[13][2];
		int house_n = 0;
		int chiken_n = 0;
		
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				street[i][j] = Integer.parseInt(st.nextToken());
				if(street[i][j] == 1) {
					house[house_n][0] = i;
					house[house_n++][1] = j;
				}else if(street[i][j] == 2){
					chiken[chiken_n][0] = i;
					chiken[chiken_n++][1] = j;
				}
			}
		}
		
		int min_dis = Integer.MAX_VALUE;
		for(int num=1; num<(1<<chiken_n); num++) {
			int count = 0;
			for(int i=0; i<chiken_n; i++) 
				if((num & 1<<i) != 0) count++;
			
			if(count != M) continue;
			
			//도시의 치킨 거리
			int sum = 0;
			//한집당 치킨 거리 구하기
			for(int i=0; i<house_n; i++) {
				int min = Integer.MAX_VALUE;
				for(int j=0; j<chiken_n; j++) { 
					if((num & 1<<j) == 0) continue; //고른 치킨집인지 ?
					int dis = Math.abs(chiken[j][0]-house[i][0])+Math.abs(chiken[j][1]-house[i][1]);
					min = (min > dis)? dis : min;
				}
				sum += min;
			}
			min_dis = (sum<min_dis)?sum:min_dis;
		}
		
		bw.write(min_dis+" ");
		
		bw.flush();
		bw.close();
		br.close();
	}
}


