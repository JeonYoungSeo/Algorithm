import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr, cnt, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N]; // 각 숫자 입력
        result = new int[N*2];
        cnt = new int[N]; //2번씩 들어가야 한다.
        Arrays.fill(cnt,2);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        if(!permu(0)){
            System.out.println(-1);
        }

    }

    private static boolean permu(int n) {
        if(n == N*2){
            for(int i=0; i<N*2; i++){
                System.out.print(result[i]+" ");
            }
            System.out.println();
            return true;
        }

        boolean answer = false;

        for(int i=0; i<N; i++){
            if(cnt[i] != 0){
                cnt[i]--;
                result[n] = arr[i];
                if(cnt[i] == 0) {
                    if (n - arr[i] - 1 < 0 || result[n] != result[n - arr[i] - 1]) {
                        cnt[i]++;
                        continue;
                    }
                }
                answer = permu(n+1);
                if(answer){
                    return true;
                }
                cnt[i]++;
            }
        }
        return answer;

    }
}
