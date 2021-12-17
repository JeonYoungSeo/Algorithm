import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] cnt = new int[4];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<4; i++){
            cnt[i] = Integer.parseInt(st.nextToken());
        }

        cal_minmax(arr[0],1, arr,cnt);

        System.out.println(max);
        System.out.println(min);

    }

    private static void cal_minmax(int result, int num, int[] arr, int[] cnt) {

        if(num == N){
            max = Math.max(max, result);
            min = Math.min(min, result);

            return;
        }

        for(int i=0; i<4; i++){
            if(cnt[i]!=0){
                cnt[i]--;
                switch (i){
                    case 0 :
                        cal_minmax(result+arr[num], num+1, arr, cnt);
                        break;
                    case 1:
                        cal_minmax(result-arr[num], num+1, arr, cnt);
                        break;
                    case 2:
                        cal_minmax(result*arr[num], num+1, arr, cnt);
                        break;
                    case 3:
                        cal_minmax(result/arr[num], num+1, arr, cnt);
                        break;
                }
                cnt[i]++;
            }
        }

    }
}
