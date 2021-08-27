import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{

	public static void main(String[] args) throws IOException
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); //N입력
		int[] arr = new int[234]; //결과값 저장을 위한 함수
		//그때그때 구해주면 반복된 연산으로 인해 시간이 걸리므로 미리 구해서 저장
		for(int i=1; i<234; i++) {
			arr[i] = (int)Math.pow(i, 2);
		}
		//제곱수의 갯수
		int count = 0;
		//제곱수들의 합이 N이 되면 가장 바깥 for문을 탈출한다.
	out :for(int i=0; i<234; i++) {
			for(int j=0; j<234; j++) {
				for(int k=0; k<234; k++) {
					for(int l=0; l<234; l++) {
						if((arr[i]+arr[j]+arr[k]+arr[l])==N) {
							if(i!=0) count++;
							if(j!=0) count++;
							if(k!=0) count++;
							if(l!=0) count++;
							break out;
						}
					}
				}
			}
		}
		//출력
		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();
		br.close();
			
	}
}

