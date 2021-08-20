import java.util.Scanner;

public class Main {
	static int[][] video;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//배열 크기 입력
		int N = sc.nextInt();
		sc.nextLine();
		//배열 생성
		video = new int[N][N];
		
		//배열 입력
		for(int i=0; i<N; i++) {
			String str = sc.nextLine();
			for(int j=0; j<N; j++) {
				video[i][j] = str.charAt(j)-48;
			}
		}
		//함수 실행
		quadTree(0,0,N,N);
		sc.close();
	}
	
	public static void quadTree(int s_y,int s_x,int e_y,int e_x) {
		//들어온 board에 0과 1이 섞여있는지 판별하기 위한 변수		
		boolean check_zero = true; //0만 있는지
		boolean check_one = true; //1만 있는지
		
		for(int y = s_y; y<e_y; y++) {
			for(int x = s_x; x<e_x; x++) {
				//1이있으면 check_zero false
				if(video[y][x] == 1) {
					check_zero = false;
				}
				//0이 있으면 check_one false
				else {
					check_one = false;
				}
				//둘다 false가 되었다는 것은 0,1 모두 있다는것이므로 더이상 검사할 필요 없음
				if(!check_zero && !check_one) break; 
			}
		}
		
		//중간 y,x값
		int m_y = (s_y+e_y)/2;
		int m_x = (s_x+e_x)/2;
		//0,1 모두 존재 할 경우
		if(!check_zero && !check_one) {
			//1,2,3,4분면 분할 정복 및 시작과 끝에 ( , ) 출력
			System.out.printf("(");
			quadTree(s_y,s_x,m_y,m_x);
			quadTree(s_y,m_x,m_y,e_x);
			quadTree(m_y,s_x,e_y,m_x);
			quadTree(m_y,m_x,e_y,e_x);
			System.out.printf(")");
			return;
		//이렇게 할 경우 기저조건이 필요 없음 : 크기가 1일경우는 모두1 or 모두0 이기때문에 재귀로 들어가지 않는다.
		}else if(check_zero) {
			//0만 있으면 0 출력
			System.out.print("0");
			return;
		}else if(check_one) {
			//1만 있으면 1 출력
			System.out.print("1");
			return;
		}
		
	}
}
