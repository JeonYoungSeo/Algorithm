import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-29
 * Description : 백준 15904
 */

public class Main{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		//UCPC가 순서대로 '존재하는지'만 보면 된다.
		char[] result = {'U','C','P','C'};
		int chk = 0;
		
		for(int i=0; i<str.length(); i++) {
			
			if(result[chk]==str.charAt(i)) {
				chk++;
			}
			if(chk==4){
				System.out.println("I love UCPC");
				return;
			}
		}
		System.out.println("I hate UCPC");
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
