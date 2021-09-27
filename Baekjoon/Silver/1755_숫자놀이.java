import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-24
 * Description : 백준
 */


public class Main{
	//컴페어러블을 이용+영어와 숫자를 저장하는 Word 객체
	public static class Word implements Comparable<Word>{
		int num;
		String str;
		
		Word(String str, int num){
			this.num = num;
			this.str = str;
		}
    //str 순서대로 정렬
		@Override
		public int compareTo(Word o) {
			return this.str.compareTo(o.str);
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st= new StringTokenizer(br.readLine());
        //M,N 입력
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        String[] word = {"zero","one","two","three","four","five","six","seven","eight","nine","ten"};
        ArrayList<Word> list = new ArrayList<Word>();
        
        for(int i=M; i<=N; i++) {
        	StringBuilder sb = new StringBuilder();
        	//접근하기 쉽게 캐릭터 배열화
        	char[] temp = Integer.toString(i).toCharArray();
        	//맞는 영단어 추가
        	for(int j=0; j<temp.length; j++) {
        		sb.append(word[temp[j]-'0']+" ");
        	}
        	//리스트에 원본 숫자와 함께 추가
        	list.add(new Word(sb.toString(),i));
        }
        //정렬
        Collections.sort(list);
        //10개씩 출력
        int n = 0;
        for(Word word : list) {
        	bw.write(word.num+" ");
        	n++;
        	if(n%10==0) bw.newLine();
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
