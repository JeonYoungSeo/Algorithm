import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int memo[] = new int[1000001];
        Arrays.fill(memo, -1);
        memo[0] = 1;

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int result = 0;

            for(int i=N; i<=M; i++){
                if(memo[i] != -1){
                    result += memo[i];
                    continue;
                }

                int num = i;

                int cnt = 0;

                while(num != 0){
                    if(num%10==0) cnt++;

                    num /= 10;
                }

                memo[i] = cnt;
                result += memo[i];

            }

            System.out.println(result);


        }
    }
}
