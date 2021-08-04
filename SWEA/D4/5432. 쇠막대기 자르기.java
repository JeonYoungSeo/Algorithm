import java.util.*;

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
            int result = 0;
            int count = 0;
            
            String temp = sc.nextLine();
            List<Character> line = new ArrayList<Character>();
            for(int i=0; i<temp.length(); i++) {
            	line.add(temp.charAt(i));
            }
            
            for(int i=0; i<line.size(); i++){
                if(line.get(i) == '(' && i+1<line.size() && line.get(i+1)==')'){
                    result +=count;
                    i++;
                    continue;
                }
                
                if(line.get(i) == '('){
                    count ++;
                    result ++;
                }
                if(line.get(i) == ')') {
                    count--;
                }
            }
            System.out.println("#"+test_case+" "+result);
		}
		sc.close();
	}
}
