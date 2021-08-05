import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int n = Integer.parseInt(br.readLine());
			List<Character> lst = new ArrayList<Character>();
            
            String str = br.readLine();
            for(int i=0; i<n; i++){
                lst.add(str.charAt(i));
            }
            
            for(int i=0; i<lst.size()-1; i++){
                if((lst.get(i)=='(' && lst.get(i+1) == ')') || (lst.get(i)=='[' && lst.get(i+1) == ']') || (lst.get(i)=='{' && lst.get(i+1) == '}') || (lst.get(i)=='<' && lst.get(i+1) == '>')){
                    lst.remove(i);
                    lst.remove(i);
                    i -=2;
                    if(i<-1) i = -1;
                }
            }
            
            bw.write("#"+test_case+" ");
            if(lst.size() == 0) bw.write("1");
            else bw.write("0");
            bw.newLine();
		}
        bw.flush();
        bw.close();
        br.close();
	}
}
