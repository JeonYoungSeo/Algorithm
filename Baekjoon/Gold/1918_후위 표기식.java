import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-24
 * Description : 백준 1918
 */

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//문자열 입력
		String str = br.readLine();
		//출력을 위한 리스트와 연산자를 임시저장할 배열(스택)
		List<Character> lst = new ArrayList<Character>();
		List<Character> lst_temp = new ArrayList<Character>();
    //현재 괄호의 갯수
		int count = 0;
		for(int i=0; i<str.length(); i++) {
      //숫자면 바로 입력
			if(str.charAt(i)>=65) {
				lst.add(str.charAt(i));
			}else {
         //숫자가 아니고 +,-,) 일때 비거나 (를 만날때까지 출력리스트로 옮긴다.
				  if((str.charAt(i)=='+' || str.charAt(i)=='-' || str.charAt(i)==')')) {
				  	while(!lst_temp.isEmpty() && (lst_temp.get(lst_temp.size()-1)!='(')) {
				  		lst.add(lst_temp.get(lst_temp.size()-1));
				  		lst_temp.remove(lst_temp.size()-1);
					}
          // (까지 출력했는데 괄호가 끝난 경우 괄호를 만나기전에 있던 것들을 출력
					if(!lst_temp.isEmpty() && str.charAt(i)==')') {
						if(lst_temp.get(lst_temp.size()-1)=='(') {
							lst_temp.remove(lst_temp.size()-1);
							count--;
							if(count==0) {
								while(!lst_temp.isEmpty() && (lst_temp.get(lst_temp.size()-1)=='+' && lst_temp.get(lst_temp.size()-1) == '-')) {
									lst.add(lst_temp.get(lst_temp.size()-1));
									lst_temp.remove(lst_temp.size()-1);
								}
							}
						}
					}
          //현재 문자 임시 리스트에 삽입
					lst_temp.add(str.charAt(i));
          //)면 다시 제외					
					if(lst_temp.get(lst_temp.size()-1)==')') lst_temp.remove(lst_temp.size()-1);
				}else{//+,-,)가 아닌경우
					lst_temp.add(str.charAt(i));
            //(면 괄호의 갯수 1 증가
					if(lst_temp.get(lst_temp.size()-1)=='(') count++;
					//연속으로 *,/가 나오면 앞에거를 출력리스트로 옮겨준다.
					if(lst_temp.size()>=2 && (lst_temp.get(lst_temp.size()-2)=='*' || lst_temp.get(lst_temp.size()-2)=='/')){
						if(lst_temp.get(lst_temp.size()-1)=='*' || lst_temp.get(lst_temp.size()-1)=='/'){
							lst.add(lst_temp.get(lst_temp.size()-2));
							lst_temp.remove(lst_temp.size()-2);
						}
					}
				}
			}
		}
    //다하고 남은것들 출력리스트로 옮겨준다.
		while(!lst_temp.isEmpty()) {
			lst.add(lst_temp.get(lst_temp.size()-1));
			lst_temp.remove(lst_temp.size()-1);
		}
    //출력
		for(char c : lst) {
			System.out.print(c);
		}
		
	}
}
