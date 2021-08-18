import java.util.Scanner;

public class Main {
	static int[][] video;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.nextLine();
		video = new int[N][N];
		
		
		for(int i=0; i<N; i++) {
			String str = sc.nextLine();
			for(int j=0; j<N; j++) {
				video[i][j] = str.charAt(j)-48;
			}
		}
		quadTree(0,0,N,N);
		sc.close();
	}
	
	public static void quadTree(int s_y,int s_x,int e_y,int e_x) {
		
		
		boolean check_zero = true;
		boolean check_one = true;
		
		for(int y = s_y; y<e_y; y++) {
			for(int x = s_x; x<e_x; x++) {
				if(video[y][x] == 1) {
					check_zero = false;
				}else {
					check_one = false;
				}
				
				if(!check_zero && !check_one) break; 
			}
		}
		
		
		int m_y = (s_y+e_y)/2;
		int m_x = (s_x+e_x)/2;
		if(!check_zero && !check_one) {
			System.out.printf("(");
			quadTree(s_y,s_x,m_y,m_x);
			quadTree(s_y,m_x,m_y,e_x);
			quadTree(m_y,s_x,e_y,m_x);
			quadTree(m_y,m_x,e_y,e_x);
			System.out.printf(")");
			return;
		}else if(check_zero) {
			System.out.print("0");
			return;
		}else if(check_one) {
			System.out.print("1");
			return;
		}
		
	}
}
