import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-26
 * Description : 백준 2579
 */

public class Main{
  //점수 배열, 계단 갯수, 메모이제이션 배열
	static int[] score;
	static int N;
	static int[] memo;
	public static void main(String[] args) throws IOException
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//계단갯수와 점수 입력
		N = Integer.parseInt(br.readLine());
		score = new int[N+1];
		for(int i=1; i<=N; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
    //메모이제이션 배열 생성
		memo = new int[N+1];
    //함수 실행
		int result = upstair(N);
		
		System.out.println(result);
	}
	
	private static int upstair(int curr) {
    //이미 계산햇다면 계산결과 출력
		if(memo[curr]!=0) return memo[curr];
		
		int result = 0;
    //3보다 같거나 크면 2칸 전 혹은 점프하고 한칸 뛰어온 애중 큰애를저장
		if(curr>=3) {
			result = Math.max(upstair(curr-2)+score[curr], upstair(curr-3)+score[curr-1]+score[curr]);
		}else {
      //3보다 작으면 합을 구하면 최댓값이 된다.
			for(int i=0; i<=curr; i++) {
				result += score[i];
			}
		}
    //저장안되있으면 저장.
		if(memo[curr] == 0) memo[curr]=result; 
		return memo[curr];
	}
	
}

