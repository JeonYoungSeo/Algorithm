import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-29
 * Description : 백준 5525
 */

public class Main{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//ioi의 갯수
		int n = Integer.parseInt(br.readLine());
		StringBuilder io = new StringBuilder();

		//문자열 길이
		int len = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
    //정답
		int count = 0;
    //패턴 반복 횟수
		int chk_count = 0;
		for(int i=0; i<len-1; i++) {
      //IOI패턴인지 확인
			if(str.charAt(i)== 'I' && str.charAt(i+1)=='O' && str.charAt(i+2)== 'I') {
        //맞으면 반복횟수++ n과 일치하면 count++ 한후 다음패턴 확인위해 반복횟수--
				chk_count++;
				if(chk_count == n) {
					chk_count--;
					count++;
				}
				i++;  //O는 검사할 필요가 없음
			}else {//패턴이깨지면 반복횟수 초기화
				chk_count = 0;
			}
		}
		//출력
		bw.write(count+"\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}

