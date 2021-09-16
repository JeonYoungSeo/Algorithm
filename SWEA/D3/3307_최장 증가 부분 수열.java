import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            sc.nextLine();
            
            int[] arr = new int[N];
            
            for(int i=0; i<N; i++){
             	arr[i] = sc.nextInt();   
            }
            sc.nextLine();
            
            int LIS[] = new int[N];
            
            int max = 0 ;
            for(int i=0; i<N; i++){
                LIS[i] = 1;
                for(int j=0; j<i; j++){
             		if(arr[j] < arr[i] && LIS[i] < LIS[j]+1)
                        LIS[i] = LIS[j]+1;
                }
                max = Math.max(LIS[i], max);
            }
            System.out.println("#"+test_case+" "+max);
		}
	}
}
