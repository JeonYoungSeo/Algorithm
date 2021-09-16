import java.util.Scanner;
//플로이드-와샬 기법 이용
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		sc.nextLine();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();	
            int[][] arr = new int[N][N];
            
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    arr[i][j] = sc.nextInt();
                    if(arr[i][j]==0) arr[i][j] = 9876543;
                }
            }
            
            for(int k=0; k<N; k++){
                for(int i=0; i<N; i++){
                    if(k==i) continue;
                    for(int j=0; j<N; j++){
                        if(k==j || i==j) continue;
                        arr[i][j] = Math.min(arr[i][k]+arr[k][j], arr[i][j]);
                    }
                }
            }
            
            int result = 987654321;
            
            for(int i=0; i<N; i++){
            	int sum = 0;
                for(int j=0; j<N; j++){
                    if(i==j) continue;
                    sum+=arr[i][j];
                }
                result = Math.min(result, sum);
            }
                    
                    
            System.out.println("#"+test_case+" "+result);
		}	
	}
}
