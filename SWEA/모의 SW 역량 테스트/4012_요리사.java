import java.util.Scanner;

public class Solution{
		public static void main(String args[]) throws Exception
		{
			Scanner sc = new Scanner(System.in);
			int T;
			T=sc.nextInt();
			sc.nextLine();
			for(int test_case = 1; test_case <= T; test_case++)
			{
				int N = sc.nextInt();
				sc.nextLine();
				
				//음식 배열
				short[][] food = new short[N][N];
				//음식 입력
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						food[i][j] = sc.nextShort();
					}
					sc.nextLine();
				}
				
				int num = N/2;
				int min_sub = Integer.MAX_VALUE;
			out : for(int i=1; i<(1<<N); i++) {
					int count = 0;
					int[] foodA = new int[num];
					int[] foodB = new int[num];
					int foodA_n =0 ;
					int foodB_n =0 ;
					
					for(int j=0; j<N; j++) {
						if((i & 1<<j) != 0) {
							if(foodA_n >= num) continue out;
							foodA[foodA_n++] = j;
							count ++;
						}else {
							if(foodB_n>=num) continue out; 
							foodB[foodB_n++] = j;
						}
						
					}
					if(count!=num) continue;
					
					int sumA = 0;
					int sumB = 0 ;
					
					for(int j=0; j<num-1; j++) {
						for(int k=j+1; k<num; k++) {
							sumA += (food[foodA[j]][foodA[k]]+food[foodA[k]][foodA[j]]);
							sumB += (food[foodB[j]][foodB[k]]+food[foodB[k]][foodB[j]]);
						}
					}
					int sub = Math.abs(sumA-sumB);
					min_sub = (min_sub>sub)?sub: min_sub;
				}
				System.out.println("#"+test_case+" "+min_sub);
				
			}
			sc.close();
		}
	}
