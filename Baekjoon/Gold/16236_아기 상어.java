import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-25
 * Description : 백준 16236
 */

public class Main{
	static Shark shark;
	static short[][] arr;
	static int N;
  
  //상어 객체
	public static class Shark{
		short y,x,size,eat;
		
		Shark(short y,short x){
			this.y = y;
			this.x = x;
			size = 2;
			eat = 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//공간의 크기
		N = Short.parseShort(br.readLine());
		//공간 생성
		arr = new short[N][N];
		//입력
		for(short i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(short j=0; j<N; j++) {
				arr[i][j] = Short.parseShort(st.nextToken());
        //9인곳에 상어 배치
				if(arr[i][j] == 9) {
					shark = new Shark(i,j);
					arr[i][j] = 0;
				}
			}
		}
    //출력값
		int result = 0;
    
		while(true){
			//먹을수 있는게 잇는지 검사
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(arr[i][j]!=0 && arr[i][j] < shark.size) cnt++; 
				}
			}
      //더이상 먹을수 없으면 멈춘다.
			if(cnt==0) break;
			
			//최단거리 먹이의 y,x,거리 구함
			short[] dis = measure(shark.y, shark.x);
			//먹이가 있지만 먹을수 있는게 없을경우 탈출.
			if(dis[2] == -1) break;
      //먹을 수 있으면 상어의 위치 갱신하고 
			shark.y = dis[0];
			shark.x = dis[1];
			result += dis[2];
			//상어의 위치 0으로 만들고 먹은수 ++
			arr[shark.y][shark.x] = 0;
			shark.eat++;
			//먹은수 == 상어의 사이즈면 사이즈 업하고 먹은거 리셋
			if(shark.eat == shark.size) {
				shark.size++;
				shark.eat=0;
			}
		}
		//결과 출력
		System.out.println(result);
	}
  //사방탐색을 위한 배열
	static short[] my = {1,0,-1,0};
	static short[] mx = {0,1,0,-1};
	//최단 위치,거리 구하기 위한 함수
	private static short[] measure(short y, short x) {
		//bfs위한 큐 생성
		Queue<short[]> queue = new LinkedList<short[]>();	
		//처음 위치 추가
		queue.add(new short[] {y,x});
		//방문 배열 생성
		boolean[][] visited = new boolean[N][N];
		//최대 거리로 초기화
		short result_y=21 ,result_x=21;
		//비지 않을때까지 반복 level(거리)확인 해야함
    //거리와 최소거리 찾았는지 판별 변수
		short dis = -1;
		boolean found = false;
    //큐가 빌때까지 진행
		while(!queue.isEmpty()) {
      //거리 증가
			dis++;
			int size = queue.size();
      //거리 단위로 테스트 하기 위함
			while(size!=0) {
        //큐에서 하나 뽑아옴
				short[] temp =  queue.poll();
				size--;
				y = temp[0];
				x = temp[1];
				//방문표시
				visited[y][x] = true;
				//0이 아니고 상어 사이즈보다 작아야지 먹을수 있음.
				if(arr[y][x]!=0 && arr[y][x]<shark.size) {
          //가장 위쪽에 있는 먹이
					if(result_y>y) {
						result_y = y;
						result_x = x;
					}else if(result_y == y && result_x>x) { //가장 왼쪽에 있는 먹이
						result_x = x;
					}
          //찾았으면 탈출 위해 ture로 만듬(더이상 검사 필요 x)
					found = true;
				}
				
        //사방 탐색
				for(short i=0; i<4; i++) {
					short temp_y = (short) (y+my[i]);
					short temp_x = (short) (x+mx[i]);
					//범위 안에 있고 방문하지 않아야 하고, 상어보다 같거나 작아야지 지나갈수있으므로 조건에 맞으면 큐에 추가
					if(temp_y>=0 && temp_x>=0 && temp_y<N && temp_x<N && !visited[temp_y][temp_x] && arr[temp_y][temp_x]<=shark.size) {
						queue.add(new short[] {temp_y, temp_x});
            //이미 큐에 넣은것 두번 이상 안넣게 방문 처리
						visited[temp_y][temp_x] = true;
					}
				}
			}
      //찾았으면 해당 결과 리턴
			if(found) return new short[] {result_y,result_x,dis};
		}
		//여기까지 왓다는것은 갈수있는곳이 없다는 것.
		return new short[] {-1,-1,-1};
	}
}
