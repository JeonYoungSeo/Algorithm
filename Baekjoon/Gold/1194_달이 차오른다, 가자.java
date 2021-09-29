import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  //사람의 위치와 열쇠현황을 저장할 객체
	public static class Person{
		int y,x,key; 

    Person(int y, int x,int key) {
			this.y = y;
			this.x = x;
			this.key = key;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//세로 가로
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		//맵,방문 배열,큐 생성
		char[][] map = new char[N][M];
    //비트마스킹으로 키 습득 종류에따라 방문배열을 달리 한다.
		boolean[][][] visited = new boolean[1<<7][N][M];
		Queue<Person> que = new LinkedList<Person>();
		//맵 정보 입력
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j);
				//시작위치 설정
				if(map[i][j]=='0') {
					map[i][j]='.';
					que.add(new Person(i,j,0));
					visited[0][i][j] = true;
				}
			}
		}
		//사방 탐색
		int[] move_y = {1,-1,0,0};
		int[] move_x = {0,0,-1,1};
    //이동횟수
		int count = 0;
		while(!que.isEmpty()) {
			
			int num = que.size();
			while(num-->0) {
				Person person = que.poll();
				
				if(map[person.y][person.x]=='1') {
					System.out.println(count);
					return;
				}
				
				for(int i=0; i<4; i++) {
					int new_y = person.y + move_y[i];
					int new_x = person.x + move_x[i];
					//범위 벗어남
					if(new_y<0 || new_y>=N || new_x<0 || new_x>=M) continue;
          //벽
					if(map[new_y][new_x]=='#') continue;
          //빈공강이거나 탈출구면 그냥 진행
					if((map[new_y][new_x]=='.' || map[new_y][new_x]=='1') && !visited[person.key][new_y][new_x]) {
						que.add(new Person(new_y,new_x,person.key));
						visited[person.key][new_y][new_x] = true;
						continue;
					}
					//열쇠면 습득표시를 하고 진행
					if(map[new_y][new_x]>=97 && !visited[person.key][new_y][new_x]) {
						int nk = person.key | (1<<map[new_y][new_x]-'a');
						
						visited[nk][new_y][new_x] = true;
						que.add(new Person(new_y,new_x,nk));
						continue;
					}
					//벽일 경우 열쇠의 존재 유무확인후 진행
					if(map[new_y][new_x]>=65 && map[new_y][new_x]<71 && !visited[person.key][new_y][new_x]) {
						if((person.key & (1<<(map[new_y][new_x]-'A')))!=0) {
							que.add(new Person(new_y,new_x,person.key));
							visited[person.key][new_y][new_x] = true;
							continue;
						}
						continue;
					}
				}
			}
			count++;
		}
		System.out.println("-1");
	}
}
