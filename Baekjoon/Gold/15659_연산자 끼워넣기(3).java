import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
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

        Stack<Integer> result = new Stack<>();
        result.add(arr[0]);

        cal_minmax(result,1, arr,cnt);

        System.out.println(max);
        System.out.println(min);

    }

    private static void cal_minmax(Stack<Integer> result, int num, int[] arr, int[] cnt) {

        if(num == N){
            int comp = 0;
            for(int val : result){
                comp += val;
            }
            max = Math.max(max, comp);
            min = Math.min(min, comp);

            return;
        }

        for(int i=0; i<4; i++){
            if(cnt[i]!=0){
                cnt[i]--;
                int temp = 0;
                switch (i){
                    case 0 :
                        result.add(arr[num]);
                        cal_minmax(result, num+1, arr, cnt);
                        result.pop();
                        break;
                    case 1:
                        result.add(-arr[num]);
                        cal_minmax(result, num+1, arr, cnt);
                        result.pop();
                        break;
                    case 2:
                        temp = result.pop();
                        result.add(temp*arr[num]);
                        cal_minmax(result, num+1, arr, cnt);
                        result.pop();
                        result.add(temp);
                        break;
                    case 3:
                        temp = result.pop();
                        result.add(temp/arr[num]);
                        cal_minmax(result, num+1, arr, cnt);
                        result.pop();
                        result.add(temp);
                        break;
                }
                cnt[i]++;
            }
        }

    }
}
