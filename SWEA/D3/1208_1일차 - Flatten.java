
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int count = sc.nextInt();
            sc.nextLine();
            int[] lst = new int[100];
            int max = 0;
            int min = 0;
            
            for(int i=0; i<100; i++){
                lst[i] = sc.nextInt();
                if(lst[max]<=lst[i]){
                    max = i;
                }
                if(lst[min]>lst[i]){
                    min = i;
                }
               
            }
            
            while(count>0){
                if(max==min) break;
                lst[max]--;
                lst[min]++;
                for(int i=0; i<100; i++){
                    if(lst[max]<=lst[i]) max = i;
                    if(lst[min]>=lst[i]) min = i;
                }
                count--;
            }
            System.out.printf("#%d %d%n", test_case, lst[max]-lst[min]);
        }
	}
}
