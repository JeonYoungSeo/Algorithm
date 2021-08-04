import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			String str = br.readLine();
			
			if(str.charAt(0) == '.') break;
			
			List<Character> lst = new ArrayList<Character>();
			//필요한 문자만 추출
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i)=='(') lst.add('(');
				else if(str.charAt(i)==')') lst.add(')');
				else if(str.charAt(i)=='[') lst.add('[');
				else if(str.charAt(i)==']') lst.add(']');
			}
			
			for(int i=0; i<lst.size()-1; i++) {
				if((lst.get(i)=='(' && lst.get(i+1)== ')') ||( lst.get(i)=='[' && lst.get(i+1)== ']')) {
					lst.remove(i);
					lst.remove(i);
					i -= 2;
					if(i<0) i=-1;
				}
			}
			
			if(lst.size()==0) {
				bw.write("yes\n");
			}else {
				bw.write("no\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
