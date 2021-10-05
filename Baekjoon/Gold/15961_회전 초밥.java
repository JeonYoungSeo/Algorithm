import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] in = new int[d+1];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        int[] window = new int[k];
        int cnt = 0;

        for(int i=0; i<k-1; i++){
            window[i] = arr[i];

            if(in[arr[i]]==0){
                cnt++;
                in[arr[i]]++;
            }else{
                in[arr[i]]++;
            }
        }

        for(int i=k-1; i<N+k; i++) {
            in[window[i%k]]--;
            if(in[window[i%k]]==0){
                cnt--;
            }
            window[i%k] = arr[i%N];

            if(in[window[i%k]]==0) {
                in[window[i % k]]++;
                cnt++;
            }else{
                in[window[i%k]]++;
            }

            if(in[c]==0){
                result = Math.max(result, cnt+1);
            }else{
                result = Math.max(result, cnt);
            }

            if(result==k+1) break;
        }


        System.out.println(result);
    }
}
