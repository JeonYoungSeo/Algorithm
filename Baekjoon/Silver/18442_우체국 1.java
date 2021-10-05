import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//마을의 갯수, 경찰서 갯수, 원형의 거리
		int V = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		long L = Long.parseLong(st.nextToken());
		//마을 위치 배열
		long[] vil = new long[V];
		
		//마을의 위치 입력
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<V; i++) {
			vil[i] = Long.parseLong(st.nextToken());
		}
		
		long result = 1<<V;  //출력을 위한 변수
		long min = Long.MAX_VALUE; //최소거리 구하기 위한 변수
		for(long v=1; v<=(1<<V)+1; v++) {
			int cnt = 0; //선택된 경찰서의 개수
			for(int i=0; i<V; i++) {
				if((v&(1<<i))!=0) {
					cnt++;
				}
				if(cnt>P) break;
			}
			//경찰서가 P개가 아니면 다음으로
			if(cnt!=P) continue;
			
			long totalDis = 0;
			//각각 마을에서 파출소까지의 최소거리
			for(int i=0; i<V; i++) {
				if((v&(1<<i))!=0) continue; //마을에 경찰서 있는경우 넘어간다.
				long dis = Long.MAX_VALUE; 
				for(int p=0; p<V; p++) { //파출소 찾음
					if((v&(1<<p))!=0) {
						long A = vil[i];  //마을의 위치
						long B = vil[p];  //파출소의 위치
						long dif = (long)Math.abs(A-B); //사이의 거리
						dis =(long)Math.min(dis, (long)Math.min(dif,L-dif)); //현재 최소거리와 마을,경찰서 최소거리 중 최소 저장
					}
				}
				totalDis += dis; //전체 거리에 최소거리 더해줌
			}
			
			if(totalDis<min) { //최소거리 갱신되면
				min = totalDis; //갱신
				result = v; // 마을정보 저장
			}
			
		}
		//출력
		bw.write(min+"\n"); 
		//마을 위치 출력
		for(int i=0; i<V; i++) {
			if((result&(1<<i))!=0) {
				bw.write(vil[i]+" ");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
}
