import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num%2!=0){
                answer++;
                num--;
            }
            arr[i] = num;
        }

        while(true){
            boolean all_zero = true;
            boolean all_even = true;

            for(int i=0; i<N; i++){
                if(arr[i]!=0 && arr[i]%2!=0){
                    arr[i]--;
                    answer++;
                    all_even = false;
                }
                if(arr[i]!=0){
                    all_zero = false;
                }
            }

            if(all_zero) break;

            if(all_even){
                for(int i=0; i<N; i++){
                    arr[i] /=2;

                }
                answer++;
            }



        }

        System.out.println(answer);

    }
}
