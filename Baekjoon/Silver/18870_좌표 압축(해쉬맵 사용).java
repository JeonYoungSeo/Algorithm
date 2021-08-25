import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int[] arr = new int[N];
		int[] arr2 = new int[N];
		for(int i=0; i<N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			arr[i] = temp;
			arr2[i] = temp;
			map.put(temp, 0);
		}
		Arrays.sort(arr);
		int big = 0;
		for(int i=0; i<arr.length; i++) {
			if(i+1<arr.length && arr[i]==arr[i+1]) continue;
			int temp = arr[i];
			map.put(temp, big++);
			
		}
		
		for(int i=0; i<N; i++) {
			bw.write(map.get(arr2[i])+" ");
		}
        
        bw.flush();
	}
}
