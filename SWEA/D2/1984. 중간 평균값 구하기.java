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
            int[] lst = new int[10];
            
            for(int i=0; i<10; i++){
                lst[i] = sc.nextInt();
            }
            sc.nextLine();
            
            for(int i=0; i<9; i++){
                for(int j=0; j<9-i; j++){
                    if(lst[j] > lst[j+1]){
                        int temp = lst[j];
                        lst[j] = lst[j+1];
                        lst[j+1] = temp;
                    }
                }
            }
            
            int sum =0;
            for(int i=1; i<9; i++){
                sum+=lst[i];
            }
            if(sum%8 <4) System.out.println("#"+test_case+" "+sum/8);
            else System.out.println("#"+test_case+" "+((sum/8)+1));
		}
	}
}
