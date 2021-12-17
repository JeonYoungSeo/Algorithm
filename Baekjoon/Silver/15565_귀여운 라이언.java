import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] line = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            line[i] = Integer.parseInt(st.nextToken());
        }

        int[] lion = new int[N];

        int start = 0;
        int end = 0;
        int num = 0;
        int result = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            if(line[i]==1){
                num++;

                lion[end] = i;
                end++;

                if(num==K){

                    result = Math.min(result, lion[end-1]-lion[start]+1);
                    num--;
                    start++;
                }
            }
        }

        if(result==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }

    }
}
